package com.DAO;

import java.util.List;

import com.entity.Seat_Book;

public interface SeatOrderDAO {
	
	public int getOrderNo();
	
	public boolean saveOrder(List<Seat_Book> blist);

}
