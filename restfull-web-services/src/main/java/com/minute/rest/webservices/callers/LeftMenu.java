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
public class LeftMenu {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private static LeftMenu PropertiesCache;
	private final static Properties configProp = new Properties();
	private static String Propertyfilename = "leftmenu.properties";

	public LeftMenu setPropertyfilename(String Propertyfilename) {
		this.Propertyfilename = Propertyfilename;
		return this;

	}

	/***
	 * configcaller loads the property called in the .properties file
	 */

	public LeftMenu() {
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
		private static final LeftMenu INSTANCE = new LeftMenu();
	}

	public static LeftMenu getInstance() {
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
		System.out.println(PropertiesCache.getInstance().getProperty("menu_username_path"));
		// All property names
		System.out.println(PropertiesCache.getInstance().getAllPropertyNames());
	}

	/**
	 * adding all callers for environments this is where you call a specific
	 * environment please do not hardcode the in your code add a propertycaller for
	 * it under this segment.
	 */

	public String menu_username_path() {
		return PropertiesCache.getInstance().getProperty("menu_username_path");
	}

	public String Unsigned_Orders_Path() {
		return PropertiesCache.getInstance().getProperty("Unsigned_Orders_Path");
	}

	public String Dashborad_Path() {
		return PropertiesCache.getInstance().getProperty("Dashboard_Path");
	}

	public String It_Support_Path() {
		return PropertiesCache.getInstance().getProperty("It_Support_Path");
	}

	public String Physician_Hotline_Path() {
		return PropertiesCache.getInstance().getProperty("Physician_Hotline_Path");
	}


	public String Unsigned_Orders_Id() {
		return PropertiesCache.getInstance().getProperty("Unsigned_Orders_Id");
	}

	public String Dashboard_Id() {
		return PropertiesCache.getInstance().getProperty("Dashboard_Id");
	}

	public String unsigned_Orders_Path() {
		return PropertiesCache.getInstance().getProperty("unsigned_Orders_Path");
	}
	public String mock_Services_path() {
		return PropertiesCache.getInstance().getProperty("mock_Services_path");
	}

}
