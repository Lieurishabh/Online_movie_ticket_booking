package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.show;

public class ShowDAOImpl implements ShowDAO{
	private Connection conn;

	public ShowDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addshows(show s) {
		boolean f=false;
		try {
			String query1 = "insert into show(movie_id,smname,stime,etime,sdate) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query1);
			ps.setInt(1, s.getMovie_id());
			ps.setString(2, s.getSmname());
			ps.setString(3, s.getStime());
			ps.setString(4, s.getEtime());
			ps.setString(5, s.getSdate());
			int i = ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<show> getAllshows() {
		List<show> list = new ArrayList<show>();
		show s=null;
		
		try {
			String query1="select * from show";
			PreparedStatement ps = conn.prepareStatement(query1);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				s = new show();
				s.setShow_id(rs.getInt(1));
				s.setMovie_id(rs.getInt(2));
				s.setSmname(rs.getString(3));
				s.setStime(rs.getString(4));
				s.setEtime(rs.getString(5));
				s.setSdate(rs.getString(6));
				list.add(s);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public show getShowById(int show_id) {
		show s= null;
		
		try {
			String query1="select * from show where show_id=?";
			PreparedStatement ps = conn.prepareStatement(query1);
			ps.setInt(1, show_id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				s=new show();
				s.setShow_id(rs.getInt(1));
				s.setMovie_id(rs.getInt(2));
				s.setSmname(rs.getString(3));
				s.setStime(rs.getString(4));
				s.setEtime(rs.getString(5));
				s.setSdate(rs.getString(6));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return s;
	}


	public boolean updateEditShows(show s) {
		boolean f=false;
		try {
			String query1="UPDATE show SET movie_id=?,smname=?,stime=?,etime=?,sdate=? WHERE show_id=?";
			PreparedStatement ps = conn.prepareStatement(query1);
			ps.setInt(1, s.getMovie_id());
			ps.setString(2, s.getSmname());
			ps.setString(3, s.getStime());
			ps.setString(4, s.getEtime());
			ps.setString(5, s.getSdate());
			ps.setInt(6, s.getShow_id());		
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean deleteShows(int show_id) {
		boolean f=false;
		try {
			String query1="delete from show where show_id=?";
			PreparedStatement ps=conn.prepareStatement(query1);
			ps.setInt(1, show_id);
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	

	

}
