package com.lopez.mongo.domain.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Os atributos abaixos sao referentes as informaçoes geradas automaticamente no erro que dá no Postman ao buscar por um usuario que nao existe (Error 500)
	 * Exemplo:
	 * 
	 * "timestamp": "2023-08-02T16:24:29.724+00:00",
     *	"status": 500,
   	 *	"error": "Internal Server Error",
     *	"path": "/users/64ca8326b34acf6406b981ea"
	 */
	
	private Long timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
	public StandardError() {}

	public StandardError(Long timestamp, Integer status, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
