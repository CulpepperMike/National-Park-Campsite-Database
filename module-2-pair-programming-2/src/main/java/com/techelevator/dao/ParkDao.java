package com.techelevator.dao;

import com.techelevator.model.Park;

import java.util.List;

public interface ParkDao {

    /**
	 * Get all parks from the datastore, ordered alphabetically (A-Z) by location.
	 * If there are no parks, return an empty List.
	 * 
	 * @return a List of Park objects
	 */
    List<Park> getParks();
}
