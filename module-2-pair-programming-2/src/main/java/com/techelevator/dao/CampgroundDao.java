package com.techelevator.dao;

import com.techelevator.model.Campground;

import java.util.List;

public interface CampgroundDao {

	/**
	 * Get a specific campground with the given id.
	 * If the id is not found, return null.
	 * 
	 * @param id the id of the campground to retrieve
	 * @return a Campground object
	 */
    Campground getCampgroundById(int id);

    /**
	 * Get all the campsites from a park with the given id.
	 * If the id is not found, return an empty List.
	 * 
	 * @param parkId the id of the park to retrieve campgrounds from
	 * @return a List of Campground objects
	 */
    List<Campground> getCampgroundsByParkId(int parkId);
}
