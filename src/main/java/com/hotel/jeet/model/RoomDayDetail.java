package com.hotel.jeet.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roomDayDetails")
public class RoomDayDetail {

	@Id
	private String roomDay;
	private Set<RoomData> roomData = new HashSet<>();

	public String getRoomDay() {
		return roomDay;
	}

	public void setRoomDay(String roomDay) {
		this.roomDay = roomDay;
	}

	public Set<RoomData> getRoomData() {
		return roomData;
	}

	public void setRoomData(Set<RoomData> roomData) {
		this.roomData = roomData;
	}
}
