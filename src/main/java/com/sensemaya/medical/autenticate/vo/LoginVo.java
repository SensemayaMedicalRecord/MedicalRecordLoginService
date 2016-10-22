package com.sensemaya.medical.autenticate.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginVo {

	@NotNull
	@Size(min=18, max=18, message="Formato de CURP incorrecto")
	public String user;
	
	@NotNull
	public String password;
	
	public String getUserName() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString(){
		return String.format("UserName : [%s] - Password : [%s]", this.user, this.password);
	}
	
}
