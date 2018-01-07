package br.com.tim.meutim.mock.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.tim.meutim.mock.entity.StatusEntity;
import br.com.tim.meutim.mock.errorhandling.ApiException;
import br.com.tim.meutim.mock.facade.MeuTimFacade;

@Path("v1/api")
public class StatusService {

	@Inject
	private MeuTimFacade meuTimFacade;
	
	@GET
	@Path("/status")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStatus(@HeaderParam("Authorization") String authorization) throws ApiException {
		StatusEntity statusApi = (StatusEntity) meuTimFacade
				.getEntityByToken(authorization, "StatusEntity");
		return Response.status(200).entity(statusApi.getJson()).build();

	}
}
