package com.sensemaya.medical.autenticate.service;

import java.rmi.AlreadyBoundException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.sensemaya.medical.autenticate.common.CommonKeys;
import com.sensemaya.medical.autenticate.common.CommonResponse;
import com.sensemaya.medical.autenticate.model.user.UserEntity;
import com.sensemaya.medical.autenticate.model.user.UserEntityRepository;
import com.sensemaya.medical.autenticate.vo.SingUpRequest;

@Component
public class SingUpService {

	private static final Logger log = Logger.getLogger(SingUpService.class);
	
	@Autowired
	private UserEntityRepository repository;

	@Autowired
	private PatienceSingUpService patienceSingUpService;
	
	@Autowired
	private PhysicianSingUpService physicianSingUpService; 
	
	public Long enrollUser(SingUpRequest requestObj) throws AlreadyBoundException{
		
		log.info("ENROLL USER");
		
		validateUser(requestObj);
		UserEntity entity = createEntity(requestObj);
		validateUserAvailable(entity);
		UserEntity saved = repository.save(entity);
		log.info("USER SAVED ID : " + saved.getIdUser());

		/**
		 * Se hace la invocacion al servicio de creacion de usuarios del
		 * sistema de token, se envia el id del usuario el cual sera utilizado 
		 * posteriomente, para hacer las validaciones de token
		 */
		createUseronOTP(requestObj, saved.getIdUser());
		
			if(CommonKeys.CD_USER_PATIENCE.equals(requestObj.getCdUser())){
				
				patienceSingUpService.enrollPatience(saved.getIdUser());
			
			}else if(CommonKeys.CD_USER_PHYSICIAN.equals(requestObj.getCdUser())){
				
				physicianSingUpService.enrollPhysician(saved.getIdUser());
				
			}
			
		return saved.getIdUser();
		
	}
	
	/**
	 * valida que el usuario pueda ser creado
	 * @param entity
	 * @throws AlreadyBoundException
	 */
	private void validateUserAvailable(UserEntity entity) throws AlreadyBoundException {
		
		log.info("VALIDE USER EXIST BY CURP");
		if(repository.findByCurp(entity.getCurp()) != null){
			throw new AlreadyBoundException("CURP");
		}
		
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	private UserEntity createEntity(SingUpRequest request){
		
		UserEntity usr = createCommonUserBody(request);
		
		return usr;
	}
	
	/**
	 * create an Usuer on OTP application
	 * @param requestObject
	 */
	private void createUseronOTP(SingUpRequest requestObject, Long idUser){
		
		RestTemplate restRestTemplate = new RestTemplate();
		
			requestObject.setIdSystem(CommonKeys.ID_SYSTEM_OTP);
			requestObject.setIdUserLegacy(idUser);
			
		CommonResponse res = restRestTemplate.postForObject(CommonKeys.OTP_URL, requestObject, CommonResponse.class);
		log.info("USER CREATE : " + res.isSuccess());

	}
	
	/**
	 * 
	 * @param request
	 * @return Estrucutura comun del usuario
	 */
	private UserEntity createCommonUserBody(SingUpRequest request){
		
		UserEntity usr = new UserEntity();
		usr.setFirstName(request.getFirstName());
		usr.setLastName(request.getLastName());
		usr.setSurName(request.getSurName());
		
		usr.setRfc(request.getRfc());
		usr.setCurp(request.getCurp());
		usr.setEmail(request.getEmail());
		
		usr.setCdStatus(CommonKeys.ACTIVE_KEY_USER);
		usr.setUserInserted(CommonKeys.ADMIN_KEY_USER);
		usr.setDateInserted(new Date());
		usr.setCdLoginType(CommonKeys.PASS_DEFAULT_TYPE);
	
		return usr;
	}
	
	/**
	 * 
	 * @param req Objeto desde Request, utilizado para dar de alta
	 */
	private void validateUser(SingUpRequest req){
		if(StringUtils.isEmpty(req.getFirstName())){
			throw new IllegalArgumentException("FirstName is required");
		}
		if(StringUtils.isEmpty(req.getLastName())){
			throw new IllegalArgumentException("LastName is required");
		}
		if(StringUtils.isEmpty(req.getSurName())){
			throw new IllegalArgumentException("SurName is required");
		}
		if(StringUtils.isEmpty(req.getCurp())){
			throw new IllegalArgumentException("Curp is required");
		}
		if(StringUtils.isEmpty(req.getRfc())){
			throw new IllegalArgumentException("Rfc is required");
		}
	}	
	
}
