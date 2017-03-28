package com.hotel.jeet.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roomDetails")
public class RoomDetails {

	private RoomData roomData;
	private String roomId;

	public RoomData getRoomData() {
		return roomData;
	}

	public void setRoomData(RoomData roomData) {
		this.roomData = roomData;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

}
