package com.minute.rest.webservices.callers;

/**
 * grace tshihata
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;

@SuppressWarnings("static-access")
public class ALMconfigCaller {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private static ALMconfigCaller PropertiesCache;
	private final static Properties configProp = new Properties();
	private static String Propertyfilename = "login.properties";

	public ALMconfigCaller setPropertyfilename(String Propertyfilename) {
		this.Propertyfilename = Propertyfilename;
		return this;

	}

	/***
	 * configcaller loads the property called in the .properties file
	 */

	public ALMconfigCaller() {
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
	 * Directive: Only use the static methods for testing the framework
	 * functionality. Write getters to access specific properties so that no input
	 * strings are hard coded in your tests.
	 */

	public static class ResourceLoader {
		private static final ALMconfigCaller INSTANCE = new ALMconfigCaller();
	}

	public static ALMconfigCaller getInstance() {
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

	/**
	 * adding all callers for environments this is where you call a specific
	 * environment please do not hardcode the in your code add a propertycaller for
	 * it under this segment.
	 */

	public String get_alm_server() {
		return PropertiesCache.getInstance().getProperty("alm_server");
	}

	public String get_alm_domain() {
		return PropertiesCache.getInstance().getProperty("alm_domain");
	}

	public String get_alm_project() {
		return PropertiesCache.getInstance().getProperty("alm_project");
	}

	public String get_alm_folderPath() {
		return PropertiesCache.getInstance().getProperty("alm_folderPath");
	}

	public String get_testSet() {
		return PropertiesCache.getInstance().getProperty("testSet");
	}

	public String get_alm_username() {
		return PropertiesCache.getInstance().getProperty("alm_username");
	}

	public String get_alm_password() {
		return PropertiesCache.getInstance().getProperty("alm_password");
	}

	public String get_domain() {
		return PropertiesCache.getInstance().getProperty("domain");
	}

}
