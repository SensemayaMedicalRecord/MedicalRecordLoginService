package com.sensemaya.medical.autenticate.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SingUpRequest {

	@NotNull
	@Size(min=3, max=50)
	private String firstName;
	
	@NotNull
	@Size(min=3, max=50)
	private String lastName;
	
	@NotNull
	@Size(min=3, max=50)
	private String surName;
	
	@NotNull
	@Size(min=8, max=100)
	private String email;
	
	@NotNull
	@Size(min=1, max=50)
	private String cdUser;
	
	@NotNull
	@Size(min=10, max=13, message="Formato de RFC incorrecto")
	private String rfc;
	
	@NotNull
	@Size(min=18, max=18, message="Formato de CURP incorrecto")
	private String curp;
	
	@NotNull
	@Size(min=1, max=50)
	private String cdLogin;
	
	@NotNull
	@Size(min=10, max=15)
	private String phoneNumber;
	
	private String idSystem;
	
	private Long idUserLegacy;

	public Long getIdUserLegacy() {
		return idUserLegacy;
	}
	public void setIdUserLegacy(Long idUserLegacy) {
		this.idUserLegacy = idUserLegacy;
	}
	public String getIdSystem() {
		return idSystem;
	}
	public void setIdSystem(String idSystem) {
		this.idSystem = idSystem;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCdUser() {
		return cdUser;
	}
	public void setCdUser(String cdUser) {
		this.cdUser = cdUser;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public String getCdLogin() {
		return cdLogin;
	}
	public void setCdLogin(String cdLogin) {
		this.cdLogin = cdLogin;
	}
	
}
