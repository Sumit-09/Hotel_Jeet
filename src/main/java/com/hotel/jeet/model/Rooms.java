/**
 * 
 */
package com.hotel.jeet.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author jangfateh.singh
 *
 */
@Document(collection = "rooms")
public class Rooms/* extends BaseModel*/{

	public String roomNumber;

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
}
