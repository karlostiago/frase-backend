package com.topaz.frase.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_palavra")
public class Palavra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(columnDefinition = "TEXT")
	private String texto;
	
	private Integer ocorrencia;
	
	@ManyToOne
	@JoinColumn(name = "mensagem_id", nullable = false)
	private Mensagem mensagem;
	
	public Palavra() { }
	
	public Palavra(String texto, Integer ocorrencia, Mensagem mensagem) {
		this.texto = texto;
		this.ocorrencia = ocorrencia;
		this.mensagem = mensagem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Integer getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(Integer ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}
}
