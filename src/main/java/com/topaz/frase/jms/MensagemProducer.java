package com.topaz.frase.jms;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jms.JMSContext;
import jakarta.jms.Queue;

@Stateless
public class MensagemProducer {
	
	@Inject
	private JMSContext context;
	
	@Resource(lookup = "java:/jms/queue/MensagemQueue")
	private Queue queue;

	public void enviarMensagem(String mensagem) {
		this.context.createProducer().send(queue, mensagem);
	}
}
