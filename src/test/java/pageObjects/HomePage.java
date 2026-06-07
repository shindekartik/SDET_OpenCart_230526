package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class HomePage extends BasePage{
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement btnMyAccountElement;
	
	@FindBy(xpath = "//a[contains(text(),'Register')]")
	WebElement lnkRegisterElement;
	
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement lnkLoginElement;
	
	
	public void clickMyAccount() {
		
		btnMyAccountElement.click();
		
	}
	
	public void clickRegister() {
		lnkRegisterElement.click();
	}
	
	public void clickLogin() {
		lnkLoginElement.click();
	}

}
