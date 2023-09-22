package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


import com.DAO.SeatDAOImpl;
import com.DB.DBConnect;
import com.entity.seat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class MovieAdd
 */
@WebServlet("/addseat")
public class SeatAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String seat_type = request.getParameter("seat_type");
			int s_price = Integer.parseInt(request.getParameter("s_price"));
			String s_status = request.getParameter("s_status");

			seat s = new seat(seat_type, s_price, s_status);
			SeatDAOImpl dao=new SeatDAOImpl(DBConnect.getConn());
			
			
			boolean f = dao.addseats(s);
			
			HttpSession session = request.getSession();
			
			if(f) {
				session.setAttribute("success", "Seat added successfully");
				response.sendRedirect("admin/addseat.jsp");
			}else {
				session.setAttribute("failed", "Something went wrong!!!");
				response.sendRedirect("admin/addseat.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
