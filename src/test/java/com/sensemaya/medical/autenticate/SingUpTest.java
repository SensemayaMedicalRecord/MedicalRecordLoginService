package com.sensemaya.medical.autenticate;

import java.rmi.AlreadyBoundException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sensemaya.medical.autenticate.model.physician.PhysicianRepository;
import com.sensemaya.medical.autenticate.model.user.PatienceRepository;
import com.sensemaya.medical.autenticate.model.user.UserEntity;
import com.sensemaya.medical.autenticate.model.user.UserEntityRepository;
import com.sensemaya.medical.autenticate.service.SingUpService;
import com.sensemaya.medical.autenticate.vo.SingUpRequest;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SingUpTest {

	@Autowired
	private SingUpService singUpService;
	
	@Autowired
	private UserEntityRepository userRepo;
	
	@Autowired
	private PatienceRepository PatienceRepo;
	
	@Autowired
	private PhysicianRepository physicianRepo;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	SingUpRequest voRequest = new SingUpRequest(); 
	
	@Before
	public void setup(){
		
		physicianRepo.deleteAll();
		PatienceRepo.deleteAll();
		userRepo.deleteAll();
		voRequest.setFirstName("Paulino");
		voRequest.setLastName("Mota");
		voRequest.setSurName("Hernandez");
		voRequest.setCdUser("P");
		voRequest.setCurp("CURP123456");
		voRequest.setRfc("MOHGP123467");
		voRequest.setEmail("paulino.mota@meltsan.com");
		voRequest.setPhoneNumber("5556607310");
		
	}
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Test(expected=IllegalArgumentException.class)
	public void existUserValidation() throws java.rmi.AlreadyBoundException{
		SingUpRequest singUpReques = new SingUpRequest();
		singUpService.enrollUser(singUpReques);
	}

	@Test
	public void validateInsertUser() throws java.rmi.AlreadyBoundException{
		Long idSaved = singUpService.enrollUser(voRequest);
		UserEntity user = userRepo.findOne(idSaved);
		Assert.assertEquals(voRequest.getFirstName(), user.getFirstName());
	}
	
	@Test(expected=java.rmi.AlreadyBoundException.class)
	public void validateDuplexUser() throws java.rmi.AlreadyBoundException{
		singUpService.enrollUser(voRequest);
		singUpService.enrollUser(voRequest);		
		
	}
	
	@Test
	public void validateFormatUserData() throws AlreadyBoundException{
		
		voRequest.setLastName("");
		
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("LastName is required");
		singUpService.enrollUser(voRequest);
						
		
	}
	
	@Test
	public void createPhysician() throws java.rmi.AlreadyBoundException{
		voRequest.setCdUser("D");
		voRequest.setCurp("MOHP12345612345434");
		Long idSaved = singUpService.enrollUser(voRequest);
		UserEntity user = userRepo.findOne(idSaved);
		Assert.assertEquals(voRequest.getFirstName(), user.getFirstName());
		
	}
	
}
