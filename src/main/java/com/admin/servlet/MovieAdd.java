package com.admin.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.Part;

import com.DAO.MovieDAOImpl;
import com.DB.DBConnect;
import com.entity.movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;

/**
 * Servlet implementation class MovieAdd
 */
@WebServlet("/addmovie")
@MultipartConfig
public class MovieAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String mname = request.getParameter("mname");
			String mcertify = request.getParameter("mcertify");
			String mlang = request.getParameter("mlang");
			String mtype = request.getParameter("mtype");
			String mdur = request.getParameter("mdur");
			String mdir = request.getParameter("mdir");
			String mcast = request.getParameter("mcast");
			String rdate = request.getParameter("rdate");
			Part part = request.getPart("mposter");
			String fileName = part.getSubmittedFileName();

			movie m = new movie(mname, mcertify, mlang, mtype, mdur, mdir, mcast, rdate, fileName);
			MovieDAOImpl dao=new MovieDAOImpl(DBConnect.getConn());
			
			
			boolean f = dao.addmovies(m);
			
			HttpSession session = request.getSession();
			
			if(f) {
				
				String path=getServletContext().getRealPath("")+"movie";
//				System.out.println(path);
				File file=new File(path);
				part.write(path + File.separator + fileName);
				
				session.setAttribute("success", "Movie added successfully");
				response.sendRedirect("admin/addmovie.jsp");
			}else {
				session.setAttribute("failed", "Something went wrong!!!");
				response.sendRedirect("admin/addmovie.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
