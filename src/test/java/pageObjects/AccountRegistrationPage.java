package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstNameElement;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastNameElement;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmailElement;
	
	@FindBy(id ="input-telephone")
	WebElement txtTelephonElement;
	
	@FindBy(name="password")
	WebElement txtPasswprdElement;
	
	@FindBy(id="input-confirm")
	WebElement txtConfirmPasswordElement;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkdPolicyElement;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btncontinuElement;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmationElement;
	
	public void setFirstname(String fname) {
		txtFirstNameElement.sendKeys(fname);
		
	}
	
	public void setLastname(String Lname) {
		txtLastNameElement.sendKeys(Lname);
		
	}
	
	public void setEmail(String Email) {
		txtEmailElement.sendKeys(Email);
	}
	
	public void setTelephone(String telephone) {
		txtTelephonElement.sendKeys(telephone);
		
	}
	
	public void setPassword(String password) {
		txtPasswprdElement.sendKeys(password);
		
	}
	
	public void setConfirmPassword(String password) {
		txtConfirmPasswordElement.sendKeys(password);
		
	}
	
	public void setpolicy() {
		chkdPolicyElement.click();
		
	}
	
	public void clickContinue() {
		btncontinuElement.click();
		
//		if normal click is not working use Actions class
		
//		Actions actions=new Actions(driver);
//		actions.moveToElement(btncontinuElement).click().perform();
		
	}
	
	public String getConfirmationmesg() {
		try {
			return(msgConfirmationElement.getText());
		}
		catch (Exception e) {
			
			return(e.getMessage());
		
		}
	}
	
}


