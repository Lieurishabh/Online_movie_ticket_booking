package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.entity.Seat_Book;

public class SeatOrderDAOImpl implements SeatOrderDAO {

	private Connection conn;

	public SeatOrderDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public int getOrderNo() {
		int i = 1;
		try {

			String sql = "select * from ticket";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public boolean saveOrder(List<Seat_Book> blist) {
		boolean f = false;
		try {

			String sql = "insert into ticket(tkt_id,pass_id,show_id,seat_id,position,name,email,phone,smname,sdate,stime,w_limit,payment,seat_type,s_price) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			
			for(Seat_Book s:blist) {
				ps.setInt(1, s.getTkt_id());
				ps.setInt(2, s.getPass_id());
				ps.setInt(3, s.getShow_id());
				ps.setInt(4, s.getSeat_id());
				ps.setString(5, s.getPosition());
				ps.setString(6, s.getName());
				ps.setString(7, s.getEmail());
				ps.setString(8, s.getPhone());
				ps.setString(9, s.getSmname());
				ps.setString(10, s.getSdate());
				ps.setString(11, s.getStime());
				ps.setString(12, s.getW_limit());
				ps.setString(13, s.getPayment());
				ps.setString(14, s.getSeat_type());
				ps.setInt(15, s.getS_price());
				ps.addBatch();
			}
			
			int[] counter = ps.executeBatch();
			conn.commit();
			f=true;
			conn.setAutoCommit(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
