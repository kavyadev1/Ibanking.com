package Ibanking.com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
		
		try {
			{
				FileInputStream fis = new FileInputStream(src);
				pro =  new Properties();
				pro.load(fis);
				
			}
		} catch (IOException e) {
			
			System.out.println("Exception is" + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getUsername() 
	{
	    String username = pro.getProperty("username");
	    return username;
	}

	public String getPassword() 
	{
	    String password = pro.getProperty("password");
	    return password;
	}
	public String getChromeDriverPath() 
	{
	    String chromeDriverPath = pro.getProperty("chromeDriverPath");
	    return chromeDriverPath;
	}

	public String getFirefoxDriverPath() {
		
		String firefoxDriverPath = pro.getProperty("firefoxdriverath");
		// TODO Auto-generated method stub
		return firefoxDriverPath;
	}

	public String getIEDriverPath() {
		String firefoxDriverPath = pro.getProperty("IEdriverPath");
		// TODO Auto-generated method stub
		return getIEDriverPath();		
	}

}
