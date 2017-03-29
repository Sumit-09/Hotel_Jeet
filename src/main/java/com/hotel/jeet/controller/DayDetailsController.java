/**
 * 
 */
package com.hotel.jeet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.jeet.crud.repositary.RoomDataCrudRepositary;
import com.hotel.jeet.model.RoomData;

/**
 * @author jangfateh.singh
 *
 */
@Controller
public class DayDetailsController {

	@Autowired
	private RoomDataCrudRepositary roomDataCrudRepositary;

	@RequestMapping(value = "/allRoomsDetail", method = RequestMethod.GET)
	public ModelAndView getRoomDetails() {
		List<RoomData> allRoomList=roomDataCrudRepositary.findBydate("29-03-2017");
		return new ModelAndView("allRoomsDetail", "allRoomList",allRoomList);
	}
}
