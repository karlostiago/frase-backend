package com.topaz.frase.exception;

public class MensagemConsumerException extends RuntimeException {
	
	private static final long serialVersionUID = 1425250433356760645L;

	public MensagemConsumerException(String mensagem) {
		super(mensagem);
	}
}
