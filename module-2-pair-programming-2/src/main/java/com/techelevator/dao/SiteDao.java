package com.techelevator.dao;

import com.techelevator.model.Site;

import java.util.List;

public interface SiteDao {

	/**
	 * Get all sites that allow RVs in a park with the given id.
	 * A site allows RVs if its max RV length is greater than 0.
	 * If no sites are found, return an empty List.
	 * 
	 * @param parkId the id of the park to retrieve sites from
	 * @return a List of Site objects
	 */
    List<Site> getSitesWithRVAccessByParkId(int parkId);

    /**
	 * Get all sites that allow RVs in a park with the given id.
	 * If no sites are found, return an empty List.
	 * 
	 * @param parkId the id of the park to retrieve sites from
	 * @return a List of Site objects
	 */
    List<Site> getSitesWithoutReservationByParkId(int parkId);
}
