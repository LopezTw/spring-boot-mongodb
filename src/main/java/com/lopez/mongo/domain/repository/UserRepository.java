package com.lopez.mongo.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lopez.mongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
	
	
}


/*
 *  Essa interface vazia desse jeito, ja consegue fazer varias operacoes basicas (salvar, deletar, recuperar...)
 */