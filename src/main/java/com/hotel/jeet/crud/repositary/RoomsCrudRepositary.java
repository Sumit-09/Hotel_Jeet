/**
 * 
 */
package com.hotel.jeet.crud.repositary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.jeet.model.Rooms;

/**
 * @author jangfateh.singh
 *
 */
@Repository
public interface RoomsCrudRepositary extends CrudRepository<Rooms, Integer> {

}
