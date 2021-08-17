package inetbanking_application_v1_testcases;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import inetbanking_application_v1_utils.ReadConfig;

public class BaseClass {
	ReadConfig rc = new ReadConfig();
	public String url = rc.getUrl();
	public String un=rc.getUn();
	public String pw = rc.getPass();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String val) {
		logger = Logger.getLogger("E-Banking");
		PropertyConfigurator.configure("log4j.properties");
		if(val.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", rc.getChrome());
		driver = new ChromeDriver();
		}else if(val.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", rc.getFirefox());
			driver = new FirefoxDriver();
		}else if(val.equals("ie")) {
			System.setProperty("webdriver.ie.driver", rc.getIe());
			driver = new InternetExplorerDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void close(){
		driver.close();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
