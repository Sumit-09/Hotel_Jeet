/**
 * 
 */
package com.hotel.jeet.crud.repositary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.jeet.model.RoomData;

/**
 * @author jangfateh.singh
 *
 */
@Repository
public interface RoomDetailsCrudRepositary extends CrudRepository<RoomData, String> {

}
