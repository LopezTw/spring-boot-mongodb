package com.lopez.mongo.domain.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lopez.mongo.domain.Post;
import com.lopez.mongo.domain.services.PostService;

@RestController  // Essa anotation define que essa classe eh um recurso REST
@RequestMapping(value = "/posts") // caminho do endpoint definido
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) 
	public ResponseEntity<Post> findById(@PathVariable String id){  // PathVariable faz com que esse id do parametro case com o do value = {id}
		Post obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj); 
	}
	
	
}
