package TestData;

import pojo.LoginRequestPojo;

public class TestDataBuild {
	
	public  LoginRequestPojo loginPayload(String userEmail, String userPassword) {
		
		LoginRequestPojo lrp=new LoginRequestPojo();
		lrp.setUserEmail(userEmail);
		lrp.setUserPassword(userPassword);
		return lrp;		
	}

}
