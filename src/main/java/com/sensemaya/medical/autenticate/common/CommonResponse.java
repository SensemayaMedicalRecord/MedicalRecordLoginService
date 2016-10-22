package com.sensemaya.medical.autenticate.common;

import com.sensemaya.medical.autenticate.model.ViewUsersEntity;

public class CommonResponse {
	
	private boolean success;
	private String message;
	private ViewUsersEntity patientProfile;
	private ViewUsersEntity physicianProfile;
	
	public ViewUsersEntity getPatientProfile() {
		return patientProfile;
	}
	public void setPatientProfile(ViewUsersEntity patientProfile) {
		this.patientProfile = patientProfile;
	}
	public ViewUsersEntity getPhysicianProfile() {
		return physicianProfile;
	}
	public void setPhysicianProfile(ViewUsersEntity physicianProfile) {
		this.physicianProfile = physicianProfile;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
