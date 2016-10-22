package com.sensemaya.medical.autenticate.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sensemaya.medical.autenticate.common.CommonKeys;
import com.sensemaya.medical.autenticate.model.physician.PhysicianEntity;
import com.sensemaya.medical.autenticate.model.physician.PhysicianRepository;

@Component
public class PhysicianSingUpService {

	@Autowired
	private PhysicianRepository physicianRepo;
	
	
	protected void enrollPhysician(Long idUser){
		PhysicianEntity physicianEntity = new PhysicianEntity();
		
		physicianEntity.setIdUser(idUser);
		createBodyPhysician(physicianEntity);
		physicianRepo.save(physicianEntity);
		
	}
	
	private void createBodyPhysician(PhysicianEntity physicianEntity){
		physicianEntity.setUserInserted("ADM");
		physicianEntity.setCdStatus(CommonKeys.ACTIVE_KEY_USER);
		physicianEntity.setDateInserted(new Date());
	}
	
}
