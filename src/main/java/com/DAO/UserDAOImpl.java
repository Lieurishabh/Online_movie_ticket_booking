package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.entity.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
	private Connection conn;

	public UserDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean userRegister(User us) {
		boolean f = false;

		try {
			String query = "insert into user_info1(name,gender,email,phone,position,pass,cpass) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, us.getName());
			ps.setString(2,us.getGender());
			ps.setString(3, us.getEmail());
			ps.setString(4, us.getPhone());
			ps.setString(5, us.getPosition());
			ps.setString(6, us.getPass());
			ps.setString(7, us.getCpass());

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
	public User login(String email, String pass) {
		User us = null;

		try {
			String query1 = "select * from user_info1 where email=? and pass=?";
			PreparedStatement ps = conn.prepareStatement(query1);
			ps.setString(1, email);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				us = new User();
				us.setName(rs.getString(2));
				us.setGender(rs.getString(3));
				us.setEmail(rs.getString(4));
				us.setPhone(rs.getString(5));
				us.setPosition(rs.getString(6));
				us.setPass(rs.getString(7));
				us.setCpass(rs.getString(8));
				us.setPass_id(rs.getInt(1));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return us;
	}

	@Override
	public List<User> getAllusers() {
		List<User> list = new ArrayList<User>();
		User us=null;
		
		try {
			String query1="select * from user_info1";
			PreparedStatement ps = conn.prepareStatement(query1);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				us = new User();
				us.setPass_id(rs.getInt(1));
				us.setName(rs.getString(2));
				us.setGender(rs.getString(3));
				us.setEmail(rs.getString(4));
				us.setPhone(rs.getString(5));
				us.setPosition(rs.getString(6));
				us.setPass(rs.getString(7));
				us.setCpass(rs.getString(8));
				us.setW_limit(rs.getInt(9));
				list.add(us);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public User getUserById(int pass_id) {
User us= null;
		
		try {
			String query1="select * from user_info1 where pass_id=?";
			PreparedStatement ps = conn.prepareStatement(query1);
			ps.setInt(1, pass_id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				us = new User();
				us.setPass_id(rs.getInt(1));
				us.setName(rs.getString(2));
				us.setGender(rs.getString(3));
				us.setEmail(rs.getString(4));
				us.setPhone(rs.getString(5));
				us.setPosition(rs.getString(6));
				us.setPass(rs.getString(7));
				us.setCpass(rs.getString(8));
				us.setW_limit(rs.getInt(9));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return us;
	}

//	@Override
//	public boolean updateEditUsers(User s) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public boolean deleteUsers(int pass_id) {
		boolean f = false;
		try {
			String query1 = "delete from user_info1 where pass_id=?";
			PreparedStatement ps = conn.prepareStatement(query1);
			ps.setInt(1, pass_id);
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
	public boolean updateEditUsers(User us) {
		boolean f=false;
		try {
			String sql = "update user_info1 set name=?,email=?,phone=?,position=? where pass_id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPhone());
			ps.setString(4, us.getPosition());
			ps.setInt(5, us.getPass_id());
			
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
	public boolean checkPassword(int pass_id, String pass) {
		boolean f = false;
		try {
			String sql = "select * from user_info1 where pass_id=? and pass=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, pass_id);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				f=true;
			}
	}catch(Exception e) {
		e.printStackTrace();
		}
		return f;
	}
	
	

}
