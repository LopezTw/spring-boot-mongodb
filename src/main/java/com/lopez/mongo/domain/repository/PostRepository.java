package com.lopez.mongo.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lopez.mongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	
	
}


/*
 *  Essa interface vazia desse jeito, ja consegue fazer varias operacoes basicas (salvar, deletar, recuperar...)
 */