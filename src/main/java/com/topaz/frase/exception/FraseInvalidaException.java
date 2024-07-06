package com.topaz.frase.exception;

public class FraseInvalidaException extends RuntimeException {
	
	private static final long serialVersionUID = 1425250433356760645L;

	public FraseInvalidaException(String mensagem) {
		super(mensagem);
	}
}
