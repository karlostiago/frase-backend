package com.topaz.frase.response;

public class ErroResponse {
	
	private final String mensagem;
	private int statusCode;
	private String descricaoStatusCode;

    public ErroResponse(String mensagem) {
        this.mensagem = mensagem;
        this.statusCode = 400;
        this.descricaoStatusCode = "Bad Request";
        
    }
    
    public int getStatusCode() {
		return statusCode;
	}

    public String getMensagem() {
        return mensagem;
    }
    
    public String getDescricaoStatusCode() {
		return descricaoStatusCode;
	}
}
