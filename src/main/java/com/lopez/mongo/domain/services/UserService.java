package com.lopez.mongo.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lopez.mongo.domain.User;
import com.lopez.mongo.domain.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired // vai instanciar o repositorio, injecao de independencia automatica.
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();		
	}
	
}
