package com.minute.rest.webservices.callers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;

@SuppressWarnings("static-access")
public class OrderCaller {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private static OrderCaller PropertiesCache;
	private final static Properties configProp = new Properties();
	private static String Propertyfilename = "order.properties";

	public OrderCaller setPropertyfilename(String Propertyfilename) {
		this.Propertyfilename = Propertyfilename;
		return this;

	}

	/***
	 * configcaller loads the property called in the .properties file
	 */

	public OrderCaller() {
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
		private static final OrderCaller INSTANCE = new OrderCaller();
	}

	public static OrderCaller getInstance() {
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
		System.out.println(PropertiesCache.getInstance().getProperty("baseUri"));
		// All property names
		System.out.println(PropertiesCache.getInstance().getAllPropertyNames());
	}

	/**
	 * adding all callers for environments this is where you call a specific
	 * environment please do not hardcode the in your code add a propertycaller
	 * for it under this segment.
	 */

	public String diet_order_payload() {
		return PropertiesCache.getInstance().getProperty("diet_order_payload");
	}
	public String transform_order_payload() {
		return PropertiesCache.getInstance().getProperty("transform_order_payload");
	}
	
	public String confirm_order_payload() {
		return PropertiesCache.getInstance().getProperty("confirm_order_payload");
	}
	
	public String click_cwow_order() {
		return PropertiesCache.getInstance().getProperty("click_cwow_order");
	}
	
	public String order_name() {
		return PropertiesCache.getInstance().getProperty("order_name");
	}
	public String facility_name() {
		return PropertiesCache.getInstance().getProperty("facility_name");
	}
	public String order_status() {
		return PropertiesCache.getInstance().getProperty("order_status");
	}
	public String order_entered_date() {
		return PropertiesCache.getInstance().getProperty("order_entered_date");
	}
	public String order() {
		return PropertiesCache.getInstance().getProperty("order");
	}
	public String order_justification() {
		return PropertiesCache.getInstance().getProperty("order_justification");
	}
	public String sign_single_Order_modal_path() {
		return PropertiesCache.getInstance().getProperty("sign_single_Order_modal");
	}
	public String sign_single_order_from_modal() {
		return PropertiesCache.getInstance().getProperty("sign_single_order_from_modal");
	}
	public String sign_all_orders_css() {
		return PropertiesCache.getInstance().getProperty("order_sign_all_css");
	}
	public String sign_all_orders_xpath() {
		return PropertiesCache.getInstance().getProperty("order_sign_all_xpath");
	}
	public String patient_name_order_detail() {
		return PropertiesCache.getInstance().getProperty("patient_name_order_detail");
		
	}
	public String sign_btn_from_order_detail() {
		return PropertiesCache.getInstance().getProperty("sign_btn_from_order_detail");
		
	}
	public String get_cwow_order_grid() {
		return PropertiesCache.getInstance().getProperty("order_summary_table_grid");
		
	}
	public String get_cwow_order_grid_rows() {
		return PropertiesCache.getInstance().getProperty("order_summary_data_row");
		
	}
	public String get_cwow_order_grid_row_cells() {
		return PropertiesCache.getInstance().getProperty("order_summary_table_grid_row_cell");
		
	}
	public String get_cwow_order_details_patient_name() {
		return PropertiesCache.getInstance().getProperty("order_detail_demo_header__title");
		
	}
	public String get_cwow_order_details_patient_info() {
		return PropertiesCache.getInstance().getProperty("order_detail_demo_patient_info");
		
	} 
	public String get_order_details_content() {
		return PropertiesCache.getInstance().getProperty("order_detail_content");
		
	}
	public String get_order_detail_section_separator() {
		return PropertiesCache.getInstance().getProperty("order_detail_section_separator");
		
	}
	public String get_order_detail_section_header() {
		return PropertiesCache.getInstance().getProperty("order_detail_section_header");
		
	}
	public String get_order_detail_section_items() {
		return PropertiesCache.getInstance().getProperty("order_detail_section_items");
		
	}
	public String get_order_detail_section_items_item() {
		return PropertiesCache.getInstance().getProperty("order_detail_section_items_item");
		
	}
	public String get_order_detail_body_values_xpath_separator() {
		return PropertiesCache.getInstance().getProperty("order_detail_body_values_xpath_separator");	
	}
	public String get_order_detail_body_values_css_separator() {
		return PropertiesCache.getInstance().getProperty("order_detail_body_values_css_separator");	
	}
	public String get_order_detail_close() {
		return PropertiesCache.getInstance().getProperty("order_detail_close");
		
	}
	
}
