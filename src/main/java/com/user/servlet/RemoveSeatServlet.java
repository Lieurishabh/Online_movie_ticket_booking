package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;
import com.DB.DBConnect;

/**
 * Servlet implementation class RemoveSeatServlet
 */
@WebServlet("/removeSeat")
public class RemoveSeatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seat_id=Integer.parseInt(request.getParameter("seat_id"));
		int pass_id=Integer.parseInt(request.getParameter("pass_id"));
		
		CartDAOImpl dao = new CartDAOImpl(DBConnect.getConn());
		boolean f=dao.removeSeat(seat_id,pass_id);
		
		HttpSession session = request.getSession();
		
		if(f) {
			session.setAttribute("success", "Seat Removed Successfully");
			response.sendRedirect("checkout.jsp");
		}else {
			session.setAttribute("failed", "Something went Wrong!!!!");
			response.sendRedirect("checkout.jsp");
		}
	}



}
