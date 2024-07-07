package com.topaz.frase.exception;

public class MensagemInvalidaException extends RuntimeException {
	
	private static final long serialVersionUID = 1425250433356760645L;

	public MensagemInvalidaException(String mensagem) {
		super(mensagem);
	}
}
