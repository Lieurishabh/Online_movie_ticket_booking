package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;
import com.DAO.SeatDAOImpl;
import com.DAO.ShowDAOImpl;
import com.DB.DBConnect;
import com.entity.cart;
import com.entity.seat;
import com.entity.show;


/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	   try {
		   
		   int seat_id=Integer.parseInt(request.getParameter("seat_id"));
		   int pass_id=Integer.parseInt(request.getParameter("pass_id"));
		   int show_id=Integer.parseInt(request.getParameter("show_id"));
		   
		   
		   
		   SeatDAOImpl dao = new SeatDAOImpl(DBConnect.getConn());
		   seat s=dao.getSeatById(seat_id);
		   
		   ShowDAOImpl dao1 = new ShowDAOImpl(DBConnect.getConn());
		   show sh=dao1.getShowById(show_id);
		   
		   cart c=new cart();
		   c.setSeat_id(seat_id);
		   c.setPass_id(pass_id);
		   c.setMname(s.getSeat_type());
		   c.setS_price(s.getS_price());
		   c.setTotal_price(s.getS_price());
		   c.setShow_id(sh.getShow_id());
		   
		   CartDAOImpl dao3=new CartDAOImpl(DBConnect.getConn());
		   boolean f=dao3.addcart(c);
		   
		   HttpSession session=request.getSession();
		   
		   if(f) {
			   session.setAttribute("success", "Seat added to cart");
			   String paramName = "show_id";
			   int paramValue = sh.getShow_id();
			   String targetURL = "select_seats.jsp?" + paramName + "=" + paramValue;
			   response.sendRedirect(targetURL);

		   }else {
			   session.setAttribute("failed", "Something went wrong!!!!");
			   response.sendRedirect("home.jsp");
		   }
		   
		   
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	
	}

}
