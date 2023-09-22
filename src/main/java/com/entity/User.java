package com.entity;

public class User {
	
	private int pass_id;
	private String name;
	private String gender;
	private String email;
	private String phone;
	private String position;
	private String pass;
	private String cpass;
	private int w_limit;
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getCpass() {
		return cpass;
	}
	public void setCpass(String cpass) {
		this.cpass = cpass;
	}
	
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getPass_id() {
		return pass_id;
	}
	public void setPass_id(int pass_id) {
		this.pass_id = pass_id;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
	public int getW_limit() {
		return w_limit;
	}
	public void setW_limit(int w_limit) {
		this.w_limit = w_limit;
	}
	@Override
	public String toString() {
		return "User [pass_id=" + pass_id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", position="
				+ position + ", pass=" + pass + ", cpass=" + cpass + ", w_limit=" + w_limit + "]";
	}
	
	
}
