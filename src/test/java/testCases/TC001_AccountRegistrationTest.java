package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
		

	
	@Test(groups = {"Sanity", "Master", "Regression"})
	public void verify_acc_registration() throws InterruptedException {
		
		HomePage hPage=new HomePage(driver);
		
		hPage.clickMyAccount();
		hPage.clickRegister();
		
		AccountRegistrationPage registerAcc=new AccountRegistrationPage(driver);
		
		registerAcc.setFirstname(randomString().toUpperCase());
		registerAcc.setLastname(randomString().toUpperCase());
		registerAcc.setEmail(randomString()+"@gmail.com");
		registerAcc.setTelephone(randomNumber());
		
		String passString=alphanumericStrig();
		
		registerAcc.setPassword(passString);
		registerAcc.setConfirmPassword(passString);
		registerAcc.setpolicy();
		registerAcc.clickContinue();
		
		
		String confirmationmessage=registerAcc.getConfirmationmesg();
		
		Assert.assertEquals(confirmationmessage, "Your Account Has Been Created!");
		
	}
	
	
}
