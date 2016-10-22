package com.sensemaya.medical.autenticate;

import static org.junit.Assert.assertEquals;

import java.rmi.AlreadyBoundException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sensemaya.medical.autenticate.model.user.PatientEntity;
import com.sensemaya.medical.autenticate.model.user.PatienceRepository;
import com.sensemaya.medical.autenticate.model.user.UserEntity;
import com.sensemaya.medical.autenticate.model.user.UserEntityRepository;
import com.sensemaya.medical.autenticate.service.PatienceSingUpService;
import com.sensemaya.medical.autenticate.service.SingUpService;
import com.sensemaya.medical.autenticate.vo.SingUpRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatienceTest {

	private static final Logger log = Logger.getLogger(PatienceTest.class);
	
	@Autowired
	UserEntityRepository UserRepository;
	
	@Autowired
	SingUpService singUpService;

	@Autowired
	PatienceSingUpService patiencesSingUp;
	
	@Autowired
	private PatienceRepository patienceRepo;
	
	Long idCommon = 1L;
	
	@Before
	public void setup(){
		patienceRepo.deleteAll();
		UserRepository.deleteAll();
	}
	
	@Test
	public void validateUserData() throws AlreadyBoundException{
		
		SingUpRequest voRequest = new SingUpRequest();
		
		voRequest.setFirstName("Paulino");
		voRequest.setLastName("Mota");
		voRequest.setSurName("Hernandez");
		voRequest.setCurp("CURP123456");
		voRequest.setRfc("MOHGP123467");
		voRequest.setCdUser("P");
		voRequest.setEmail("paulino.mota@meltsan.com");
		voRequest.setPhoneNumber("5556607310");
		
		singUpService.enrollUser(voRequest);
		
		UserEntity usrEntity = UserRepository.findByCurp("CURP123456");
		
		List<PatientEntity> plist = (List<PatientEntity>)patienceRepo.findAll();
		
		log.info("PATIENCES IT");
		for(PatientEntity p : plist){
			log.info(p);
		}
		
		log.info(usrEntity.toString());
		
		assertEquals(1, plist.size());

	}
	
}
