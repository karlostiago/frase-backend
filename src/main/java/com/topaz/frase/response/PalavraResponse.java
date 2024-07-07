package com.topaz.frase.response;

import jakarta.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({ "palavra", "ocorrencia" })
public class PalavraResponse {
	
	private String texto;
	
	private int ocorrencia;
	
	public PalavraResponse(String texto, int ocorrencia) {
		this.texto = texto;
		this.ocorrencia = ocorrencia;
	}

	public String getTexto() {
		return texto;
	}

	public int getOcorrencia() {
		return ocorrencia;
	}
}
