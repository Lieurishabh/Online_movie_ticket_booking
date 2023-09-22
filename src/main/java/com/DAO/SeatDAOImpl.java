package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.seat;

public class SeatDAOImpl implements SeatDAO {
	
	private Connection conn;
	
	

	public SeatDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	
	

	@Override
	public boolean addseats(seat s) {
		boolean f=false;
		try {
			String query1 = "insert into seat_map(seat_id,seat_type,s_price,s_status) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query1);
			ps.setInt(1, s.getSeat_id());
			ps.setString(2, s.getSeat_type());
			ps.setInt(3, s.getS_price());
			ps.setString(4, s.getS_status());

			int i = ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}



	@Override
	public List<seat> getAllSeats() {
		List<seat> list = new ArrayList<seat>();
		seat s=null;
		
		try {
			String query1="select * from seat_map";
			PreparedStatement ps = conn.prepareStatement(query1);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				s = new seat();
				s.setSeat_id(rs.getInt(1));
				s.setSeat_type(rs.getString(2));
				s.setS_price(rs.getInt(3));
				s.setS_status(rs.getString(4));
				s.setShow_id(rs.getInt(5));
				list.add(s);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public seat getSeatById(int seat_id) {
seat s= null;
		
		try {
			String query1="select * from seat_map where seat_id=?";
			PreparedStatement ps = conn.prepareStatement(query1);
			ps.setInt(1, seat_id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				s = new seat();
				s.setSeat_id(rs.getInt(1));
				s.setSeat_type(rs.getString(2));
				s.setS_price(rs.getInt(3));
				s.setS_status(rs.getString(4));
				s.setShow_id(rs.getInt(5));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	

}
