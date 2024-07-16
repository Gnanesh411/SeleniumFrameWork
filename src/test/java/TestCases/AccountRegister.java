package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import baseTest.BaseClass;

public class AccountRegister extends BaseClass {

	@Test
	public void Register() {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();

		RegistrationPage rp = new RegistrationPage(driver);
		rp.setFirstName(randomString());
		rp.setLastName(randomString());
		rp.setEmail(randomString().concat("@gmail.com"));
		rp.setTelephone(randomNumber());

		String password = randomAlphNumeric();

		rp.setPassword(password);
		rp.setConfirmPassword(password);
		rp.setPrivacyPolicy();
		rp.clickContinue();
		Screenshots();
		
		Assert.assertEquals(driver.getCurrentUrl(),"https://tutorialsninja.com/demo/index.php?route=account/success");

	}
}
