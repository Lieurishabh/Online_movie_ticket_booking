package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


import com.DAO.ShowDAOImpl;
import com.DB.DBConnect;
import com.entity.show;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class MovieAdd
 */
@WebServlet("/addshow")
public class ShowAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int movie_id=Integer.parseInt(request.getParameter("movie_id"));
			String smname = request.getParameter("smname");
			String stime = request.getParameter("stime");
			String etime = request.getParameter("etime");
			String sdate = request.getParameter("sdate");

			show s = new show(movie_id, smname, stime, etime, sdate);
			ShowDAOImpl dao=new ShowDAOImpl(DBConnect.getConn());
			
			
			boolean f = dao.addshows(s);
			
			HttpSession session = request.getSession();
			
			if(f) {
				session.setAttribute("success", "Show added successfully");
				response.sendRedirect("admin/addshow.jsp");
			}else {
				session.setAttribute("failed", "Something went wrong!!!");
				response.sendRedirect("admin/addshow.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
