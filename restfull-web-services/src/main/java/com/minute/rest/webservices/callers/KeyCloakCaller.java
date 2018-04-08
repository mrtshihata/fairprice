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
public class KeyCloakCaller {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private static KeyCloakCaller PropertiesCache;
	private final static Properties configProp = new Properties();
	private static String Propertyfilename = "keyCloak.properties";

	public KeyCloakCaller setPropertyfilename(String Propertyfilename) {
		this.Propertyfilename = Propertyfilename;
		return this;

	}

	/***
	 * configcaller loads the property called in the .properties file
	 */

	public KeyCloakCaller() {
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
		private static final KeyCloakCaller INSTANCE = new KeyCloakCaller();
	}

	public static KeyCloakCaller getInstance() {
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

	public String getBaseUri() {
		return PropertiesCache.getInstance().getProperty("baseUri");
	}

	public String getRequestHeaderKey0() {
		return PropertiesCache.getInstance().getProperty("requestHeaderKey0");
	}

	public String getRequestHeaderValue0() {
		return PropertiesCache.getInstance().getProperty("requestHeaderValue0");
	}
	
	public String getRequestBodyKey0() {
		return PropertiesCache.getInstance().getProperty("requestBodyKey0");
	}	
	
	public String getRequestBodyValue0() {
		return PropertiesCache.getInstance().getProperty("requestBodyValue0");
	}
	
	public String getRequestBodyKey1() {
		return PropertiesCache.getInstance().getProperty("requestBodyKey1");
	}	
	
	public String getRequestBodyValue1() {
		return PropertiesCache.getInstance().getProperty("requestBodyValue1");
	}
	
	public String getRequestBodyKey2() {
		return PropertiesCache.getInstance().getProperty("requestBodyKey2");
	}	
	
	public String getRequestBodyValue2() {
		return PropertiesCache.getInstance().getProperty("requestBodyValue2");
	}
	
	public String getRequestBodyKey3() {
		return PropertiesCache.getInstance().getProperty("requestBodyKey3");
	}	
	
	public String getRequestBodyValue3() {
		return PropertiesCache.getInstance().getProperty("requestBodyValue3");
	}
	
}

