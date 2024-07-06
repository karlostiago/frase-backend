package com.topaz.frase.jms;

import com.topaz.frase.exception.MensagemConsumerException;
import com.topaz.frase.service.MensagemService;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.inject.Inject;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;
import jakarta.transaction.Transactional;

@MessageDriven(
	activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/queue/MensagemQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue")
	}
)
public class MensagemConsumer implements MessageListener {
	
	@Inject
	private MensagemService mensagemService;
	
	@Override
	@Transactional
	public void onMessage(Message mensagem) {
		if (mensagem instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) mensagem;
			try {
				mensagemService.processar(textMessage.getText());
			} catch (Exception e) {
				throw new MensagemConsumerException("Erro ao consumir mensagem." + e.getMessage());
			}
		}
	}
}
