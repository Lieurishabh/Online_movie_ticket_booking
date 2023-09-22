package com.entity;


public class seat {
	private int seat_id;
	private String seat_type;
	private int s_price;
	private String s_status;
	private int show_id;
	
	
	public seat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public seat(String seat_type, int s_price, String s_status) {
		super();
		this.seat_type = seat_type;
		this.s_price = s_price;
		this.s_status = s_status;
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
	public String getS_status() {
		return s_status;
	}
	public void setS_status(String s_status) {
		this.s_status = s_status;
	}
	
	public int getShow_id() {
		return show_id;
	}


	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}


	@Override
	public String toString() {
		return "seat [seat_id=" + seat_id + ", seat_type=" + seat_type + ", s_price=" + s_price + ", s_status="
				+ s_status + ", show_id=" + show_id + "]";
	}


	
}


