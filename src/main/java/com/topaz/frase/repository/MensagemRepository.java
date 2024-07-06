package com.topaz.frase.repository;

import com.topaz.frase.model.Mensagem;

public interface MensagemRepository {
	
	public void salvar(Mensagem mensagem);
	
	public Mensagem buscarUltimaMensagemInserida();
}
