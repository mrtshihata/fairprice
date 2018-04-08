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
public class RoundingAppCaller {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private static RoundingAppCaller PropertiesCache;
	private final static Properties configProp = new Properties();
	private static String Propertyfilename = "roundingApp.properties";

	public RoundingAppCaller setPropertyfilename(String Propertyfilename) {
		this.Propertyfilename = Propertyfilename;
		return this;

	}

	/***
	 * configcaller loads the property called in the .properties file
	 */

	public RoundingAppCaller() {
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
		private static final RoundingAppCaller INSTANCE = new RoundingAppCaller();
	}

	public static RoundingAppCaller getInstance() {
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
		System.out.println(PropertiesCache.getInstance().getProperty("ciHost"));
		// All property names
		System.out.println(PropertiesCache.getInstance().getAllPropertyNames());
	}

	/**
	 * adding all callers for environments this is where you call a specific
	 * environment please do not hardcode the in your code add a propertycaller
	 * for it under this segment.
	 */

	public String getOrderSigningUri() {
		return PropertiesCache.getInstance().getProperty("orderSigningUri");
	}

	public String getRoundingUiUri() {
		return PropertiesCache.getInstance().getProperty("roundingUiUri");
	}
	
	public String get_Echarting_App_Xpath() {
		return PropertiesCache.getInstance().getProperty("Echarting_App_Xpath");
	}
	
	public String get_Echarting_App_Id() {
		return PropertiesCache.getInstance().getProperty("Echarting_App_Id");
	}
	
	public String get_Messagecenter_App_Xpath() {
		return PropertiesCache.getInstance().getProperty("Messagecenter_App_Xpath");
	}
	
	public String get_Messagecenter_App_Id() {
		return PropertiesCache.getInstance().getProperty("Messagecenter_App_Id");
	}
	
	public String get_MessageCenter_Banner() {
		return PropertiesCache.getInstance().getProperty("messageCenter_Banner");
	}

	public String get_Echarting_Banner() {
		return PropertiesCache.getInstance().getProperty("echarting_Banner");
	}
	
}

