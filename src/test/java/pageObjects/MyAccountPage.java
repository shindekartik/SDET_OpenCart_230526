package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement myAccountHeadingElement;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btnlogoutElement;
	
	@FindBy(xpath = "//input[@name=\"search\"]")
	WebElement searchBoxElement;
	
	@FindBy(xpath = "//button[@class=\"btn btn-default btn-lg\"]")
	WebElement btnsearch;
	
	public boolean ismyAccheadingexist() {
		try {
		return	myAccountHeadingElement.isDisplayed();
		}
		catch (Exception e) {
			return false;
		}
		
	}
	
	public void logout() {
		btnlogoutElement.click();
		
	}
	
	public void search(String searchcotext) {
		searchBoxElement.sendKeys(searchcotext);
		searchBoxElement.click();
		
	}
	
	public void btnclicktoserach() {
		btnsearch.click();
		
	}

}
