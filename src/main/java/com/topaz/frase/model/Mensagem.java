package com.topaz.frase.model;

import java.util.Collections;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_mensagem")
public class Mensagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String texto;
	
	@OneToMany(mappedBy = "mensagem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Palavra> palavras;
	
	public Mensagem() { }
	
	public Mensagem(String texto) {
		this.texto = texto;
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

	public List<Palavra> getPalavras() {
		return Collections.unmodifiableList(palavras);
	}

	public void setPalavras(List<Palavra> palavras) {
		this.palavras = palavras;
	}
}
