package br.com.tim.meutim.mock.service;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.tim.meutim.mock.entity.BalanceBasicEntity;
import br.com.tim.meutim.mock.entity.BalanceRechargeEntity;
import br.com.tim.meutim.mock.entity.BillingProfileEntity;
import br.com.tim.meutim.mock.entity.ConsumerConsumptionEntity;
import br.com.tim.meutim.mock.entity.InterestEntity;
import br.com.tim.meutim.mock.errorhandling.ApiException;
import br.com.tim.meutim.mock.facade.MeuTimFacade;
import br.com.tim.meutim.mock.util.SuccessMessage;

@Path("/v1/customer")
public class CustomerServiceV1 {

	@Inject
	private MeuTimFacade meuTimFacade;

	@GET
	@Path("/balance/recharge")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarBalanceRecharge(@HeaderParam("Authorization") String authorization) throws ApiException {
		BalanceRechargeEntity balanceRecharge = (BalanceRechargeEntity) meuTimFacade.getEntityByToken(authorization,
				"BalanceRechargeEntity");
		return Response.status(200).entity(balanceRecharge.getJson()).build();

	}

	@GET
	@Path("/balance/basic")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarBalanceBasic(@HeaderParam("Authorization") String authorization) throws ApiException {
		BalanceBasicEntity balanceBasic = (BalanceBasicEntity) meuTimFacade.getEntityByToken(authorization,
				"BalanceBasicEntity");
		return Response.status(200).entity(balanceBasic.getJson()).build();

	}

	@GET
	@Path("/billingProfile")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBillingProfile(@HeaderParam("Authorization") String authorization) throws ApiException {
		BillingProfileEntity billingProfile = (BillingProfileEntity) meuTimFacade.getEntityByToken(authorization,
				"BillingProfileEntity");
		return Response.status(200).entity(billingProfile.getJson()).build();
	}

	@GET
	@Path("/consumption")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getConsumerConsumption(@HeaderParam("Authorization") String authorization,
			@QueryParam("consumptionType") String consumptionType) throws ApiException {
		ConsumerConsumptionEntity consumerConsumption = (ConsumerConsumptionEntity) meuTimFacade
				.getEntityByToken(authorization, "ConsumerConsumptionEntity");
		return Response.status(200).entity(consumerConsumption.getJson()).build();
	}

	@PUT
	@Path("/billingProfile")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response putBillingProfile(@HeaderParam("Authorization") String authorization, String json) {
		SuccessMessage em = new SuccessMessage();
		return Response.status(200).entity(em).build();
	}

	@GET
	@Path("/interests")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMyInterests(@HeaderParam("Authorization") String authorization) throws ApiException {
		InterestEntity interestEntity = (InterestEntity) meuTimFacade.getEntityByToken(authorization, "InterestEntity");
		return Response.status(200).entity(interestEntity.getJson()).build();
	}

	@PUT
	@Path("/interests")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response putInterests(@HeaderParam("Authorization") String authorization, String myInterest)
			throws ApiException {
		return Response.status(200).entity(new SuccessMessage()).build();
	}
}