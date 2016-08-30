package util;

import java.util.Properties;

public class SystemValue {
	
	public final static String CLASS_NAME;
	public final static String URL;
	public final static String USERNAME;
	public final static String PASSWORD;
	
	static{
		Properties properties = new Properties();
		try {
			properties.load(SystemValue.class.getResourceAsStream("/jdbc.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		CLASS_NAME = properties.getProperty("jdbc.driverClassName");
		URL = properties.getProperty("jdbc.url");
		USERNAME = properties.getProperty("jdbc.username");
		PASSWORD = properties.getProperty("jdbc.password");
	}
}
