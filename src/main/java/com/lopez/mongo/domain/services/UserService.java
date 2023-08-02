package com.lopez.mongo.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lopez.mongo.domain.User;
import com.lopez.mongo.domain.repository.UserRepository;
import com.lopez.mongo.domain.services.exception.ObjectNotFoundException;
import com.lopez.mongo.dto.UserDTO;

@Service
public class UserService {
	
	@Autowired // vai instanciar o repositorio, injecao de independencia automatica.
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();		
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
}
