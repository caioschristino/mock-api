package br.com.tim.meutim.mock.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.tim.meutim.mock.entity.VoiceMyUsageEntity;
import br.com.tim.meutim.mock.errorhandling.ApiException;
import br.com.tim.meutim.mock.facade.MeuTimFacade;
import br.com.tim.meutim.mock.util.SuccessMessage;

@Path("/v3/packages")
public class PackageServiceV3 {

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

	@POST
	@Path("/data/{packageId}/activate")
	@Produces(MediaType.APPLICATION_JSON)
	public Response postPackgeActivate(@HeaderParam("Authorization") String authorization,
			@PathParam("packageId") String packageId) throws ApiException {
		return Response.status(200).entity(new SuccessMessage()).build();

	}

}
