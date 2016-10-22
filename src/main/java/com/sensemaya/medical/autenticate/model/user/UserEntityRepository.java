package com.sensemaya.medical.autenticate.model.user;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long>{

	UserEntity findByCurp(String curp);
	
}
