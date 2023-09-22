package com.entity;

public class movie {
	private int movie_id;
	private String mname;
	private String mcertify;
	private String mlang;
	private String mtype;
	private String mdur;
	private String mdir;
	private String mcast;
	private String rdate;
	private String mposter;
	

	public movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public movie(String mname, String mcertify, String mlang, String mtype, String mdur, String mdir,
			String mcast, String rdate, String mposter) {
		super();
		this.mname = mname;
		this.mcertify = mcertify;
		this.mlang = mlang;
		this.mtype = mtype;
		this.mdur = mdur;
		this.mdir = mdir;
		this.mcast = mcast;
		this.rdate = rdate;
		this.mposter = mposter;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMcertify() {
		return mcertify;
	}

	public void setMcertify(String mcertify) {
		this.mcertify = mcertify;
	}

	public String getMlang() {
		return mlang;
	}

	public void setMlang(String mlang) {
		this.mlang = mlang;
	}

	public String getMtype() {
		return mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	public String getMdur() {
		return mdur;
	}

	public void setMdur(String mdur) {
		this.mdur = mdur;
	}

	public String getMdir() {
		return mdir;
	}

	public void setMdir(String mdir) {
		this.mdir = mdir;
	}

	public String getMcast() {
		return mcast;
	}

	public void setMcast(String mcast) {
		this.mcast = mcast;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getMposter() {
		return mposter;
	}


	public void setMposter(String mposter) {
		this.mposter = mposter;
	}


	@Override
	public String toString() {
		return "movie [movie_id=" + movie_id + ", mname=" + mname + ", mcertify=" + mcertify + ", mlang=" + mlang
				+ ", mtype=" + mtype + ", mdur=" + mdur + ", mdir=" + mdir + ", mcast=" + mcast + ", rdate=" + rdate
				+ ", mposter=" + mposter + "]";
	}


	
	
	

}
