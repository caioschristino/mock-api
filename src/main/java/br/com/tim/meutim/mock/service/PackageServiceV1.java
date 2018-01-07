package br.com.tim.meutim.mock.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.tim.meutim.mock.entity.GroupedConsumptionEntity;
import br.com.tim.meutim.mock.entity.RolloverXavierDataHistoryEntity;
import br.com.tim.meutim.mock.errorhandling.ApiException;
import br.com.tim.meutim.mock.facade.MeuTimFacade;

@Path("/v1/packages")
public class PackageServiceV1 {

	@Inject
	private MeuTimFacade meuTimFacade;

	@GET
	@Path("/data/history")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRolloverXavierConsumption(@HeaderParam("Authorization") String authorization)
			throws ApiException {
		RolloverXavierDataHistoryEntity rolloverXavierDataHistory = (RolloverXavierDataHistoryEntity) meuTimFacade
				.getEntityByToken(authorization, "RolloverXavierDataHistoryEntity");
		return Response.status(200).entity(rolloverXavierDataHistory.getJson()).build();

	}

	@GET
	@Path("/data/my/usage/daily")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGroupedConsumption(@HeaderParam("Authorization") String authorization) throws ApiException {
		GroupedConsumptionEntity groupedConsumption = (GroupedConsumptionEntity) meuTimFacade
				.getEntityByToken(authorization, "GroupedConsumptionEntity");
		return Response.status(200).entity(groupedConsumption.getJson()).build();

	}
}
