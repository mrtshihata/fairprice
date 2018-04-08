/**
	 * grace tshihata
	 */
package com.minute.rest.webservices.callers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;

@SuppressWarnings("static-access")
public class LoginCaller {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private static LoginCaller PropertiesCache;
	private final static Properties configProp = new Properties();
	private static String Propertyfilename = "login.properties";

	public LoginCaller setPropertyfilename(String Propertyfilename) {
		this.Propertyfilename = Propertyfilename;
		return this;

	}

	/***
	 * configcaller loads the property called in the .properties file
	 */

	public LoginCaller() {
		// Private constructor to restrict new instances
		InputStream in = this.getClass().getClassLoader().getResourceAsStream(Propertyfilename);
		LOGGER.info("Reading properties from file: " + Propertyfilename);
		try {
			configProp.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Bill Pugh Solution for singleton pattern
	
	/**
	 * Directive:
	 * Only use the static methods for testing the framework functionality.  Write getters 
	 * to access specific properties so that no input strings are hard coded in your tests.
	 */
	
	public static class ResourceLoader {
		private static final LoginCaller INSTANCE = new LoginCaller();
	}

	public static LoginCaller getInstance() {
		return ResourceLoader.INSTANCE;
	}

	public static String getProperty(String key) {
		return configProp.getProperty(key);
	}

	public Set<String> getAllPropertyNames() {
		return configProp.stringPropertyNames();
	}

	public boolean containsKey(String key) {
		return configProp.containsKey(key);
	}

	public void setProperty(String key, String value) {
		configProp.setProperty(key, value);
	}

	// Main class exclusivly to test this class file.
	public static void main(String[] args) {
		// Get individual properties
		System.out.println(PropertiesCache.getInstance().getProperty("username_path"));
		// All property names
		System.out.println(PropertiesCache.getInstance().getAllPropertyNames());
	}

	/**
	 * adding all callers for environments this is where you call a specific
	 * environment please do not hardcode the in your code add a propertycaller
	 * for it under this segment.
	 */

	public String username_Path() {
		return PropertiesCache.getInstance().getProperty("username_path");
	}

	public String password_Path() {
		return PropertiesCache.getInstance().getProperty("password_path");
	}

	public String username_Id() {
		return PropertiesCache.getInstance().getProperty("username_id");
	}
	
	public String password_Id() {
		return PropertiesCache.getInstance().getProperty("password_id");
	}
	
	public String login_submit_btn_id() {
		return PropertiesCache.getInstance().getProperty("login_submit_btn_id");
	}
	
	public String submit_Btn_Path() {
		return PropertiesCache.getInstance().getProperty("login_submit_btn");
	}
	
	public String submit_Btn_Css() {
		return PropertiesCache.getInstance().getProperty("submit_btn_css");
	}
	
	public String username_Txt_Path() {
		return PropertiesCache.getInstance().getProperty("username_txt_path");
	}

	public String password_Txt_Path() {
		return PropertiesCache.getInstance().getProperty("password_txt_path");
	}
	public String titlle_class() {
		return PropertiesCache.getInstance().getProperty("titlle_class");
	}
	public String setup_Security_Question_ok_id() {
		return PropertiesCache.getInstance().getProperty("setup_Security_Question_ok_id");
	}
	public String security_Questions_Cancel_id() {
		return PropertiesCache.getInstance().getProperty("security_Questions_Cancel_id");
	}
	
	
	

	
}
