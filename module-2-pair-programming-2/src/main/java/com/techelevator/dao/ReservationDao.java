package com.techelevator.dao;

import com.techelevator.model.Reservation;

public interface ReservationDao {

    /**
	 * Get a reservation from the datastore that has the given id.
	 * If the id is not found, return null.
	 * 
	 * @param id the id of the reservation to get from the datastore
	 * @return the reservation object
	 */
    Reservation getReservationById(int id);

	/**
	 * Inserts a reservation into the datastore.
	 * 
	 * @param reservation the reservation object to insert
	 * @return the reservation object with its new id filled in
	 */
    Reservation createReservation(Reservation reservation);

}
