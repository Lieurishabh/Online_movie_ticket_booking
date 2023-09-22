package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import com.DAO.UserDAOImpl;
import com.entity.User;
import com.DB.DBConnect;


@WebServlet("/login")
public class LogonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
			HttpSession session = request.getSession();
			
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			
			if("admin23@gmail.com".equals(email) && "admin143".equals(pass)) {
				User us = new User();
				us.setName("Admin");
				session.setAttribute("userobj", us);
				response.sendRedirect("admin/home1.jsp");
			}
			else {
				User us = dao.login(email, pass);
				if(us!=null) {
					session.setAttribute("userobj", us);
					response.sendRedirect("home.jsp");
				}else {
					session.setAttribute("failed", "Invalid Username or Password");
					response.sendRedirect("login.jsp");
				}
//				response.sendRedirect("home.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
