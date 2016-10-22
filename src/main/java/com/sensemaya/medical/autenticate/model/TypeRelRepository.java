package com.sensemaya.medical.autenticate.model;

import org.springframework.data.repository.CrudRepository;

public interface TypeRelRepository extends CrudRepository<TypeRelEntity, Long>{

	TypeRelEntity findByCurp(String curp);
	
}
