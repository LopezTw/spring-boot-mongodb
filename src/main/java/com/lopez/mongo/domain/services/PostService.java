package com.lopez.mongo.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lopez.mongo.domain.Post;
import com.lopez.mongo.domain.repository.PostRepository;
import com.lopez.mongo.domain.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired // vai instanciar o repositorio, injecao de independencia automatica.
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}
	
}
