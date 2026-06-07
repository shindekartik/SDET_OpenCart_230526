package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (xpath = "//input[@placeholder='E-Mail Address']")
	WebElement txtEmailElementToLogin;
	
	@FindBy (xpath = "//input[@placeholder='Password']")
	WebElement txtPassToLogin;
	
	@FindBy (xpath = "//input[@value='Login']")
	WebElement btnLoginElement;
	
	
	
	public void enterEmail(String email) {
		txtEmailElementToLogin.sendKeys(email);
		
	}
	
	public void enterpassword(String pass) {
		txtPassToLogin.sendKeys(pass);
		
	}
	
	public void clickToLogin() {
		btnLoginElement.click();
		
	}

}
