package com.sensemaya.medical.autenticate.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sensemaya.medical.autenticate.common.CommonResponse;
import com.sensemaya.medical.autenticate.model.ViewUserRepository;
import com.sensemaya.medical.autenticate.model.ViewUsersEntity;

@Component
public class LoginService {
	
	private static final Logger log = Logger.getLogger(LoginService.class);
	
	@Autowired
	private ViewUserRepository viewUserRepository;
	
	public CommonResponse validateUserTypeLoginAccess(String curp){
		CommonResponse res = new CommonResponse();
		
		List<ViewUsersEntity> resultLogin = viewUserRepository.findByCurp(curp);
			if(resultLogin.size() == 0) return res;
			
			res.setSuccess(true);
			
				res.setPatientProfile(getEntityProfile(resultLogin, "P"));
				res.setPhysicianProfile(getEntityProfile(resultLogin,  "D"));
			
		return res;
	}
	
	
	private ViewUsersEntity getEntityProfile(List<ViewUsersEntity> users, final String userType){
		
		for(ViewUsersEntity u:users){
			if(userType.equals(u.getCdUserType())){
				return u;
			}
		}
		return null;
	}
	
}