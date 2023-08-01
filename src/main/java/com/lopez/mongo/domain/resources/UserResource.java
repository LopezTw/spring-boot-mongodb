package com.lopez.mongo.domain.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lopez.mongo.domain.User;

@RestController  // Essa anotation define que essa classe eh um recurso REST
@RequestMapping(value = "/users") // caminho do endpoint definido
public class UserResource {
	
	
	@RequestMapping(method = RequestMethod.GET) // Pra dizer que esse metodo vai ser o caminho endpoint de findall, precisamos definir o metodo GET atraves do RequestMapping
	public ResponseEntity<List<User>> findAll(){
		
		User maria = new User("1", "Maria Silva", "maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");
		
		List<User> list = new ArrayList<>();
		
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list);
	}
	
}
