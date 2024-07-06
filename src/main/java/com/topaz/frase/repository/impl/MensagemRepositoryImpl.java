package com.topaz.frase.repository.impl;

import javax.sql.DataSource;

import com.topaz.frase.model.Mensagem;
import com.topaz.frase.repository.MensagemRepository;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Stateless
public class MensagemRepositoryImpl implements MensagemRepository {
	
	@Resource(lookup = "java:jboss/datasources/ExampleDS")
    private DataSource dataSource;
	
	@PersistenceContext(unitName = "frasePU")
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void salvar(Mensagem mensagem) {
		this.entityManager.merge(mensagem);
	}

	@Override
	public Mensagem buscarUltimaMensagemInserida() {
		TypedQuery<Mensagem> query = entityManager.createQuery("SELECT m FROM Mensagem m JOIN FETCH m.palavras ORDER BY m.id DESC", Mensagem.class);
		query.setMaxResults(1);
		
		return query.getSingleResult();
	}
	
	
}
