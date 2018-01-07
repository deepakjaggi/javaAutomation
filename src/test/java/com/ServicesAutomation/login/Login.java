package com.ServicesAutomation.login;

import com.ServicesAutomation.common.LoginCommon;
import com.jayway.restassured.response.Response;

import servicesAutomation.handleResponse.CustomJsonParsor;
import servicesAutomation.handleResponse.ExecuteService;
import servicesAutomation.models.LoginModel;

public class Login {

	public LoginModel executeLoginService(LoginModel loginRequest, String url) {
		try {
			ExecuteService executeService = new ExecuteService();
			Response response = executeService.executePostService(new CustomJsonParsor().makJSONFromData(loginRequest),
					url);
			LoginModel responseModel = new LoginModel();
			responseModel = (LoginModel) executeService.handleResponse(response, LoginModel.class);
			LoginCommon.loginResponse=responseModel;
			return responseModel;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
