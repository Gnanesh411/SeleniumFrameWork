package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageOrangeHrm extends BasePage1 {

	public LoginPageOrangeHrm(WebDriver driver) {
		super(driver);
	}

	By Uname = By.name("username");
	By Pass = By.name("password");
	By Click = By.xpath("//button[text()=' Login ']");

	public void EnterUserName(String userName) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(Uname).sendKeys(userName);
	}

	public void EnterPassWord(String PassWord) {
		driver.findElement(Pass).sendKeys(PassWord);
		;
	}

	public void ClickOnLogin() {
		driver.findElement(Click).click();
	}
}
