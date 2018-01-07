package br.com.tim.meutim.mock.errorhandling;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.tim.meutim.mock.util.Constantes;

@Provider
public class ApiExceptionMapper implements ExceptionMapper<ApiException> {

	public Response toResponse(ApiException ex) {
		return Response.status(ex.getStatus()).entity(new ErrorMessage(ex)).type(Constantes.JSON_UTF_8).build();
	}

}
