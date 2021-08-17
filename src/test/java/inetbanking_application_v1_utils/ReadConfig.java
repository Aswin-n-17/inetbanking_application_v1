package inetbanking_application_v1_utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig() {
		File src = new File("./Config/config.properties");
		
			
			
		try {		
		FileInputStream fis = new FileInputStream(src);
			
			 pro = new Properties();
			
				pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
			
		
	}
	public String getUrl() {
		String url = pro.getProperty("url");
		return url;
	}
	public String getUn() {
		String username = pro.getProperty("un");
		return username;
	}
	public String getPass() {
		String password = pro.getProperty("pw");
		return password;
	}
	public String getChrome() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	public String getFirefox() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	public String getIe() {
		String iepath = pro.getProperty("iepath");
		return iepath;
	}
}
