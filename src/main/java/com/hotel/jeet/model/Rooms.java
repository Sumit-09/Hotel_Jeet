/**
 * 
 */
package com.hotel.jeet.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author jangfateh.singh
 *
 */
@Document(collection = "rooms")
public class Rooms/* extends BaseModel */ {

	@Id
	public Integer roomId;

	public String roomNumber;

	public Integer getRoomId() {
		return roomId;
	}
	
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
}
