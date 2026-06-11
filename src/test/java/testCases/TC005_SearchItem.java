package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC005_SearchItem extends BaseClass {
	
	@Test(groups="Sanity")
	public void searchproduct() {
		
		HomePage hPage=new HomePage(driver);
		hPage.clickMyAccount();
		hPage.clickLogin();
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterEmail(p.getProperty("email"));
		loginPage.enterpassword(p.getProperty("pass"));
		loginPage.clickToLogin();
		
		MyAccountPage accountPage=new MyAccountPage(driver);
		accountPage.ismyAccheadingexist();
		
		accountPage.search("Apple Cinema 30");
		accountPage.btnclicktoserach();
		
		WebElement productElement=driver.findElement(By.linkText("Apple Cinema 30\""));
	    String linktext=	productElement.getText();
	    
	    Assert.assertEquals(linktext, "Apple Cinema 30\"");
		
		
	}

}
