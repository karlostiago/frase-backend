package com.topaz.frase.response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({ "texto", "palavras", "quantidadePalavrasDistintas" })
public class MensagemResponse {
	
	private String texto;
	
	private List<PalavraResponse> palavras;
	
	private int quantidadePalavrasDistintas;
	
	public MensagemResponse() { }

	public MensagemResponse(String texto) {
		this.texto = texto;
		this.palavras = new ArrayList<>();
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getQuantidadePalavrasDistintas() {
		return quantidadePalavrasDistintas;
	}

	public void setQuantidadePalavrasDistintas(int quantidadePalavrasDistintas) {
		this.quantidadePalavrasDistintas = quantidadePalavrasDistintas;
	}
	
	public void adicionarPalavras(List<PalavraResponse> palavras) {
		this.palavras.addAll(palavras);
	}
	
	public List<PalavraResponse> getPalavras() {
		return Collections.unmodifiableList(palavras);
	}
}
