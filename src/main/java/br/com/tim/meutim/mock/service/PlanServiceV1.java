package br.com.tim.meutim.mock.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.tim.meutim.mock.entity.PlanDetailEntity;
import br.com.tim.meutim.mock.entity.ROFamilyPlanEntity;
import br.com.tim.meutim.mock.errorhandling.ApiException;
import br.com.tim.meutim.mock.facade.MeuTimFacade;

@Path("/v1/plans")
public class PlanServiceV1 {

	@Inject
	private MeuTimFacade meuTimFacade;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPlanDetail(@HeaderParam("Authorization") String authorization,
			@PathParam(value = "id") String planDetail) throws ApiException {
		PlanDetailEntity planDetailEntity = (PlanDetailEntity) meuTimFacade.getEntityByToken(authorization,
				"PlanDetailEntity");
		return Response.status(200).entity(planDetailEntity.getJson()).build();

	}

	@GET
	@Path("/my/family")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFamilyPlan(@HeaderParam("Authorization") String authorization) throws ApiException {
		ROFamilyPlanEntity familyPlanEntity = (ROFamilyPlanEntity) meuTimFacade.getEntityByToken(authorization,
				"ROFamilyPlanEntity");
		return Response.status(200).entity(familyPlanEntity.getJson()).build();

	}

}