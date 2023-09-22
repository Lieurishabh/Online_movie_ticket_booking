package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.movie;

public class MovieDAOImpl implements MovieDAO {
	
	private Connection conn;

	public MovieDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addmovies(movie m) {
		boolean f=false;
		try {
			String query1 = "INSERT INTO movie(mname,mcertify,mlang,mtype,mdur,mdir,mcast,rdate,mposter) VALUES(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query1);
			ps.setString(1, m.getMname());
			ps.setString(2, m.getMcertify());
			ps.setString(3, m.getMlang());
			ps.setString(4, m.getMtype());
			ps.setString(5, m.getMdur());
			ps.setString(6, m.getMdir());
			ps.setString(7, m.getMcast());
			ps.setString(8, m.getRdate());
			ps.setString(9, m.getMposter());
			
			int i = ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	
	public List<movie> getAllMovies() {
		List<movie> list = new ArrayList<movie>();
		movie m=null;
		
		try {
			String query1="select * from movie";
			PreparedStatement ps = conn.prepareStatement(query1);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				m = new movie();
				m.setMovie_id(rs.getInt(1));
				m.setMname(rs.getString(2));
				m.setMcertify(rs.getString(3));
				m.setMlang(rs.getString(4));
				m.setMtype(rs.getString(5));
				m.setMdur(rs.getString(6));
				m.setMdir(rs.getString(7));
				m.setMcast(rs.getString(8));
				m.setRdate(rs.getString(9));
				m.setMposter(rs.getString(10));
				list.add(m);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public movie getMovieById(int movie_id) {
		movie m= null;
		
		try {
			String query1="select * from movie where movie_id=?";
			PreparedStatement ps = conn.prepareStatement(query1);
			ps.setInt(1, movie_id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				m=new movie();
				m.setMovie_id(rs.getInt(1));
				m.setMname(rs.getString(2));
				m.setMcertify(rs.getString(3));
				m.setMlang(rs.getString(4));
				m.setMtype(rs.getString(5));
				m.setMdur(rs.getString(6));
				m.setMdir(rs.getString(7));
				m.setMcast(rs.getString(8));
				m.setRdate(rs.getString(9));
				m.setMposter(rs.getString(10));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return m;
	}


	public boolean updateEditMovies(movie m) {
		boolean f=false;
		try {
			String query1="UPDATE movie SET mname=?,mcertify=?,mlang=?,mtype=?,mdur=?,mdir=?,mcast=?,rdate=? WHERE movie_id=?";
			PreparedStatement ps = conn.prepareStatement(query1);
			ps.setString(1, m.getMname());
			ps.setString(2, m.getMcertify());
			ps.setString(3, m.getMlang());
			ps.setString(4, m.getMtype());
			ps.setString(5, m.getMdur());
			ps.setString(6, m.getMdir());
			ps.setString(7, m.getMcast());
			ps.setString(8, m.getRdate());
			ps.setInt(9, m.getMovie_id());			
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
	public boolean deleteMovies(int movie_id) {
		boolean f=false;
		try {
			String query1="delete from movie where movie_id=?";
			PreparedStatement ps=conn.prepareStatement(query1);
			ps.setInt(1, movie_id);
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
	public movie getMovieByName(String mname) {
movie m= null;
		
		try {
			String query1="select * from movie where mname=?";
			PreparedStatement ps = conn.prepareStatement(query1);
			ps.setString(1, mname);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				m=new movie();
				m.setMovie_id(rs.getInt(1));
				m.setMname(rs.getString(2));
				m.setMcertify(rs.getString(3));
				m.setMlang(rs.getString(4));
				m.setMtype(rs.getString(5));
				m.setMdur(rs.getString(6));
				m.setMdir(rs.getString(7));
				m.setMcast(rs.getString(8));
				m.setRdate(rs.getString(9));
				m.setMposter(rs.getString(10));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	
	
	
	
	
	
	
	
	

}
