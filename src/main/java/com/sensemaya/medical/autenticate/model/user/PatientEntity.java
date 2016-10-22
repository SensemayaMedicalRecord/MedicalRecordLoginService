package com.sensemaya.medical.autenticate.model.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MR_USER_PATIENTS")
public class PatientEntity {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idPatient;
	
	@Column(name="id_user")
	private Long idUser;
	private Long idTokenBracelet;
	private String userInserted;
	private Date dateInserted;
	private String cdStatus;
	
	public String getCdStatus() {
		return cdStatus;
	}
	public void setCdStatus(String cdStatus) {
		this.cdStatus = cdStatus;
	}
	public Long getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public Long getIdTokenBracelet() {
		return idTokenBracelet;
	}
	public void setIdTokenBracelet(Long idTokenBracelet) {
		this.idTokenBracelet = idTokenBracelet;
	}
	public Date getDateInserted() {
		return dateInserted;
	}
	public void setDateInserted(Date dateInserted) {
		this.dateInserted = dateInserted;
	}
	public String getUserInserted() {
		return userInserted;
	}
	public void setUserInserted(String userInserted) {
		this.userInserted = userInserted;
	}
	
	@Override
	public String toString(){
		return String.format("idPAtience [%d] IdUser [%d]", this.idPatient, this.idUser);
	}

}
