package com.topaz.frase.controller;

import com.topaz.frase.exception.FraseInvalidaException;
import com.topaz.frase.input.MensagemInput;
import com.topaz.frase.jms.MensagemProducer;
import com.topaz.frase.service.MensagemService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/mensagem")
public class MensagemController {
	
	@Inject
	private MensagemService mensagemService;
	
	@Inject
	private MensagemProducer mensagemProducer;
	
	@POST
	@Path("/analisar")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response analise(MensagemInput input) {
		
		if (input == null || input.getTexto() == null ||  input.getTexto().trim().isEmpty()) {
			throw new FraseInvalidaException("O campo texto não pode ser vázio.");
		}
		
		mensagemProducer.enviarMensagem(input.getTexto());
		
		return Response.ok().build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarUltimaMensagemProcessada() {
		return Response.ok()
				.entity( mensagemService.buscarUltimaMensagemProcessada())
				.build();
	}
}
