package com.selflearning.chatapplication.dto;

public class UserDTO {
	private String userid;
	private char[] password;
	public UserDTO (String userid,char[] password) {
		this.userid=userid;
		this.password=password;
		
	}
	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * @return the password
	 */
	public char[] getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(char[] password) {
		this.password = password;
	}
	

}
