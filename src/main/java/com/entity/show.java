package com.entity;

public class show {
	
	private int show_id;
	private int movie_id;
	private String smname;
	private String stime;
	private String etime;
	private String sdate;
	
	
	public show() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public show(int movie_id, String smname, String stime, String etime, String sdate) {
		super();
		this.movie_id=movie_id;
		this.smname = smname;
		this.stime = stime;
		this.etime = etime;
		this.sdate = sdate;
	}
	
	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public int getShow_id() {
		return show_id;
	}
	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}
	public String getSmname() {
		return smname;
	}
	public void setSmname(String smname) {
		this.smname = smname;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getEtime() {
		return etime;
	}
	public void setEtime(String etime) {
		this.etime = etime;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	@Override
	public String toString() {
		return "show [show_id=" + show_id + ", movie_id=" + movie_id + ", smname=" + smname + ", stime=" + stime + ", etime=" + etime + ", sdate="
				+ sdate + "]";
	}
	
	
	

}
