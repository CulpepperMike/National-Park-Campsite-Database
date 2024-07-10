package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Reservation;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcReservationDao implements ReservationDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcReservationDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override 
    public Reservation getReservationById(int id) {
        Reservation reservation = null;
        String sql = "Select * FROM reservation WHERE reservation_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next())
                reservation = mapRowToReservation(results);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation.", e);
        }
        return reservation;
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        Reservation newReservation = null;
        String sql = "INSERT INTO reservation (site_id, name, from_date, to_date, " +
                "create_date) VALUES (?, ?, ?, ?, ?) RETURNING reservation_id;";
        try {
            int newReservationId = jdbcTemplate.queryForObject(sql, int.class, reservation.getSiteId(),
                    reservation.getName(), reservation.getFromDate(), reservation.getToDate(), reservation.getCreateDate());
            newReservation = getReservationById(newReservationId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation.", e);
        }
        return newReservation;
    }

    private Reservation mapRowToReservation(SqlRowSet results) {
        Reservation reservation = new Reservation();
        reservation.setReservationId(results.getInt("reservation_id"));
        reservation.setSiteId(results.getInt("site_id"));
        reservation.setName(results.getString("name"));
        reservation.setFromDate(results.getDate("from_date").toLocalDate());
        reservation.setToDate(results.getDate("to_date").toLocalDate());
        reservation.setCreateDate(results.getDate("create_date").toLocalDate());
        return reservation;
    }


}
