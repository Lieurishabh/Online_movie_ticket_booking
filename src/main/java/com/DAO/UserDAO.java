package com.DAO;
import java.util.List;

import com.entity.User;

public interface UserDAO {
	public boolean userRegister(User us);
	
	public User login(String email,String pass);
	
	public List<User> getAllusers();

	public User getUserById(int pass_id);

	public boolean updateEditUsers(User us);

	public boolean deleteUsers(int pass_id);
	
	public boolean checkPassword(int pass_id,String pass);

}
