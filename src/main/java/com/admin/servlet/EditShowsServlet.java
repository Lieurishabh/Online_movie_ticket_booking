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
import com.entity.show;

/**
 * Servlet implementation class EditMoviesServlet
 */
@WebServlet("/editshows")
public class EditShowsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int show_id=Integer.parseInt(request.getParameter("show_id"));
			int movie_id=Integer.parseInt(request.getParameter("movie_id"));
			String smname=request.getParameter("smname");
			String stime=request.getParameter("stime");
			String etime=request.getParameter("etime");
			String sdate=request.getParameter("sdate");
			show s = new show();
			s.setShow_id(show_id);
			s.setMovie_id(movie_id);
			s.setSmname(smname);
			s.setStime(stime);
			s.setEtime(etime);
			s.setSdate(sdate);
			
			ShowDAOImpl dao=new ShowDAOImpl(DBConnect.getConn());
			boolean f=dao.updateEditShows(s);
			
			HttpSession session=request.getSession();
			
			if(f) {
				session.setAttribute("success","Show details updated");
				response.sendRedirect("admin/show_list.jsp");
				
			}else {
				session.setAttribute("failed","Something went wrong");
				response.sendRedirect("admin/show_list.jsp");
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
