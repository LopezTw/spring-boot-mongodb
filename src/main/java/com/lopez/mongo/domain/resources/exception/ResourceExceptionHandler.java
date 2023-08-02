package com.lopez.mongo.domain.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lopez.mongo.domain.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // Isso indica que esta classe é responsavel por tratar possiveis erros nas requisiçoes
public class ResourceExceptionHandler {

	
	/**
	 *  Esse método basicamente retorna uma resposta costumizada referente ao error que estourar no ObjectNotFoundException ao inves de retornar um error Padrao.
	 */
	
	@ExceptionHandler(ObjectNotFoundException.class) // Anotacao importante pro mecanismo abaixo funcionar, ou seja, qnd ocorrer a execao ObjectNotFoundException, utilizar o tratamento abaixo.
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não Encontrado !", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
}



/* ====== LEGENDAS =======
 * 
 * System.currentTimeMillis = Pega o instante atual do Sistema
 * Status.value() = Converte o NOT_FOUND pro codigo 404
 * request.getRequestURI() = Obtém o caminho que foi inserido na pesquisa
 */
