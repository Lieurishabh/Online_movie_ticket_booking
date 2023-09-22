package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.ShowDAOImpl;
import com.DB.DBConnect;

/**
 * Servlet implementation class MoviesDeleteServlet
 */
@WebServlet("/deleteshow")
public class ShowsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int show_id=Integer.parseInt(request.getParameter("show_id"));
			
			ShowDAOImpl dao=new ShowDAOImpl(DBConnect.getConn());
			boolean f=dao.deleteShows(show_id);
			
			HttpSession session = request.getSession();
			
			if(f) {
				session.setAttribute("success", "Show Deleted");
				response.sendRedirect("admin/show_list.jsp");
			}else {
				session.setAttribute("failed", "Something went wrong!!!");
				response.sendRedirect("admin/show_list.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	

}
