package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAOImpl;
import com.entity.User;
import com.DB.DBConnect;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registeration")
public class RegisterServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String position = request.getParameter("position");
			String pass = request.getParameter("pass");
			String cpass = request.getParameter("cpass");
			
			User us = new User();
			us.setName(name);
			us.setGender(gender);
			us.setEmail(email);
			us.setPhone(phone);
			us.setPosition(position);
			us.setPass(pass);
			us.setCpass(cpass);
			
			HttpSession session = request.getSession();
			
			UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
			boolean f = dao.userRegister(us);
			if(f)
			{
				session.setAttribute("success", "Registration Successfull!!!");
				response.sendRedirect("registration.jsp");
			}
			else {
				session.setAttribute("failed", "Something went wrong!!!");
				response.sendRedirect("registration.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
