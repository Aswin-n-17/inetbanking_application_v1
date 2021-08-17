package inetbanking_application_v1_testcases;

import java.io.IOException;
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;

import inetbanking_application_v1_pageobjectmodel.LoginPage;

public class TestCase_001 extends BaseClass{
	@Test
	public void LoginTest() throws InterruptedException, IOException {
	
	LoginPage lp = new LoginPage(driver);
	logger.info("url is opened");
	Thread.sleep(5000);
	lp.setUserName(un);
	logger.info("username is entered");
	Thread.sleep(5000);
	lp.setPassword(pw);
	logger.info("password is entered");
	lp.clickLogin();
	logger.info("Login button is clicked");

if(driver.getTitle().equals("GTPL Bank Manager HomePage")) {
	Assert.assertTrue(true);
	logger.info("Test Case 001 is Successful");
}else {
	captureScreen(driver,"TestCase_001");
	Assert.assertFalse(false);
	logger.info("Test Case 001 is Not Successfull ");
}
	}
}
