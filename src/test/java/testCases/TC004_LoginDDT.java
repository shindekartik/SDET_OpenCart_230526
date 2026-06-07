package testCases;

import org.apache.logging.log4j.core.appender.rolling.action.IfAccumulatedFileCount;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC004_LoginDDT extends BaseClass {
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class) //gettig dataproviders from different class hence need .class 
    public void VerifyLogin_DDT(String email, String pass, String exp) {
		   
		   logger.info("***starting TC***");
		 try {
		   HomePage hPage=new HomePage(driver);
		   hPage.clickMyAccount();
		   hPage.clickLogin();
		   
		   LoginPage loginPage=new LoginPage(driver);
		   loginPage.enterEmail(email);
		   loginPage.enterpassword(pass);
		   loginPage.clickToLogin();
		   
		  MyAccountPage myAccountPage=new MyAccountPage(driver);
		  boolean targetPage=myAccountPage.ismyAccheadingexist();
		  
		  
		  if(exp.equalsIgnoreCase("Valid"))
		  {
			  if(targetPage==true)
			  {
				  myAccountPage.logout();
				  Assert.assertTrue(true);
			  }
			  else {
				  Assert.assertTrue(false);
				  
			  }
		  }
		  
		  if(exp.equalsIgnoreCase("Invalid"))
		  {
			  if(targetPage==true)
			  {
				  myAccountPage.logout();
				  Assert.assertTrue(false);
			  }
			  else {
				  Assert.assertTrue(true);
			}
		  }
		  
		   }catch (Exception e) {
			Assert.fail();
		}
		 
		 logger.info("***TC004 is finished***");
	}
	

}
