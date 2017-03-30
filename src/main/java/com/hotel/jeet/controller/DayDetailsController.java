/**
 * 
 */
package com.hotel.jeet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.jeet.crud.repositary.RoomDayDetailsCrudRepositary;
import com.hotel.jeet.model.RoomData;
import com.hotel.jeet.model.RoomDayDetail;

/**
 * @author jangfateh.singh
 *
 */
@Controller
public class DayDetailsController {

	@Autowired
	private RoomDayDetailsCrudRepositary roomDayDetailsCrudRepositary;

	@RequestMapping(value = "/allRoomsDetail", method = RequestMethod.GET)
	public ModelAndView getRoomDetails() {
		List<RoomDayDetail> roomDayDetailList = roomDayDetailsCrudRepositary.findBydate("29-03-2017");
		List<RoomData> allRoomList = new ArrayList<>();
		for (RoomDayDetail roomDayDetail : roomDayDetailList) {
			allRoomList.addAll(roomDayDetail.getRoomData());
		}
		return new ModelAndView("allRoomsDetail", "allRoomList", allRoomList);
	}
}
