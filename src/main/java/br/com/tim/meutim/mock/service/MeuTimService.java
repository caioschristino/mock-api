package br.com.tim.meutim.mock.service;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.tim.meutim.mock.entity.AppConfigEntity;
import br.com.tim.meutim.mock.entity.BalanceBasicEntity;
import br.com.tim.meutim.mock.entity.BalanceEntity;
import br.com.tim.meutim.mock.entity.BalanceRechargeEntity;
import br.com.tim.meutim.mock.entity.BillingProfileEntity;
import br.com.tim.meutim.mock.entity.ConsumerConsumptionEntity;
import br.com.tim.meutim.mock.entity.CustomerEntity;
import br.com.tim.meutim.mock.entity.DataMyEntity;
import br.com.tim.meutim.mock.entity.LastInvoicesEntity;
import br.com.tim.meutim.mock.entity.PackageRenewUpgradeEntity;
import br.com.tim.meutim.mock.entity.ProfileEntity;
import br.com.tim.meutim.mock.entity.RODataMyUsageEntity;
import br.com.tim.meutim.mock.entity.ROGroupListEntity;
import br.com.tim.meutim.mock.entity.StatusEntity;
import br.com.tim.meutim.mock.entity.ThemeApiEntity;
import br.com.tim.meutim.mock.entity.VoiceMyUsageEntity;
import br.com.tim.meutim.mock.errorhandling.ApiException;
import br.com.tim.meutim.mock.facade.MeuTimFacade;

@Path("/v1/mock")
public class MeuTimService {

	@Inject
	private MeuTimFacade meuTimFacade;

	@POST
	@Path("/customerData")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getGroup(@HeaderParam("customerToken") String customerToken,
			@HeaderParam("appToken") String appToken, @HeaderParam("msisdn") String msisdn,
			@HeaderParam("platform") String platform) throws ApiException {

		String token = msisdn + " " + msisdn;
		String json = "";
		String pathConfig = "";

		if (platform.equals("android")) {
			pathConfig = "v1/appmeutim/config/android/5.18";
		} else {
			pathConfig = "v1/appmeutim/config/ios/5.18";
		}

		AppConfigEntity appConfigEntity = new AppConfigEntity();
		json = this.getService(appToken, pathConfig);
		appConfigEntity.setToken(token);
		appConfigEntity.setJson(json);
		meuTimFacade.create(appConfigEntity, token, AppConfigEntity.class);

		ROGroupListEntity GroupListEntity = new ROGroupListEntity();
		json = this.getService(appToken, "v1/appmeutim/groups");
		GroupListEntity.setToken(token);
		GroupListEntity.setJson(json);
		meuTimFacade.create(GroupListEntity, token, ROGroupListEntity.class);

		ThemeApiEntity themeApiEntity = new ThemeApiEntity();
		json = this.getService(appToken, "v1/appmeutim/themes");
		themeApiEntity.setToken(token);
		themeApiEntity.setJson(json);
		meuTimFacade.create(themeApiEntity, token, ThemeApiEntity.class);

		ProfileEntity profileEntity = new ProfileEntity();
		json = this.getService(customerToken, "v3/user/self");
		profileEntity.setToken(token);
		profileEntity.setJson(json);
		meuTimFacade.create(profileEntity, token, ProfileEntity.class);

		BillingProfileEntity billingProfile = new BillingProfileEntity();
		json = this.getService(customerToken, "v1/customer/billingProfile");
		billingProfile.setToken(token);
		billingProfile.setJson(json);
		meuTimFacade.create(billingProfile, token, BillingProfileEntity.class);

		ConsumerConsumptionEntity consumerConsumption = new ConsumerConsumptionEntity();
		json = this.getService(customerToken, "v1/customer/consumption");
		consumerConsumption.setToken(token);
		consumerConsumption.setJson(json);
		meuTimFacade.create(consumerConsumption, token, ConsumerConsumptionEntity.class);

		CustomerEntity customer = new CustomerEntity();
		json = this.getService(customerToken, "v2/customer/accountData");
		customer.setToken(token);
		customer.setJson(json);
		meuTimFacade.create(customer, token, CustomerEntity.class);

		DataMyEntity dataMy = new DataMyEntity();
		json = this.getService(customerToken, "v2/packages/data/my");
		dataMy.setToken(token);
		dataMy.setJson(json);
		meuTimFacade.create(dataMy, token, DataMyEntity.class);

		RODataMyUsageEntity dataMyUsage = new RODataMyUsageEntity();
		json = this.getService(customerToken, "v2/packages/data/my/usage");
		dataMyUsage.setToken(token);
		dataMyUsage.setJson(json);
		meuTimFacade.create(dataMyUsage, token, RODataMyUsageEntity.class);

		PackageRenewUpgradeEntity packageRenewUpgrade = new PackageRenewUpgradeEntity();
		json = this.getService(customerToken, "v2/packages/data/eligible");
		packageRenewUpgrade.setToken(token);
		packageRenewUpgrade.setJson(json);
		meuTimFacade.create(packageRenewUpgrade, token, PackageRenewUpgradeEntity.class);

		VoiceMyUsageEntity voiceMyUsage = new VoiceMyUsageEntity();
		json = this.getService(customerToken, "v3/packages/voice/my/usage");
		voiceMyUsage.setToken(token);
		voiceMyUsage.setJson(json);
		meuTimFacade.create(voiceMyUsage, token, VoiceMyUsageEntity.class);

		LastInvoicesEntity lastInvoice = new LastInvoicesEntity();
		json = this.getService(customerToken, "v2/invoices/history");
		lastInvoice.setToken(token);
		lastInvoice.setJson(json);
		meuTimFacade.create(lastInvoice, token, LastInvoicesEntity.class);

		BalanceEntity balance = new BalanceEntity();
		json = this.getService(customerToken, "v2/customer/balance");
		balance.setToken(token);
		balance.setJson(json);
		meuTimFacade.create(balance, token, BalanceEntity.class);

		BalanceRechargeEntity balanceRecharge = new BalanceRechargeEntity();
		json = this.getService(customerToken, "v1/customer/balance/recharge");
		balanceRecharge.setToken(token);
		balanceRecharge.setJson(json);
		meuTimFacade.create(balanceRecharge, token, BalanceRechargeEntity.class);

		BalanceBasicEntity balanceBasic = new BalanceBasicEntity();
		json = this.getService(customerToken, "v1/customer/balance/basic");
		balanceBasic.setToken(token);
		balanceBasic.setJson(json);
		meuTimFacade.create(balanceBasic, token, BalanceBasicEntity.class);
		
		StatusEntity statusEntity = new StatusEntity();
		json = this.getService(customerToken, "v1/api/status");
		statusEntity.setToken(token);
		statusEntity.setJson(json);
		meuTimFacade.create(statusEntity, token, StatusEntity.class);

		return Response.status(200).build();
	}

	private String getService(String authorization, String path) {
		Client client = ClientBuilder.newClient();
		Builder builder = client.target("https://api2.tim.com.br/" + path).request();
		builder.header("Authorization", "Bearer " + authorization);
		String result = builder.get(String.class);
		return result;
	}
}