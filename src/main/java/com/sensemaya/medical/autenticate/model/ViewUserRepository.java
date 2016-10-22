package com.sensemaya.medical.autenticate.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ViewUserRepository extends CrudRepository<ViewUsersEntity, Long>{
	
	List<ViewUsersEntity> findByIdUser(Long idUser);
	List<ViewUsersEntity> findByCurp(String curp);
	
}