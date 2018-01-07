package br.com.tim.meutim.mock.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.tim.meutim.mock.entity.LastInvoicesEntity;
import br.com.tim.meutim.mock.errorhandling.ApiException;
import br.com.tim.meutim.mock.facade.MeuTimFacade;

@Path("v2/invoices")
public class LastInvoicesService {

	@Inject
	private MeuTimFacade meuTimFacade;

	@GET
	@Path("/history")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRolloverXavierConsumption(@HeaderParam("Authorization") String authorization)
			throws ApiException {
		LastInvoicesEntity lastInvoice = (LastInvoicesEntity) meuTimFacade.getEntityByToken(authorization,
				"LastInvoicesEntity");
		return Response.status(200).entity(lastInvoice.getJson()).build();
	}
}