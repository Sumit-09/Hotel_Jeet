/**
 * 
 */
package com.hotel.jeet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.jeet.model.RoomData;
import com.hotel.jeet.model.Rooms;

/**
 * @author sumit.arora
 *
 */
@Controller
public class FirstController {

	@Autowired
	MongoTemplate mongoTemplate;

	@RequestMapping(value = "/listRooms", method = RequestMethod.GET)
	public ModelAndView getRoomList() {
		System.out.println("111" + mongoTemplate);
		List<Rooms> roomList = mongoTemplate.findAll(Rooms.class);
		return new ModelAndView("roomEntry", "listOfRooms", roomList).addObject("selectedRoom", new Rooms());
	}

	@RequestMapping(value = "/selectRooms", method = RequestMethod.POST)
	public ModelAndView getRoomDetails(@ModelAttribute("selectedRoom") Rooms rooms, BindingResult result) {
		System.out.println("222" + rooms.getRoomNumber());
		List<Rooms> roomList = mongoTemplate.findAll(Rooms.class);
		return new ModelAndView("roomEntry", "listOfRooms", roomList);
	}

	@RequestMapping(value = "/bookRoom", method = RequestMethod.POST)
	public ModelAndView bookRoom(HttpServletRequest request) {
		System.out.println("book Room " + mongoTemplate);
		String roomNumber = request.getParameter("roomNumber");
		// List<Rooms> roomList = mongoTemplate.findAll(Rooms.class);
		System.out.println("Room No : " + request.getParameter("roomNumber"));
		return new ModelAndView("RoomDetails", "roomNumber", roomNumber).addObject("roomDetails", new RoomData());
	}

	@RequestMapping(value = "/roomData", method = RequestMethod.POST)
	public ModelAndView saveRoomData(@ModelAttribute("roomDetails") RoomData roomdata) {
		System.out.println("Name=" + roomdata.getName());
		System.out.println("Commission=" + roomdata.getCommission());
		roomdata.setRoomID(roomdata.getRoomNo() + "-" + roomdata.getDate());
		// System.out.println("Request data " +
		// request.getParameter("personName"));
		mongoTemplate.save(roomdata);
		System.out.println("Document Saved");
		return new ModelAndView("DataSaved");
	}
}
