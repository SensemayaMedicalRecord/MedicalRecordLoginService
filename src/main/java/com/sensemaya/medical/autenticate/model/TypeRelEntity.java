package com.sensemaya.medical.autenticate.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="USER_TYPE_REL")
public class TypeRelEntity {

	@Id
	private Integer idRel;
	private String curp;
	private String rfc;
	private String typeUser;
	
	public Integer getIdRel() {
		return idRel;
	}
	public void setIdRel(Integer idRel) {
		this.idRel = idRel;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}
	
	@Override
	public String toString(){
		return String.format("idRel [%s] curp [%s] rfc [%s] typeUser [%s]", this.idRel, this.curp, this.rfc, this.typeUser);
	}
	
}
