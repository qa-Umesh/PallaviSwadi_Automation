package com.PS.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Read_config {

	Properties properties; // to read config file we use properties class

	String configPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator + "config.properties";

	public Read_config() {
		try  {
			FileInputStream file = new FileInputStream(configPath);
			properties = new Properties();
			properties.load(file);

		} catch (Exception e) {
			throw new RuntimeException("Configuration Failed: File not found",e);

		}
	}

	public String getURL()
	{

		String url=properties.getProperty("url");
		if(url!=null)
		{
			return url;
		}
		else
		{
			throw new RuntimeException("URL is not Defined in Configuration");
		}
	}

	public String getBrowser()
	{
		String browser=properties.getProperty("browser");
		if(browser!=null)
		{
			return browser;
		}
		else
		{
			throw new RuntimeException("Browser not dedined in configuraion");
		}

	}

	public String getUserName()
	{
		String username=properties.getProperty("username");
		if(username!=null)
		{
			return username;
		}
		else
		{
			throw new RuntimeException("User name not defined in Configuration");
		}
	}

	public String getpasswrod()
	{
		String password=properties.getProperty("password");
		if(password!=null)
		{
			return password;

		}
		else
		{
			throw new RuntimeException("Password not defined in Configuration");
		}
	}


}
