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
import com.entity.movie;

/**
 * Servlet implementation class EditMoviesServlet
 */
@WebServlet("/editmovies")
public class EditMoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int movie_id=Integer.parseInt(request.getParameter("movie_id"));
			String mname=request.getParameter("mname");
			String mcertify=request.getParameter("mcertify");
			String mlang=request.getParameter("mlang");
			String mtype=request.getParameter("mtype");
			String mdur=request.getParameter("mdur");
			String mdir=request.getParameter("mdir");
			String mcast=request.getParameter("mcast");
			String rdate=request.getParameter("rdate");
			
			movie m = new movie();
			m.setMovie_id(movie_id);
			m.setMname(mname);
			m.setMcertify(mcertify);
			m.setMlang(mlang);
			m.setMtype(mtype);
			m.setMdur(mdur);
			m.setMdir(mdir);
			m.setMcast(mcast);
			m.setRdate(rdate);
			
			MovieDAOImpl dao=new MovieDAOImpl(DBConnect.getConn());
			boolean f=dao.updateEditMovies(m);
			
			HttpSession session=request.getSession();
			
			if(f) {
				session.setAttribute("success","Movie details updated");
				response.sendRedirect("admin/all_movie.jsp");
				
			}else {
				session.setAttribute("failed","Something went wrong");
				response.sendRedirect("admin/all_movie.jsp");
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
