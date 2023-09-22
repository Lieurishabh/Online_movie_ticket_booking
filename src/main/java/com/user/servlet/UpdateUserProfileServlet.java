package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAOImpl;
import com.DB.DBConnect;
import com.entity.User;

/**
 * Servlet implementation class UpdateUserProfileServlet
 */
@WebServlet("/updateprofile")
public class UpdateUserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int pass_id=Integer.parseInt(request.getParameter("pass_id"));
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String position = request.getParameter("position");
			String pass = request.getParameter("pass");
			
			User us = new User();
			us.setPass_id(pass_id);
			us.setName(name);
			us.setEmail(email);
			us.setPhone(phone);
			us.setPosition(position);
			
			HttpSession session = request.getSession();
			
			UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
			boolean f = dao.checkPassword(pass_id,pass);
			if(f)
			{
				boolean f2=dao.updateEditUsers(us);
				if(f2) {
				session.setAttribute("success", "Updation Successfull!!!");
				response.sendRedirect("profile.jsp");
				}else {
					session.setAttribute("failed", "Something went wrong!!!");
					response.sendRedirect("profile.jsp");
				}
			}
			else {
				session.setAttribute("failed", "Incorrect Password!!!");
				response.sendRedirect("profile.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}
