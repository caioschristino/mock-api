package br.com.tim.meutim.mock.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.tim.meutim.mock.entity.DataMyEntity;
import br.com.tim.meutim.mock.entity.PackageRenewUpgradeEntity;
import br.com.tim.meutim.mock.entity.RODataMyUsageEntity;
import br.com.tim.meutim.mock.errorhandling.ApiException;
import br.com.tim.meutim.mock.facade.MeuTimFacade;

@Path("/v2/packages")
public class PackageServiceV2 {

	@Inject
	private MeuTimFacade meuTimFacade;

	@GET
	@Path("/data/my")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDataMy(@HeaderParam("Authorization") String authorization) throws ApiException {
		DataMyEntity dataMy = (DataMyEntity) meuTimFacade.getEntityByToken(authorization, "DataMyEntity");
		return Response.status(200).entity(dataMy.getJson()).build();

	}

	@GET
	@Path("/data/my/usage")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDataMyUsage(@HeaderParam("Authorization") String authorization) throws ApiException {
		RODataMyUsageEntity dataMyUsage = (RODataMyUsageEntity) meuTimFacade.getEntityByToken(authorization,
				"RODataMyUsageEntity");
		return Response.status(200).entity(dataMyUsage.getJson()).build();

	}

	@GET
	@Path("/data/eligible")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPackages(@HeaderParam("Authorization") String authorization) throws ApiException {
		PackageRenewUpgradeEntity packageRenewUpgrade = (PackageRenewUpgradeEntity) meuTimFacade
				.getEntityByToken(authorization, "PackageRenewUpgradeEntity");
		return Response.status(200).entity(packageRenewUpgrade.getJson()).build();
	}

}
