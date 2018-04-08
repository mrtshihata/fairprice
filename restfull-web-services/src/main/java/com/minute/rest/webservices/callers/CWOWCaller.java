package com.minute.rest.webservices.callers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;

@SuppressWarnings("static-access")
public class CWOWCaller {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private static CWOWCaller PropertiesCache;
	private final static Properties configProp = new Properties();
	private static String Propertyfilename = "cwow.properties";

	public CWOWCaller setPropertyfilename(String Propertyfilename) {
		this.Propertyfilename = Propertyfilename;
		return this;

	}

	/***
	 * configcaller loads the property called in the .properties file
	 */

	public CWOWCaller() {
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
		private static final CWOWCaller INSTANCE = new CWOWCaller();
	}

	public static CWOWCaller getInstance() {
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

	public String get_page_Title() {
		return PropertiesCache.getInstance().getProperty("page_title");
	}

	public String get_username_id() {
		return PropertiesCache.getInstance().getProperty("username_id");
	}

	public String get_password_id() {
		return PropertiesCache.getInstance().getProperty("password_id");
	}

	public String get_patient_path() {
		return PropertiesCache.getInstance().getProperty("patient_path");
	}

	public String get_patient_page_path() {
		return PropertiesCache.getInstance().getProperty("patient_page_path");
	}

	public String select_patient_path() {
		return PropertiesCache.getInstance().getProperty("select_patient_path");
	}

	public String get_clicnic_page_h1_txt() {
		return PropertiesCache.getInstance().getProperty("clicnic_page_h1_txt");
	}

	public String get_clicnic_page_h1_id() {
		return PropertiesCache.getInstance().getProperty("clicnic_page_h1_id");
	}

	public String get_login_button_id() {
		return PropertiesCache.getInstance().getProperty("login_button_id");
	}

	public String get_clinic_name() {
		return PropertiesCache.getInstance().getProperty("clinic_name");
	}

	public String get_clinic_id_xpath() {
		return PropertiesCache.getInstance().getProperty("clinic_id_xpath");
	}

	public String countinue_btn_xpath() {
		return PropertiesCache.getInstance().getProperty("countinue_btn_xpath");
	}

	public String get_patient_details() {
		return PropertiesCache.getInstance().getProperty("patient_details");
	}

	public String get_patient_id_xpath() {
		return PropertiesCache.getInstance().getProperty("patient_id_xpath");
	}

	public String navigate_to_order() {
		return PropertiesCache.getInstance().getProperty("navigate_to_order");
	}

	public String add_order_xpath() {
		return PropertiesCache.getInstance().getProperty("add_order_xpath");
	}

	public String select_diet_order() {
		return PropertiesCache.getInstance().getProperty("select_diet_order");
	}

	public String select_standard_body_weight_xpath() {
		return PropertiesCache.getInstance().getProperty("select_standard_body_weight_xpath");
	}

	public String diet_order_iframe_xpath() {
		return PropertiesCache.getInstance().getProperty("diet_order_iframe_xpath");
	}

	public String standard_body_weight_nameval() {
		return PropertiesCache.getInstance().getProperty("standard_body_weight_nameval");
	}

	public String diet_radioBox_name() {
		return PropertiesCache.getInstance().getProperty("diet_radioBox_name");
	}

	public String standard_body_weight_value_id() {
		return PropertiesCache.getInstance().getProperty("standard_body_weight_value_id");
	}

	public String diet_calories_path() {
		return PropertiesCache.getInstance().getProperty("diet_calories_path");
	}

	public String diet_Protein_path() {
		return PropertiesCache.getInstance().getProperty("diet_Protein_path");
	}

	public String diet_fluid_id() {
		return PropertiesCache.getInstance().getProperty("diet_fluid_id");
	}

	public String diet_sodium_id() {
		return PropertiesCache.getInstance().getProperty("diet_sodium_id");
	}

	public String diet_phosphorus_id() {
		return PropertiesCache.getInstance().getProperty("diet_phosphorus_id");
	}

	public String diet_Potassium_id() {
		return PropertiesCache.getInstance().getProperty("diet_Potassium_id");
	}

	public String diet_modification_path() {
		return PropertiesCache.getInstance().getProperty("diet_modification_path");
	}

	public String diet_popup_Calories_Decreased_for_Weight_Loss_path() {
		return PropertiesCache.getInstance().getProperty("diet_popup_Calories_Decreased_for_Weight_Loss_path");
	}

	/// new
	public String diet_popup_Carb_Controlled_path() {
		return PropertiesCache.getInstance().getProperty("diet_popup_Carb_Controlled_path");
	}

	public String diet_popup_fat_Controlled_path() {
		return PropertiesCache.getInstance().getProperty("diet_popup_fat_Controlled_path");
	}

	public String diet_popup_Calcium_Controlled_path() {
		return PropertiesCache.getInstance().getProperty("diet_popup_Calcium_Controlled_path");
	}

	public String diet_popup_Tube_Feeding_path() {
		return PropertiesCache.getInstance().getProperty("diet_popup_Tube_Feeding_path");
	}

	public String diet_popup_Gluten_Free_path() {
		return PropertiesCache.getInstance().getProperty("diet_popup_Gluten_Free_path");
	}

	public String diet_popup_Lactose_Free_path() {
		return PropertiesCache.getInstance().getProperty("diet_popup_Lactose_Free_path");
	}

	/// New
	public String diet_popup_Low_Purine_path() {
		return PropertiesCache.getInstance().getProperty("diet_popup_Low_Purine_path");
	}

	public String diet_popup_NPO_path() {
		return PropertiesCache.getInstance().getProperty("diet_popup_Tube_Feeding_path");
	}

	public String diet_popup_Mechanical_Soft_path() {
		return PropertiesCache.getInstance().getProperty("diet_popup_Mechanical_Soft_path");
	}

	public String diet_popup_Pureed_path() {
		return PropertiesCache.getInstance().getProperty("diet_popup_Pureed_path");
	}

	public String diet_popup_Thickened_Liquid_path() {
		return PropertiesCache.getInstance().getProperty("diet_popup_Thickened_Liquid_path");
	}

	public String diet_popup_add_modification_id() {
		return PropertiesCache.getInstance().getProperty("diet_popup_add_modification_id");
	}

	public String diet_popup_add_button() {
		return PropertiesCache.getInstance().getProperty("diet_popup_add_button");
	}

	public String diet_Additional_Comments_optional() {
		return PropertiesCache.getInstance().getProperty("diet_Additional_Comments_optional");
	}

	public String diet_Order_Source_id() {
		return PropertiesCache.getInstance().getProperty("diet_Order_Source_id");
	}

	public String diet_Order_Provider() {
		return PropertiesCache.getInstance().getProperty("diet_Order_Provider");
	}

	public String diet_order_end_date_id() {
		return PropertiesCache.getInstance().getProperty("diet_order_end_date_id");
	}

	public String diet_order_submit_btn_id() {
		return PropertiesCache.getInstance().getProperty("diet_order_submit_btn_id");
	}

	public String diet_order_provider_focus_path() {
		return PropertiesCache.getInstance().getProperty("diet_order_provider_focus_path");
	}
	public String diet_iframe_id() {
		return PropertiesCache.getInstance().getProperty("diet_iframe_id");
	}
	
	public String diet_active_Order_exist_btn_path() {
		return PropertiesCache.getInstance().getProperty("diet_active_Order_exist_btn_path");
	}
	
	public String data_cleanup_Iframe_ID() {
		return PropertiesCache.getInstance().getProperty("data_cleanup_Iframe_ID");
	}
	public String presence_of_diet_order_class() {
		return PropertiesCache.getInstance().getProperty("presence_of_diet_order_class");
	}
	public String presence_of_threatment_order_class() {
		return PropertiesCache.getInstance().getProperty("presence_of_threatment_order_class");
	}
	
	
	
	
	
	

}
