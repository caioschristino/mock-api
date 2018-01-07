package br.com.tim.meutim.mock.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.tim.meutim.mock.entity.AppConfigEntity;
import br.com.tim.meutim.mock.entity.ROGroupListEntity;
import br.com.tim.meutim.mock.entity.ThemeApiEntity;
import br.com.tim.meutim.mock.errorhandling.ApiException;
import br.com.tim.meutim.mock.facade.MeuTimFacade;

@Path("/v1/appmeutim")
public class AppConfigService {

	@Inject
	private MeuTimFacade meuTimFacade;

	@GET
	@Path("/config/android/{version}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAppConfigAndroid(@HeaderParam("Authorization") String authorization,
			@HeaderParam("If-Modified-Since") String ifModifiedSince, @PathParam("version") String version)
			throws ApiException {
		AppConfigEntity appConfig = (AppConfigEntity) meuTimFacade.getEntityByToken("1", "AppConfigEntity");
		return Response.status(200).entity(appConfig.getJson()).build();
	}
	
	
	@GET
	@Path("/config/ios/{version}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAppConfigIos(@HeaderParam("Authorization") String authorization,
			@HeaderParam("If-Modified-Since") String ifModifiedSince, @PathParam("version") String version)
			throws ApiException {
		AppConfigEntity appConfig = (AppConfigEntity) meuTimFacade.getEntityByToken("2", "AppConfigEntity");
		return Response.status(200).entity(appConfig.getJson()).build();

	}

	@GET
	@Path("/themes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTheme(@HeaderParam("Authorization") String authorization) throws ApiException {
		ThemeApiEntity themeApi = (ThemeApiEntity) meuTimFacade.getEntityByToken(authorization, "ThemeApiEntity");
		return Response.status(200).entity(themeApi.getJson()).build();

	}

	@GET
	@Path("/groups")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGroup(@HeaderParam("Authorization") String authorization) throws ApiException {
		ROGroupListEntity groupList = new ROGroupListEntity();
		groupList = (ROGroupListEntity) meuTimFacade.getEntityByToken(authorization, "ROGroupListEntity");
		return Response.status(200).entity(groupList.getJson()).build();

	}
}