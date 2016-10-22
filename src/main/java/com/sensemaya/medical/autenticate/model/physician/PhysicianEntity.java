package com.sensemaya.medical.autenticate.model.physician;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MR_USER_DOCTORS")
public class PhysicianEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idDoctor;
	
	@Column(name="id_user")
	private Long idUser;
	private String cdStatus;
	private String medicalIdentityCard;
	private String cdMedicalSpecialty;
	private String officeAddress;
	private String homeContact;
	private String officeContact;
	private String otherContact;
	private String userUpdated;
	private Date dateUpdated;
	private String userInserted;
	private Date dateInserted;
	
	public Long getIdDoctor() {
		return idDoctor;
	}
	public void setIdDoctor(Long idDoctor) {
		this.idDoctor = idDoctor;
	}
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
	public String getMedicalIdentityCard() {
		return medicalIdentityCard;
	}
	public void setMedicalIdentityCard(String medicalIdentityCard) {
		this.medicalIdentityCard = medicalIdentityCard;
	}
	public String getCdMedicalSpecialty() {
		return cdMedicalSpecialty;
	}
	public void setCdMedicalSpecialty(String cdMedicalSpecialty) {
		this.cdMedicalSpecialty = cdMedicalSpecialty;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getHomeContact() {
		return homeContact;
	}
	public void setHomeContact(String homeContact) {
		this.homeContact = homeContact;
	}
	public String getOfficeContact() {
		return officeContact;
	}
	public void setOfficeContact(String officeContact) {
		this.officeContact = officeContact;
	}
	public String getOtherContact() {
		return otherContact;
	}
	public void setOtherContact(String otherContact) {
		this.otherContact = otherContact;
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
	
}
