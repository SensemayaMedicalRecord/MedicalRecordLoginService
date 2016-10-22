package com.sensemaya.medical.autenticate.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sensemaya.medical.autenticate.common.CommonResponse;
import com.sensemaya.medical.autenticate.model.user.UserEntityRepository;
import com.sensemaya.medical.autenticate.service.LoginService;
import com.sensemaya.medical.autenticate.vo.LoginVo;

@RestController
@RequestMapping("")
public class LoginController {

	private static final Logger log = Logger.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserEntityRepository repo; 
	
	@RequestMapping(path={"users","/users"})
	public CommonResponse getAllUsers(){
		CommonResponse res = new CommonResponse();
			
		// res.setResult((List<UserEntity>) repo.findAll());
		
		return res;
	}
	
	@RequestMapping(path="login", method=RequestMethod.POST)
	@CrossOrigin
	public CommonResponse loginUser(@Validated @RequestBody LoginVo loginVo){
		
			CommonResponse res = loginService.validateUserTypeLoginAccess(loginVo.user);
			log.info(loginVo);
		
		return res;
	}
	
	
}