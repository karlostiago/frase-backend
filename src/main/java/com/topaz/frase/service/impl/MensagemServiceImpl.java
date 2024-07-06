package com.topaz.frase.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.topaz.frase.model.Mensagem;
import com.topaz.frase.model.Palavra;
import com.topaz.frase.repository.MensagemRepository;
import com.topaz.frase.response.MensagemResponse;
import com.topaz.frase.response.PalavraResponse;
import com.topaz.frase.service.MensagemService;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class MensagemServiceImpl implements MensagemService {
	
	@Inject
	private MensagemRepository mensagemRepository;

	@Override
	public synchronized void processar(String mensagem) {
		String textoNormalizado = mensagem.replaceAll("[\\p{Punct}&&[^\\s]]", "").toLowerCase();	
		
		String [] palavras = textoNormalizado.split("\\s+");
		
		Map<String, Integer> palavrasProcessadas = new HashMap<>();
		
		for (String palavra : palavras) {
			if (!palavra.isEmpty()) {
				palavrasProcessadas.put(palavra, palavrasProcessadas.getOrDefault(palavra, 0) + 1);
			}
		}
		
		salvar(new Mensagem(textoNormalizado), palavrasProcessadas);
	}
	
	@Override
	public MensagemResponse buscarUltimaMensagemProcessada() {
		Mensagem mensagem = mensagemRepository.buscarUltimaMensagemInserida();
		
		List<PalavraResponse> palavras = mensagem.getPalavras().stream()
				.map(p -> new PalavraResponse(p.getTexto(), p.getOcorrencia()))
				.toList();
		
		MensagemResponse mensagemResponse = new MensagemResponse(mensagem.getTexto());
		mensagemResponse.adicionarPalavras(palavras);
		mensagemResponse.setQuantidadePalavrasDistintas(palavras.size());
		
		return mensagemResponse;
	}
	
	private void salvar(Mensagem mensagem, Map<String, Integer> palavrasMap) {
		List<Palavra> palavras = palavrasMap.entrySet().stream()
				.map(entry -> new Palavra(entry.getKey(), entry.getValue(), mensagem))
				.toList();
		
		mensagem.setPalavras(palavras);
		
		mensagemRepository.salvar(mensagem);
	}
}
