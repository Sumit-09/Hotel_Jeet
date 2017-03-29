/**
 * 
 */
package com.hotel.jeet.crud.repositary;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hotel.jeet.model.RoomData;

/**
 * @author jangfateh.singh
 *
 */
@Repository
public interface RoomDataCrudRepositary extends CrudRepository<RoomData, String> {

    List<RoomData> findBydate(String date);
}
