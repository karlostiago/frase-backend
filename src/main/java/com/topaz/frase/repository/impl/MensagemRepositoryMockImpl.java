package com.topaz.frase.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.topaz.frase.model.Mensagem;
import com.topaz.frase.model.Palavra;
import com.topaz.frase.repository.MensagemRepository;

public class MensagemRepositoryMockImpl implements MensagemRepository {
	
	private static List<Mensagem> mensagensDB;;
	
	@Override
	public void salvar(Mensagem mensagem) {
		mensagensDB = new ArrayList<>();
		
		if (mensagensDB.isEmpty()) {
			mensagem.setId(1L);
			long id = 1;
			for (Palavra palavra : mensagem.getPalavras()) {
				palavra.setId(id);
				id++;
			}
		}
		
		mensagensDB.add(mensagem);
	}

	@Override
	public Mensagem buscarUltimaMensagemInserida() {
		return mensagensDB.get(mensagensDB.size() - 1);
	}
}
