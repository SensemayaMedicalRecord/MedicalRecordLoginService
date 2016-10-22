package com.sensemaya.medical.autenticate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MR_V_USER_ROLES")
public class ViewUsersEntity {

	@Id
	@GeneratedValue
	private Long idUser;
	private String cdStatus;
	private String cdLoginType;
	private String firstName;
	private String lastName;
	private String surName;
	private String rfc;
	private String curp;
	private String email;
	private String cdUserType;
	
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getCdStatus() {
		return cdStatus;
	}
	public void setCdStatus(String cdStatus) {
		this.cdStatus = cdStatus;
	}
	public String getCdLoginType() {
		return cdLoginType;
	}
	public void setCdLoginType(String cdLoginType) {
		this.cdLoginType = cdLoginType;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCdUserType() {
		return cdUserType;
	}
	public void setCdUserType(String cdUserType) {
		this.cdUserType = cdUserType;
	}

}
