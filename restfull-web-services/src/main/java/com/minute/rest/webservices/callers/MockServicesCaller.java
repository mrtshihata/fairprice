package com.minute.rest.webservices.callers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;

@SuppressWarnings("static-access")
public class MockServicesCaller {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private static MockServicesCaller PropertiesCache;
	private final static Properties configProp = new Properties();
	private static String Propertyfilename = "mockServices.properties";

	public MockServicesCaller setPropertyfilename(String Propertyfilename) {
		this.Propertyfilename = Propertyfilename;
		return this;

	}

	/***
	 * configcaller loads the property called in the .properties file
	 */

	public MockServicesCaller() {
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
		private static final MockServicesCaller INSTANCE = new MockServicesCaller();
	}

	public static MockServicesCaller getInstance() {
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
		System.out.println(PropertiesCache.getInstance().getProperty("orders_path"));
		// All property names
		System.out.println(PropertiesCache.getInstance().getAllPropertyNames());
	}

	/**
	 * adding all callers for environments this is where you call a specific
	 * environment please do not hardcode the in your code add a propertycaller for
	 * it under this segment.
	 */

	public String orders_cwow_path() {
		return PropertiesCache.getInstance().getProperty("orders_cwow_path");
	}

	public String orders_cwow_nutritionOrder_path() {
		return PropertiesCache.getInstance().getProperty("orders_cwow_nutritionOrder_path");
	}

	public String orders_cwow_treatmentOrder_path() {
		return PropertiesCache.getInstance().getProperty("orders_cwow_treatmentOrder_path");
	}

	public String orders_cwow_physician_portalOrder_path() {
		return PropertiesCache.getInstance().getProperty("orders_cwow_physician_portalOrder_path");
	}

	public String facility_path() {
		return PropertiesCache.getInstance().getProperty("facility_path");
	}

	public String close_path() {
		return PropertiesCache.getInstance().getProperty("close_path");
	}
	public String close_path_css() {
		return PropertiesCache.getInstance().getProperty("close_path_css");
	}
	public String open_mock_path() {
		return PropertiesCache.getInstance().getProperty("open_mock_path");
	}
	public String open_mock_id() {
		return PropertiesCache.getInstance().getProperty("open_mock_id");
	}
	public String order_type_path() {
		return PropertiesCache.getInstance().getProperty("order_type_path");
	}

	public String all_orders_path() {
		return PropertiesCache.getInstance().getProperty("all_orders_path");
	}
	public String all_column_path() {
		return PropertiesCache.getInstance().getProperty("all_column_path");
	}
	public String enable_Order() {
		return PropertiesCache.getInstance().getProperty("enable_Order");
	}
	public String enable_order_css() {
		return PropertiesCache.getInstance().getProperty("enable_order_css");
	}
	public String order_count() {
		return PropertiesCache.getInstance().getProperty("order_count");
	}
	
	
}