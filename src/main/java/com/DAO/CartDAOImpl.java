package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.cart;

public class CartDAOImpl implements CartDAO {

	private Connection conn;

	public CartDAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean addcart(cart c) {
		boolean f = false;
		try {
			String sql = "insert into cart(seat_id,pass_id,mname,s_price,total_price,show_id) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getSeat_id());
			ps.setInt(2, c.getPass_id());
			ps.setString(3, c.getMname());
			ps.setInt(4, c.getS_price());
			ps.setInt(5, c.getTotal_price());
			ps.setInt(6, c.getShow_id());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public List<cart> getSeatByUser(int pass_id) {
		List<cart> list = new ArrayList<cart>();
		cart c = null;
		int totalPrice = 0;
		try {
			String sql = "select * from cart where pass_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pass_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				c = new cart();
				c.setC_id(rs.getInt(1));
				c.setSeat_id(rs.getInt(2));
				c.setPass_id(rs.getInt(3));
				c.setMname(rs.getString(4));
				c.setS_price(rs.getInt(5));

				totalPrice = totalPrice + rs.getInt(6);
				c.setTotal_price(totalPrice);
				
				c.setShow_id(rs.getInt(7));

				list.add(c);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean removeSeat(int seat_id, int pass_id) {
		boolean f = false;

		try {
			String sql = "delete from cart where seat_id=? and pass_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, seat_id);
			ps.setInt(2, pass_id);
			
			int i = ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
