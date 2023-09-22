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

/**
 * Servlet implementation class MoviesDeleteServlet
 */
@WebServlet("/deleteuser")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int pass_id=Integer.parseInt(request.getParameter("pass_id"));
			
			UserDAOImpl dao=new UserDAOImpl(DBConnect.getConn());
			boolean f=dao.deleteUsers(pass_id);
			
			HttpSession session = request.getSession();
			
			if(f) {
				session.setAttribute("success", "Show Deleted");
				response.sendRedirect("admin/all_users.jsp");
			}else {
				session.setAttribute("failed", "Something went wrong!!!");
				response.sendRedirect("admin/all_users.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	

}
