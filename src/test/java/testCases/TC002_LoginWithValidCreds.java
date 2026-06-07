package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_LoginWithValidCreds extends BaseClass {
	
	
	
	@Test(groups = {"Master", "Regression"})
	public void verify_validlogin() throws InterruptedException 
	{
		logger.info("**** Starting TC002_LoginWithValidCreds ****");
		
		try {
		
		HomePage hPage=new HomePage(driver);
		
		logger.info("**** Clicked on My Account ****");
		hPage.clickMyAccount();
		
		logger.info("**** Clicked on Login button on homepage ****");
		hPage.clickLogin();
		LoginPage lPage=new LoginPage(driver);
		
		logger.info("**** Added user details ****");
		lPage.enterEmail("kartik.shinde32@gmx.com");
		lPage.enterpassword("Sksd13#");
//		Thread.sleep(5000);
		
		logger.info("**** Clicked on Login ****");

		lPage.clickToLogin();
		Thread.sleep(2000);
		}
		catch (Exception e) {
			logger.error("Test Failed");
			logger.error("Debug logs");

		}
		
		logger.info("**** TC002 Finished ****");
	}
		
		

}
