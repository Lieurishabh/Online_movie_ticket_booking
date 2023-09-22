package com.entity;

public class cart {
	private int c_id;
	private int seat_id;
	private int pass_id;
	private String mname;
	private int s_price;
	private int total_price;
	private int show_id;
	
	public cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}
	public int getPass_id() {
		return pass_id;
	}
	public void setPass_id(int pass_id) {
		this.pass_id = pass_id;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getS_price() {
		return s_price;
	}
	public void setS_price(int s_price) {
		this.s_price = s_price;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	
	public int getShow_id() {
		return show_id;
	}


	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}


	@Override
	public String toString() {
		return "cart [c_id=" + c_id + ", seat_id=" + seat_id + ", pass_id=" + pass_id + ", mname=" + mname
				+ ", s_price=" + s_price + ", total_price=" + total_price +", show_id" + show_id + "]";
	}
	
	

}
