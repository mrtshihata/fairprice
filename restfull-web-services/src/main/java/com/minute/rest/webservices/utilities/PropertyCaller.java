/**
	 * grace tshihata
	 */
package com.minute.rest.webservices.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Logger;



public class PropertyCaller {
	   private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private static String property_key;
	private static String property_value;
	private static String property_file_name;  

	/**
	 * @return the property_file_name
	 */
	public static String getProperty_file_name() {
		return property_file_name;
	}

	/**
	 * @param property_file_name
	 *            the property_file_name to set
	 */
	public static void setProperty_file_name(String property_file_name) {
		PropertyCaller.property_file_name = property_file_name;
	}

	/**
	 * @param property_key
	 * @param property_value
	 * @param property_file_name
	 */
	@SuppressWarnings("static-access")
	public PropertyCaller(String property_key, String property_value, String property_file_name) {
		super();
		this.property_key = property_key;
		this.property_value = property_value;
		this.property_file_name = property_file_name;
	}

	public PropertyCaller() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("static-access")
	public PropertyCaller setproperty_key(String property_key) {
		this.property_key = property_key;
		return this;
	}

	@SuppressWarnings("static-access")
	public PropertyCaller setproperty_value(String property_value) {
		this.property_value = property_value;
		return this;
	}

	public String getproperty_key() {
		return property_key;
	}

	public String getproperty_value() {
		return property_value;
	}

	public static void myPropertiesBuilder() {
		
		if (property_file_name==null){
			LOGGER.info("Creating Key : "+property_key+"\n"+"Creating Value : "+property_value
					+"\n"+"No property_file_name were set");
		}else if (!property_file_name.isEmpty()){
			LOGGER.info("Creating Key : "+property_key+"\n"+"Creating Value : "+property_value
					+"\n"+"Creating Property file : "+property_file_name);
		}
		SystemUtility su = new SystemUtility();
		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream("Resources" + property_file_name + ".properties");

			// set the properties value
			prop.setProperty(property_key, property_value);

			// save properties to project root folder
			prop.store(output, "This is update file " + su.getCurrentDateTimeWithCalendar());

		} catch (IOException io) {
			LOGGER.severe("Fail to Create Property");
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
					LOGGER.severe("Fail to Create Property");
				}
			}

		}
	}
	
	//Updating propertyFIle

	public static void propertyUpdate() throws FileNotFoundException, IOException {
		SystemUtility su = new SystemUtility();
		Properties pop = new Properties();
		pop.load(new FileInputStream("Ressources/" + property_file_name + ".properties"));
		pop.put(property_key, property_value);
		FileOutputStream output = new FileOutputStream("Resources" + property_file_name + ".properties");
		pop.store(output, "This is update file " + su.getCurrentDateTimeWithCalendar());
	}
	
	

}
