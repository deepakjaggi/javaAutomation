package com.ServicesAutomation.login;

import com.jayway.restassured.response.Response;

import servicesAutomation.handleResponse.CustomJsonParsor;
import servicesAutomation.handleResponse.ExecuteService;

public class Login {
	public Login executeLoginValidateService(Login login, String url) {
		try {
			ExecuteService executeService = new ExecuteService();
			Response response = executeService.executePostService(new CustomJsonParsor().makJSONFromData(login), url);
			Login responseModel = new Login();
			responseModel = (Login) executeService.handleResponse(response, Login.class);
			return responseModel;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
