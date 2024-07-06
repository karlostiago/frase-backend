package com.topaz.frase.response;

import jakarta.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({ "palavra", "ocorrencia" })
public class PalavraResponse {
	
	private String palavra;
	
	private int ocorrencia;
	
	public PalavraResponse(String palavra, int ocorrencia) {
		this.palavra = palavra;
		this.ocorrencia = ocorrencia;
	}

	public String getPalavra() {
		return palavra;
	}

	public int getOcorrencia() {
		return ocorrencia;
	}
}
