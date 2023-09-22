package com.entity;

public class Seat_Book {
	private int tkt_id;
	private int pass_id;
	private String position;
	private String name ;
	private String email;
	private String phone ;
	private String smname ;
	private String sdate ;
	private String stime ;
	private String w_limit; 
	private String payment ;
	private int show_id;
	private int seat_id;
	private String seat_type;
	private int s_price;
	
	public Seat_Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPass_id() {
		return pass_id;
	}

	public void setPass_id(int pass_id) {
		this.pass_id = pass_id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSmname() {
		return smname;
	}

	public void setSmname(String smname) {
		this.smname = smname;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getW_limit() {
		return w_limit;
	}

	public void setW_limit(String w_limit) {
		this.w_limit = w_limit;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getTkt_id() {
		return tkt_id;
	}

	public void setTkt_id(int tkt_id) {
		this.tkt_id = tkt_id;
	}
	
	

	public int getShow_id() {
		return show_id;
	}

	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}

	public int getSeat_id() {
		return seat_id;
	}

	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}

	public String getSeat_type() {
		return seat_type;
	}

	public void setSeat_type(String seat_type) {
		this.seat_type = seat_type;
	}

	public int getS_price() {
		return s_price;
	}

	public void setS_price(int s_price) {
		this.s_price = s_price;
	}

	@Override
	public String toString() {
		return "Seat_Book [tkt_id=" + tkt_id + ", pass_id=" + pass_id + ", position=" + position + ", name=" + name
				+ ", email=" + email + ", phone=" + phone + ", smname=" + smname + ", sdate=" + sdate + ", stime="
				+ stime + ", w_limit=" + w_limit + ", payment=" + payment + ", show_id=" + show_id + ", seat_id="
				+ seat_id + ", seat_type=" + seat_type + ", s_price=" + s_price + "]";
	}

	

	
	
	
	
	

}
