package testCases;

import java.lang.annotation.Target;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC003_loginUsing_configFileData extends BaseClass {
	
	   @Test
       public void loginUsingConfigfiledetails() {
		   
		   logger.info("***starting TC***");
		   try {
		   HomePage hPage=new HomePage(driver);
		   hPage.clickMyAccount();
		   hPage.clickLogin();
		   
		   LoginPage loginPage=new LoginPage(driver);
		   loginPage.enterEmail(p.getProperty("email"));
		   loginPage.enterpassword(p.getProperty("pass"));
		   loginPage.clickToLogin();
		   
		  MyAccountPage myAccountPage=new MyAccountPage(driver);
		boolean targetpage =myAccountPage.ismyAccheadingexist();
		
		Assert.assertTrue(targetpage); 
//		Assert.assertEquals(targetpage, true,"Login failed");
		   }
		   catch (Exception e) {
			Assert.fail();
		}
		logger.info("**Finished TC003");
	}
}
