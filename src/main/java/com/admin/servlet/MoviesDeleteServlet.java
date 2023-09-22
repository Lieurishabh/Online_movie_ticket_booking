package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.MovieDAOImpl;
import com.DB.DBConnect;

/**
 * Servlet implementation class MoviesDeleteServlet
 */
@WebServlet("/delete")
public class MoviesDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int movie_id=Integer.parseInt(request.getParameter("movie_id"));
			
			MovieDAOImpl dao=new MovieDAOImpl(DBConnect.getConn());
			boolean f=dao.deleteMovies(movie_id);
			
			HttpSession session = request.getSession();
			
			if(f) {
				session.setAttribute("success", "Movie Deleted");
				response.sendRedirect("admin/all_movie.jsp");
			}else {
				session.setAttribute("failed", "Something went wrong!!!");
				response.sendRedirect("admin/all_movie.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	

}
