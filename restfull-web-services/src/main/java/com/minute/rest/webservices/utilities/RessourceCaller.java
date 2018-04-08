/**
	 * grace tshihata
	 */
package com.minute.rest.webservices.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;
@SuppressWarnings("static-access")
public class RessourceCaller extends FBRessourceCaller{
	   private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private static RessourceCaller PropertiesCache;
	private final static Properties configProp = new Properties();
	private static String Propertyfilename ="Config.properties";
	
	public RessourceCaller setPropertyfilename(String Propertyfilename ){
		this.Propertyfilename=Propertyfilename;
		return this;
		
	}

	public RessourceCaller() {
		// Private constructor to restrict new instances
		InputStream in = this.getClass().getClassLoader().getResourceAsStream(Propertyfilename);
		LOGGER.info("Reading properties from file: "+Propertyfilename);
		try {
			configProp.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Bill Pugh Solution for singleton pattern
	public static class ResourceLoader {
		private static final RessourceCaller INSTANCE = new RessourceCaller();
	}

	public static RessourceCaller getInstance() {
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
	
	public void setProperty(String key, String value){
		  configProp.setProperty(key, value);
	}
	
	public static void main(String[] args)
	{
	  //Get individual properties
	  System.out.println(PropertiesCache.getInstance().getProperty("gmail"));
	  //All property names
	 
	  System.out.println(getAllConfigPropData());
	}
	
	public static Set<String> getAllConfigPropData(){
		return PropertiesCache.getInstance().configProp.stringPropertyNames();
	}
	

	public String getgmail(){
		return PropertiesCache.getInstance().getProperty("gmail");
	}
	public String getallproperties(){
		return PropertiesCache.getInstance().getAllPropertyNames().toString();
	}
	public String getgmailUrl(){
		return PropertiesCache.getInstance().getProperty("gmailUrl");
	}
	// Browser Related 
	public String getBrowserLaunchMessage(){
		return PropertiesCache.getInstance().getProperty("gmailUrl");
	}
}
	