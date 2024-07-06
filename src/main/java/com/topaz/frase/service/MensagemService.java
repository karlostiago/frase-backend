package com.topaz.frase.service;

import com.topaz.frase.response.MensagemResponse;

public interface MensagemService {
	
	public void processar(String mensagem);
	
	public MensagemResponse buscarUltimaMensagemProcessada();
}
