package com.DAO;

import java.util.List;

import com.entity.cart;

public interface CartDAO {
	
	public boolean addcart(cart c);
	
	public List<cart> getSeatByUser(int pass_id);
	
	public boolean removeSeat(int seat_id, int pass_id);

}
