package com.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;
import com.DAO.SeatOrderDAOImpl;
import com.DB.DBConnect;
import com.entity.Seat_Book;
import com.entity.cart;

@WebServlet("/ordernow")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		try {
			int pass_id = Integer.parseInt(request.getParameter("pass_id"));
			String position = request.getParameter("position");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String smname = request.getParameter("smname");
			String sdate = request.getParameter("sdate");
			String stime = request.getParameter("stime");
			String w_limit = request.getParameter("w_limit");
			String payment = request.getParameter("payment");

			CartDAOImpl dao = new CartDAOImpl(DBConnect.getConn());

			List<cart> blist = dao.getSeatByUser(pass_id);

			SeatOrderDAOImpl dao2 = new SeatOrderDAOImpl(DBConnect.getConn());

			Seat_Book o = null;

			ArrayList<Seat_Book> orderList = new ArrayList<Seat_Book>();

			for (cart c : blist) {
				o = new Seat_Book();
				o.setPass_id(pass_id);
				o.setPosition(position);
				o.setName(name);
				o.setEmail(email);
				o.setPhone(phone);
				o.setSmname(smname);
				o.setSdate(sdate);
				o.setStime(stime);
				o.setW_limit(w_limit);
				o.setPayment(payment);
				o.setShow_id(c.getShow_id());
				o.setSeat_id(c.getSeat_id());
				o.setSeat_type(c.getMname());
				o.setS_price(c.getS_price());

				orderList.add(o);

			}
			boolean f = dao2.saveOrder(orderList);
			if(f) {
				session.setAttribute("success", "Seat Booked Successfully");
				response.sendRedirect("ticket.jsp");
			}else {
				session.setAttribute("failed", "Something went Wrong!!!!");
				response.sendRedirect("checkout.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
