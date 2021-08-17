package inetbanking_application_v1_pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public static WebDriver ldriver;
	public LoginPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement weun;
	
	@FindBy(name="password")
	WebElement wepw;
	
	@FindBy(name="btnLogin")
	WebElement welb;
	
	public void setUserName(String uname) {
		weun.sendKeys(uname);
	}
	
	public void setPassword(String pword) {
		wepw.sendKeys(pword);
		
	}
	
	public void clickLogin() {
		welb.click();
	}
}
