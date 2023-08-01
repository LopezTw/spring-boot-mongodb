package com.lopez.mongo.domain.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lopez.mongo.domain.User;
import com.lopez.mongo.domain.services.UserService;

@RestController  // Essa anotation define que essa classe eh um recurso REST
@RequestMapping(value = "/users") // caminho do endpoint definido
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET) // Pra dizer que esse metodo vai ser o caminho endpoint de findall, precisamos definir o metodo GET atraves do RequestMapping
	public ResponseEntity<List<User>> findAll(){ // ResponseEntity vai servir pra ENCAPSULAR toda uma estrutura necessária p/ retornarmos respostas HTTP já com possiveis cabeçalhos, erros...
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list); // ok é um metodo que vai instanciar o ResponseEntity ja com o codigo de resposta HTTP de que ocorreu com sucesso. E o body eh o corpo da resposta.
	}
	
}
