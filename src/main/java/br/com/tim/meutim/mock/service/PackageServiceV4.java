package br.com.tim.meutim.mock.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.tim.meutim.mock.entity.VoiceMyUsageEntity;
import br.com.tim.meutim.mock.errorhandling.ApiException;
import br.com.tim.meutim.mock.facade.MeuTimFacade;

@Path("/v4/packages")
public class PackageServiceV4 {

	@Inject
	private MeuTimFacade meuTimFacade;

	@GET
	@Path("/voice/my/usage")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVoiceMyUsage(@HeaderParam("Authorization") String authorization) throws ApiException {
		VoiceMyUsageEntity voiceMyUsageEntity = (VoiceMyUsageEntity) meuTimFacade.getEntityByToken(authorization,
				"VoiceMyUsageEntity");
		return Response.status(200).entity(voiceMyUsageEntity.getJson()).build();
	}
}