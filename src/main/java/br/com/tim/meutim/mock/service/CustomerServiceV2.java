package br.com.tim.meutim.mock.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.tim.meutim.mock.entity.BalanceEntity;
import br.com.tim.meutim.mock.entity.BalanceHistoryEntity;
import br.com.tim.meutim.mock.entity.CustomerEntity;
import br.com.tim.meutim.mock.entity.ReactivationDataEntity;
import br.com.tim.meutim.mock.errorhandling.ApiException;
import br.com.tim.meutim.mock.facade.MeuTimFacade;
import br.com.tim.meutim.mock.util.SuccessMessage;

@Path("/v2/customer")
public class CustomerServiceV2 {

	@Inject
	private MeuTimFacade meuTimFacade;

	@GET
	@Path("/accountData")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomer(@HeaderParam("Authorization") String authorization) throws ApiException {
		CustomerEntity customer = (CustomerEntity) meuTimFacade.getEntityByToken(authorization, "CustomerEntity");
		return Response.status(200).entity(customer.getJson()).build();

	}

	@GET
	@Path("/balance")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarBalance(@HeaderParam("Authorization") String authorization) throws ApiException {
		BalanceEntity balance = (BalanceEntity) meuTimFacade.getEntityByToken(authorization, "BalanceEntity");
		return Response.status(200).entity(balance.getJson()).build();

	}

	@GET
	@Path("/service/unblock/eligible")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReactivationEligilityV2(@HeaderParam("Authorization") String authorization) throws ApiException {
		ReactivationDataEntity reactivationData = (ReactivationDataEntity) meuTimFacade.getEntityByToken(authorization,
				"ReactivationDataEntity");
		return Response.status(200).entity(reactivationData.getJson()).build();
	}

	@GET
	@Path("/balance/history")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBalanceHistory(@HeaderParam("Authorization") String authorization,
			@QueryParam("startDate") String startDate, @QueryParam("endDate") String endDate,
			@QueryParam("recordTypes") String recordTypes, @QueryParam("freeOfCharge") Boolean freeOfCharge,
			@QueryParam("offset") String offset, @QueryParam("limit") String limit) throws ApiException {
		BalanceHistoryEntity balanceHistory = (BalanceHistoryEntity) meuTimFacade.getEntityByToken(authorization,
				"BalanceHistoryEntity");
		return Response.status(200).entity(balanceHistory.getJson()).build();
	}

	@POST
	@Path("/service/unblock/reactivate")
	@Produces(MediaType.APPLICATION_JSON)
	public Response postReactivationV2(@HeaderParam("Authorization") String authorization) {
		return Response.status(200).entity(new SuccessMessage()).build();

	}
}