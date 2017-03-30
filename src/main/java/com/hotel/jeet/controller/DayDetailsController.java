/**
 * 
 */
package com.hotel.jeet.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.jeet.crud.repositary.RoomDayDetailsCrudRepositary;
import com.hotel.jeet.model.RoomData;
import com.hotel.jeet.model.RoomDayDetail;
import com.hotel.jeet.model.Months;

/**
 * @author jangfateh.singh
 *
 */
@Controller
@PropertySource("classpath:mongoDb.properties")
public class DayDetailsController {

	@Autowired
	private RoomDayDetailsCrudRepositary roomDayDetailsCrudRepositary;
	
	@Value("${excel.file.path}")
	private String excelFilePath;

	@RequestMapping(value = "/allRoomsDetail", method = RequestMethod.GET)
	public ModelAndView getRoomDetails() {
		StringBuilder dateString = new StringBuilder();
		Date today = new Date();
		Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
		cal.setTime(today);
		dateString.append(cal.get(5)).append("-").append(Months.getMonthNameByMonthNumber(cal.get(2))).append("-").append(cal.get(1));
		List<RoomDayDetail> roomDayDetailList = roomDayDetailsCrudRepositary.findBydate(dateString.toString());
		List<RoomData> allRoomList = new ArrayList<>();
		for (RoomDayDetail roomDayDetail : roomDayDetailList) {
			allRoomList.addAll(roomDayDetail.getRoomData());
		}
		exportToExcel(allRoomList,dateString.toString());
		return new ModelAndView("allRoomsDetail", "allRoomList", allRoomList);
	}

	// @RequestMapping(value = "/exportIntoExcel", method = RequestMethod.POST)
	public void exportToExcel(List<RoomData> allRoomList, String fileName) {
		
		int totalRent=0;
		int totalCommission=0;
		for(RoomData roomData : allRoomList){
			totalRent=totalRent+roomData.getRent();
			totalCommission=totalCommission+roomData.getCommission();
		}
		int totalEarning=totalRent-totalCommission;		
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		createHeaderRow(sheet);
		int rowCount = 0;

		for (RoomData roomData : allRoomList) {
			Row row = sheet.createRow(++rowCount);
			writeBook(roomData, row, sheet);
		}
        writeTotatInExcel(totalRent,totalCommission,totalEarning, rowCount, sheet);
		try (FileOutputStream outputStream = new FileOutputStream(new File(new StringBuilder(excelFilePath).append(fileName).append(".xls").toString()))) {
			workbook.write(outputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeTotatInExcel(int totalRent, int totalCommission, int totalEarning, int rowCount, Sheet sheet) {
		Row row = sheet.createRow(++rowCount);
		Cell cell = row.createCell(7);
		cell.setCellValue(totalRent);
		cell = row.createCell(8);
		cell.setCellValue(totalCommission);
		rowCount++;
		CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		cellStyle.setBorderBottom(BorderStyle.MEDIUM);
		cellStyle.setBorderTop(BorderStyle.MEDIUM);
		cellStyle.setBorderRight(BorderStyle.MEDIUM);
		cellStyle.setBorderLeft(BorderStyle.MEDIUM);
		Font font = sheet.getWorkbook().createFont();
		font.setBold(true);
		font.setFontHeightInPoints((short) 12);
		cellStyle.setFont(font);

		row = sheet.createRow(rowCount);
		Cell cellRoomNo = row.createCell(1);

		cellRoomNo.setCellStyle(cellStyle);
		cellRoomNo.setCellValue("Total Earning");
		rowCount++;
		row = sheet.createRow(rowCount);
		cell = row.createCell(1);
		cell.setCellValue(totalEarning);
		cell.setCellStyle(cellStyle);
	}

	private void createHeaderRow(Sheet sheet) {

		CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		cellStyle.setBorderBottom(BorderStyle.MEDIUM);
		cellStyle.setBorderTop(BorderStyle.MEDIUM);
		cellStyle.setBorderRight(BorderStyle.MEDIUM);
		cellStyle.setBorderLeft(BorderStyle.MEDIUM);
		Font font = sheet.getWorkbook().createFont();
		font.setBold(true);
		font.setFontHeightInPoints((short) 12);
		cellStyle.setFont(font);

		Row row = sheet.createRow(0);
		Cell cellRoomNo = row.createCell(1);

		cellRoomNo.setCellStyle(cellStyle);
		cellRoomNo.setCellValue("Room No");

		Cell cellName = row.createCell(2);
		cellName.setCellStyle(cellStyle);
		cellName.setCellValue("Name");

		Cell cellAddress = row.createCell(3);
		cellAddress.setCellStyle(cellStyle);
		cellAddress.setCellValue("Address");

		Cell personalIdType = row.createCell(4);
		personalIdType.setCellStyle(cellStyle);
		personalIdType.setCellValue("Personal Id Type");

		Cell personalIdNo = row.createCell(5);
		personalIdNo.setCellStyle(cellStyle);
		personalIdNo.setCellValue("Personal Id No");

		Cell personalIdPhotoLocation = row.createCell(6);
		personalIdPhotoLocation.setCellStyle(cellStyle);
		personalIdPhotoLocation.setCellValue("Personal Id Photo Location");

		Cell cellRent = row.createCell(7);
		cellRent.setCellStyle(cellStyle);
		cellRent.setCellValue("Rent");

		Cell cellCommisson = row.createCell(8);
		cellCommisson.setCellStyle(cellStyle);
		cellCommisson.setCellValue("Commission");

		Cell cellNumberOfDaysStay = row.createCell(9);
		cellNumberOfDaysStay.setCellStyle(cellStyle);
		cellNumberOfDaysStay.setCellValue("Number of Days stay");

		Cell celldate = row.createCell(10);
		celldate.setCellStyle(cellStyle);
		celldate.setCellValue("Date");
	}

	private void writeBook(RoomData roomData, Row row, Sheet sheet) {
		CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		cellStyle.setBorderBottom(BorderStyle.MEDIUM);
		cellStyle.setBorderTop(BorderStyle.MEDIUM);
		cellStyle.setBorderRight(BorderStyle.MEDIUM);
		cellStyle.setBorderLeft(BorderStyle.MEDIUM);
		Cell cell = row.createCell(1);
		cell.setCellValue(roomData.getRoomNo());
		cell.setCellStyle(cellStyle);

		cell = row.createCell(2);
		cell.setCellValue(roomData.getName());
		cell.setCellStyle(cellStyle);

		cell = row.createCell(3);
		cell.setCellValue(roomData.getAddress());
		cell.setCellStyle(cellStyle);

		cell = row.createCell(3);
		cell.setCellValue(roomData.getAddress());
		cell.setCellStyle(cellStyle);

		cell = row.createCell(4);
		cell.setCellValue(roomData.getPersonalId());
		cell.setCellStyle(cellStyle);

		cell = row.createCell(5);
		cell.setCellValue(roomData.getPersonalIdNo());
		cell.setCellStyle(cellStyle);

		cell = row.createCell(6);
		cell.setCellValue(roomData.getPhoto());
		cell.setCellStyle(cellStyle);

		cell = row.createCell(7);
		cell.setCellValue(roomData.getRent());
		cell.setCellStyle(cellStyle);

		cell = row.createCell(8);
		cell.setCellValue(roomData.getCommission());
		cell.setCellStyle(cellStyle);

		cell = row.createCell(9);
		cell.setCellValue(roomData.getNumberOfDays());
		cell.setCellStyle(cellStyle);
		
		cell = row.createCell(10);
		cell.setCellValue(roomData.getDate());
		cell.setCellStyle(cellStyle);
	}
}
