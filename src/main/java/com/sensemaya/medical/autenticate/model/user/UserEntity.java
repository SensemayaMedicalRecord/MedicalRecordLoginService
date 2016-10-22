package com.sensemaya.medical.autenticate.model.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="MR_USERS")
public class UserEntity {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idUser;
	private String firstName;
	private String lastName;
	private String surName;
	private String email;
	private String rfc;
	private String curp;
	private String cdLoginType;
	private String userInserted;
	private String cdStatus; 
	private Date dateInserted;
	private String userUpdated;
	private Date dateUpdated;

	@OneToMany
	@JoinColumn(name="id_user")
	private List<PatientEntity> patienceData;
	
	
	public List<PatientEntity> getPatienceData() {
		return patienceData;
	}
	public void setPatienceData(List<PatientEntity> patienceData) {
		this.patienceData = patienceData;
	}
	public String getCdStatus() {
		return cdStatus;
	}
	public void setCdStatus(String cdStatus) {
		this.cdStatus = cdStatus;
	}
	
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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
	public String getUserInserted() {
		return userInserted;
	}
	public void setUserInserted(String userInserted) {
		this.userInserted = userInserted;
	}
	public Date getDateInserted() {
		return dateInserted;
	}
	public void setDateInserted(Date dateInserted) {
		this.dateInserted = dateInserted;
	}
	public String getUserUpdated() {
		return userUpdated;
	}
	public void setUserUpdated(String userUpdated) {
		this.userUpdated = userUpdated;
	}
	public Date getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
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
	public String getCdLoginType() {
		return cdLoginType;
	}
	public void setCdLoginType(String cdLoginType) {
		this.cdLoginType = cdLoginType;
	}
	
}
