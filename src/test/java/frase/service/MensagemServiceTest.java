package frase.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.topaz.frase.repository.MensagemRepository;
import com.topaz.frase.repository.impl.MensagemRepositoryMockImpl;
import com.topaz.frase.response.MensagemResponse;
import com.topaz.frase.response.PalavraResponse;
import com.topaz.frase.service.MensagemService;
import com.topaz.frase.service.impl.MensagemServiceImpl;

public class MensagemServiceTest {
	
	private MensagemRepository mensagemRepository;
	
	private MensagemService mensagemService;
	
	@Before
	public void setup() {
		this.mensagemRepository = new MensagemRepositoryMockImpl();
		this.mensagemService = new MensagemServiceImpl(mensagemRepository);
	}
	
	@Test
	public void deveProcessarTextoComSucesso() {
		String texto = "ddd bbb aaa ddd";
		
		mensagemService.processar(texto);
		
		MensagemResponse response = mensagemService.buscarUltimaMensagemProcessada();
		
		PalavraResponse palavraResponse = response.getPalavras().stream()
				.filter(p -> p.getTexto().equalsIgnoreCase("ddd"))
				.map(p -> new PalavraResponse(p.getTexto(), p.getOcorrencia()))
				.findFirst()
				.orElse(null);
				
		
		Assert.assertEquals(3, response.getQuantidadePalavrasDistintas());
		Assert.assertEquals(2, palavraResponse.getOcorrencia());
	}
	
	@Test
	public void deveBuscarUltimaMensagemProcessada() {
		MensagemResponse response = mensagemService.buscarUltimaMensagemProcessada();
		
		Assert.assertNotNull(response);
		Assert.assertEquals("ddd bbb aaa ddd", response.getTexto());
	}
}
