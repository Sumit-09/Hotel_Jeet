/**
 * 
 */
package com.hotel.jeet.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.jeet.crud.repositary.RoomDataCrudRepositary;
import com.hotel.jeet.crud.repositary.RoomDayDetailsCrudRepositary;
import com.hotel.jeet.model.RoomData;
import com.hotel.jeet.model.RoomDayDetail;

/**
 * @author sumit.arora
 *
 */
@Controller
public class RoomCRUDController {

	@Autowired
	private RoomDayDetailsCrudRepositary roomDayDetailsCrudRepositary;

	@RequestMapping(value = "/bookRoom", method = RequestMethod.POST)
	public ModelAndView bookRoom(HttpServletRequest request) {
		String roomNumber = request.getParameter("roomNumber");
		return new ModelAndView("RoomDetails", "roomNumber", roomNumber).addObject("roomDetails", new RoomData());
	}

	@RequestMapping(value = "/roomData", method = RequestMethod.POST)
	public ModelAndView saveRoomData(@ModelAttribute("roomDetails") RoomData roomdata) {
		roomdata.setRoomID(roomdata.getRoomNo() + "-" + roomdata.getDate());
		RoomDayDetail roomDayDetail = new RoomDayDetail();
		if(roomDayDetailsCrudRepositary.findOne(roomdata.getRoomNo() + "-" + roomdata.getDate()) == null){
			roomDayDetail.getRoomData().add(roomdata);
			roomDayDetail.setRoomDay(roomdata.getRoomNo() + "-" + roomdata.getDate());
			roomDayDetailsCrudRepositary.save(roomDayDetail);
		}else if (roomDayDetailsCrudRepositary.findOne(roomdata.getRoomNo() + "-" + roomdata.getDate()) != null){
			roomDayDetail= roomDayDetailsCrudRepositary.findOne(roomdata.getRoomNo() + "-" + roomdata.getDate());
			roomDayDetail.getRoomData().add(roomdata);
			roomDayDetailsCrudRepositary.save(roomDayDetail);
		}
		System.out.println("Document Saved");
		return new ModelAndView("DataSaved");
	}

}
