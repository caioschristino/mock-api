package br.com.tim.meutim.mock.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.tim.meutim.mock.entity.BalanceHistoryV3Entity;
import br.com.tim.meutim.mock.errorhandling.ApiException;
import br.com.tim.meutim.mock.facade.MeuTimFacade;

@Path("v3/customer")
public class CustomerServiceV3 {

	@Inject
	private MeuTimFacade meuTimFacade;

	@GET
	@Path("/balance/history")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBalanceHistoryV3(@HeaderParam("Authorization") String authorization,
			@QueryParam("startDate") String startDate, @QueryParam("endDate") String endDate,
			@QueryParam("voiceFilter") String voiceFilter, @QueryParam("smsFilter") String smsFilter,
			@QueryParam("dataFilter") String dataFilter, @QueryParam("rechargeFilter") String rechargeFilter,
			@QueryParam("mmsFilter") String mmsFilter, @QueryParam("vasFilter") String vasFilter,
			@QueryParam("eventsFilter") String eventsFilter, @QueryParam("refundFilter") String refundFilter,
			@QueryParam("paginationId") String paginationId, @QueryParam("pageNumber") String pageNumber,
			@QueryParam("pageSize") int pageSize, @QueryParam("detailed") String detailed) throws ApiException {
		BalanceHistoryV3Entity balanceHistoryV3 = (BalanceHistoryV3Entity) meuTimFacade.getEntityByToken(authorization,
				"BalanceHistoryV3Entity");
		return Response.status(200).entity(balanceHistoryV3.getJson()).build();
	}
}