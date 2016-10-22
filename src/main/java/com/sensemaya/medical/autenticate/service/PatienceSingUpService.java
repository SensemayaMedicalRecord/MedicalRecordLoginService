package com.sensemaya.medical.autenticate.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sensemaya.medical.autenticate.model.user.PatientEntity;
import com.sensemaya.medical.autenticate.common.CommonKeys;
import com.sensemaya.medical.autenticate.model.user.PatienceRepository;

@Component
public class PatienceSingUpService {
	
	@Autowired
	private PatienceRepository patienceRepository;
	
	/**
	 * 
	 * @param idUser
	 */
	public void enrollPatience(Long idUser){
		
		patienceRepository.save(createPatienceBody(idUser));
		
	}

	/**
	 * 
	 * @param idUser 
	 * @return la estructura principal del usuario
	 */
	private PatientEntity createPatienceBody(Long idUser){
		PatientEntity p = new PatientEntity();
		
			p.setIdUser(idUser);
			p.setDateInserted(new Date());
			p.setCdStatus(CommonKeys.ACTIVE_KEY_USER);
			p.setUserInserted(CommonKeys.ADMIN_KEY_USER);
			p.setIdTokenBracelet(123L);
		
		return p;
	}
	
}
