package br.com.tim.meutim.mock.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.tim.meutim.mock.entity.ProfileEntity;
import br.com.tim.meutim.mock.errorhandling.ApiException;
import br.com.tim.meutim.mock.facade.MeuTimFacade;

@Path("/v3/user")
public class UserService {

	@Inject
	private MeuTimFacade meuTimFacade;

	@GET
	@Path("/self")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProfile(@HeaderParam("Authorization") String authorization) throws ApiException {
		ProfileEntity usuario = (ProfileEntity) meuTimFacade.getEntityByToken(authorization, "ProfileEntity");
		return Response.status(200).entity(usuario.getJson()).build();
	}
}
