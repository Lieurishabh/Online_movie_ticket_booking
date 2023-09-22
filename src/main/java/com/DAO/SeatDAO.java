package com.DAO;

import java.util.List;

import com.entity.seat;

public interface SeatDAO {
	
	public boolean addseats(seat s);

	public List<seat> getAllSeats();

	public seat getSeatById(int seat_id);

}
