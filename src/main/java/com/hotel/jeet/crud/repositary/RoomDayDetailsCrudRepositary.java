/**
 * 
 */
package com.hotel.jeet.crud.repositary;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.jeet.model.RoomData;
import com.hotel.jeet.model.RoomDayDetail;

/**
 * @author jangfateh.singh
 *
 */
@Repository
public interface RoomDayDetailsCrudRepositary extends CrudRepository<RoomDayDetail, String> {
	 List<RoomDayDetail> findBydate(String date);
}
