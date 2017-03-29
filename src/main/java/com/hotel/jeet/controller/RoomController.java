/**
 * 
 */
package com.hotel.jeet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.jeet.crud.repositary.RoomsCrudRepositary;
import com.hotel.jeet.model.Rooms;

/**
 * @author sumit.arora
 *
 */
@Controller
public class RoomController {

	@Autowired
	private RoomsCrudRepositary roomsCrudRepositary;

	@RequestMapping(value = "/addRooms", method = RequestMethod.GET)
	public ModelAndView addRoomAction() {
		return new ModelAndView("addRoom").addObject("room", new Rooms());
	}

	@RequestMapping(value = "/saveRooms", method = RequestMethod.POST)
	public ModelAndView addRoomToDb(@ModelAttribute("room") Rooms room) {
		room.setRoomId(Integer.valueOf(room.getRoomNumber()));
		System.out.println(room.getRoomId());
		roomsCrudRepositary.save(room);
		return new ModelAndView("addRoom").addObject("room", new Rooms());
	}
	
	@RequestMapping(value = "/listRooms", method = RequestMethod.GET)
	public ModelAndView getRoomList() {
		List<Rooms> roomList = (List<Rooms>) roomsCrudRepositary.findAll();
		return new ModelAndView("roomEntry", "listOfRooms", roomList).addObject("selectedRoom", new Rooms());
	}
}
