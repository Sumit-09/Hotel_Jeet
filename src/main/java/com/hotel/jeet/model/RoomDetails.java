package com.hotel.jeet.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roomDetails")
public class RoomDetails {

	@Id
	private String roomId;
	private RoomData roomData;

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
