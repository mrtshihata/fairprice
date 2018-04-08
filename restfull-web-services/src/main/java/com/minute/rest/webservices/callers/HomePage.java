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
public class HomePage {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private static HomePage PropertiesCache;
	private final static Properties configProp = new Properties();
	private static String Propertyfilename = "homepage.properties";
	
	public HomePage setPropertyfilename(String Propertyfilename) {
		this.Propertyfilename = Propertyfilename;
		return this;
	}

	/***
	 * configcaller loads the property called in the .properties file
	 */

	public HomePage() {
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
		private static final HomePage INSTANCE = new HomePage();
	}

	public static HomePage getInstance() {
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
		System.out.println(PropertiesCache.getInstance().getProperty("homepagetitlepath"));
		// All property names
		System.out.println(PropertiesCache.getInstance().getAllPropertyNames());
	}

	/**
	 * adding all callers for environments this is where you call a specific
	 * environment please do not hardcode the in your code add a propertycaller for
	 * it under this segment.
	 */

	public String logo() {
		return PropertiesCache.getInstance().getProperty("logo_css");
	}

	public String Unsigned_Orders() {
		return PropertiesCache.getInstance().getProperty("Unsigned_Orders_xpath");
	}

	public String Number_Of_Unsigned_Orders() {
		return PropertiesCache.getInstance().getProperty("Number_Of_Unsigned_Orders_xpath");
	}

	public String Number_Of_Unsigned_Orders_id() {//KWR added to access by id
		return PropertiesCache.getInstance().getProperty("Number_Of_Unsigned_Orders_id");
	}
	public String username_xpath() {
		return PropertiesCache.getInstance().getProperty("username_path");
	}
	
	//added by pnayak on 02/02/2018
	public String getInboxTabHeaderXpath() {
		return PropertiesCache.getInstance().getProperty("commsHub_InboxTab_header_xPath");
	}
	
	//added by pnayak on 02/02/2018
	public String getBbookmarkedTabHeaderXpath() {
		return PropertiesCache.getInstance().getProperty("commsHub_BookmarkedTab_header_xPath");
	}
	
	//added by pnayak on 02/02/2018
	public String getResourcesTabHeaderXpath() {
		return PropertiesCache.getInstance().getProperty("commsHub_ResourcesTab_header_xPath");
	}
	
	//added by pnayak on 02/02/2018
		public String getCommsHubFrameHeaderXpath() {
			return PropertiesCache.getInstance().getProperty("commsHub_Frame_header_xPath");
		}

	public String username() {
		return PropertiesCache.getInstance().getProperty("username");
	}

	public String patient_OrderSummary_header_txt_id() {
		return PropertiesCache.getInstance().getProperty("patient_OrderSummary_header_txt_id");
	}

	public String facility_OrderSummary_header_txt_id() {
		return PropertiesCache.getInstance().getProperty("facility_OrderSummary_header_txt_id");
	}

	public String status_OrderSummary_header_txt_id() {
		return PropertiesCache.getInstance().getProperty("status_OrderSummary_header_txt_id");
	}

	public String entered_OrderSummary_header_txt_id() {
		return PropertiesCache.getInstance().getProperty("entered_OrderSummary_header_txt_id");
	}

	public String orders_OrderSummary_header_txt_id() {
		return PropertiesCache.getInstance().getProperty("orders_OrderSummary_header_txt_id");
	}

	public String justification_OrderSummary_header_txt_id() {
		return PropertiesCache.getInstance().getProperty("justification_OrderSummary_header_txt_id");
	}
	public String select_all_checkbox_id() {
		return PropertiesCache.getInstance().getProperty("select_all_checkbox_id");
	}
	public String select_all_checkbox_css() {
		return PropertiesCache.getInstance().getProperty("select_all_checkbox_css");
	}
	public String order_summary_table_grid() {
		return PropertiesCache.getInstance().getProperty("order_summary_table_grid");
	}
	public String order_summary_data_row() {
		return PropertiesCache.getInstance().getProperty("order_summary_data_row");
	}
	public String order_summary_table_grid_header() {
		return PropertiesCache.getInstance().getProperty("order_summary_table_grid_header");
	}
	public String order_summary_table_grid_row_cell() {
		return PropertiesCache.getInstance().getProperty("order_summary_table_grid_row_cell");
	}
	public String getContentsCellInBlockFormat() {
		return PropertiesCache.getInstance().getProperty("cell_contents_block");
	}
	public String getContentsCellInEllipseFormat() {
		return PropertiesCache.getInstance().getProperty("cell_contents_ellipses");
	}
	public String usernameToggle() {
		return PropertiesCache.getInstance().getProperty("username_toggle");
	}
	
}
