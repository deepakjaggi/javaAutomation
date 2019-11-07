package vipps.sitTestCases.testDataModel;

public class TestDataModel {
	private String tC;
	private String userName;
	private String passWord;
	private String confirmPassword;
	private String expectedResult;
	public String gettC() {
		return tC;
	}
	public void settC(String tC) {
		this.tC = tC;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getExpectedResult() {
		return expectedResult;
	}
	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}

	
}
