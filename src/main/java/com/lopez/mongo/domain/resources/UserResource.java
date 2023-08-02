package com.lopez.mongo.domain.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lopez.mongo.domain.User;
import com.lopez.mongo.domain.services.UserService;
import com.lopez.mongo.dto.UserDTO;

@RestController  // Essa anotation define que essa classe eh um recurso REST
@RequestMapping(value = "/users") // caminho do endpoint definido
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET) // Pra dizer que esse metodo vai ser o caminho endpoint de findall, precisamos definir o metodo GET atraves do RequestMapping
	public ResponseEntity<List<UserDTO>> findAll(){ // ResponseEntity vai servir pra ENCAPSULAR toda uma estrutura necessária p/ retornarmos respostas HTTP já com possiveis cabeçalhos, erros...
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(usuario -> new UserDTO(usuario)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto); // ok é um metodo que vai instanciar o ResponseEntity ja com o codigo de resposta HTTP de que ocorreu com sucesso. E o body eh o corpo da resposta.
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) 
	public ResponseEntity<UserDTO> findById(@PathVariable String id){  // PathVariable faz com que esse id do parametro case com o do value = {id}
		User obj = service.findById(id);
		
		return ResponseEntity.ok().body(new UserDTO(obj)); 
	}
	
	@RequestMapping(method = RequestMethod.POST) 
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){  // PathVariable faz com que esse id do parametro case com o do value = {id}
		User obj = service.fromDTO(objDto); // Converte o DTO para USER
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); // Vai pegar o endereço do novo Objeto que eu inserir
		return ResponseEntity.created(uri).build(); // retornar o cod 201 que significa que vc criou um recurso.
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) 
	public ResponseEntity<Void> delete(@PathVariable String id){  // PathVariable faz com que esse id do parametro case com o do value = {id}
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
