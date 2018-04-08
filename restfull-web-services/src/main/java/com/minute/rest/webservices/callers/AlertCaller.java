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
public class AlertCaller {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private static AlertCaller PropertiesCache;
	private final static Properties configProp = new Properties();
	private static String Propertyfilename = "alert.properties";

	public AlertCaller setPropertyfilename(String Propertyfilename) {
		this.Propertyfilename = Propertyfilename;
		return this;

	}

	/***
	 * configcaller loads the property called in the .properties file
	 */

	public AlertCaller() {
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
		private static final AlertCaller INSTANCE = new AlertCaller();
	}

	public static AlertCaller getInstance() {
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
		System.out.println(PropertiesCache.getInstance().getProperty("runningServer"));
		// All property names
		System.out.println(PropertiesCache.getInstance().getAllPropertyNames());
	}

	/**
	 * adding all callers for environments this is where you call a specific
	 * environment please do not hardcode the in your code add a propertycaller
	 * for it under this segment.
	 */

	public String getAlertWindow() {
		return PropertiesCache.getInstance().getProperty("alertWindow");
	}
	public String getErrorMessage() {
		return PropertiesCache.getInstance().getProperty("alertMessageError");
	}
	public String getSuccessMessage() {
		return PropertiesCache.getInstance().getProperty("alertMessageSuccess");
	}
	public int getErrorRowIndex() {
		return Integer.parseInt(PropertiesCache.getInstance().getProperty("errorRowIndex"));
	}
	public int getErrorCellIndex() {
		return Integer.parseInt(PropertiesCache.getInstance().getProperty("errorCellIndex"));
	}
	public String getErrorPrefix() {
		return PropertiesCache.getInstance().getProperty("errorPrefix");
	}
	public String getSuccessPrefix() {
		return PropertiesCache.getInstance().getProperty("successPrefix");
	}
	public long getMaxDisplayMillis() {
		return Long.parseLong(PropertiesCache.getInstance().getProperty("maxDisplayMillis"));
	}
	public long getMinDisplayMillis() {
		return Long.parseLong(PropertiesCache.getInstance().getProperty("minDisplayMillis"));
	}
}
