package com.sensemaya.medical.autenticate.controller;

import java.rmi.AlreadyBoundException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sensemaya.medical.autenticate.common.CommonResponse;
import com.sensemaya.medical.autenticate.service.SingUpService;
import com.sensemaya.medical.autenticate.vo.SingUpRequest;

@CrossOrigin
@RestController
@RequestMapping("singup")
public class SingUpController {

	@Autowired
	private SingUpService singUpService;
	
	@RequestMapping(path={"","/"}, method=RequestMethod.POST)
	public CommonResponse singupUser(@Valid @RequestBody SingUpRequest entity){
		
		CommonResponse res = new CommonResponse();
		
			try {
				singUpService.enrollUser(entity);
				res.setSuccess(true);
			} catch (IllegalArgumentException ex){
				res.setMessage(ex.getMessage());
			} catch (AlreadyBoundException e) {
				res.setMessage("USER EXIST: " + e.getMessage());
				e.printStackTrace();
			}
		
		return res;
		
	}
	
}
