package com.topaz.frase.provider;

import com.topaz.frase.exception.FraseInvalidaException;
import com.topaz.frase.response.ErroResponse;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class FraseInvalidaExceptionProvider implements ExceptionMapper<FraseInvalidaException> {

	@Override
	public Response toResponse(FraseInvalidaException exception) {
		return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErroResponse(exception.getMessage()))
                .build();
	}
	
}
