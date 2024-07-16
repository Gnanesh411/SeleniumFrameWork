package TestCases;

import org.testng.annotations.Test;

import PageObjects.LoginPageOrangeHrm;
import baseTest.BaseClass1;

public class LoginPageTestCaseOrangeHrm extends BaseClass1 {

	@Test
	public void LoginTest() throws InterruptedException {
		LoginPageOrangeHrm lg = new LoginPageOrangeHrm(driver);
		lg.EnterUserName("Admin");
		lg.EnterPassWord("admin123");
		lg.ClickOnLogin();
	}
}
