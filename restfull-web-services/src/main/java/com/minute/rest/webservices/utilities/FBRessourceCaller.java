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
public class FBRessourceCaller {
	   private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private static FBRessourceCaller PropertiesCache;
	private final static Properties configProp = new Properties();
	private static String Propertyfilename ="Config.properties";
	
	public FBRessourceCaller setPropertyfilename(String Propertyfilename ){
		this.Propertyfilename=Propertyfilename;
		return this;
		
	}

	public FBRessourceCaller() {
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
		private static final FBRessourceCaller INSTANCE = new FBRessourceCaller();
	}

	public static FBRessourceCaller getInstance() {
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
	  System.out.println(PropertiesCache.getInstance().getProperty("facebook"));
	  //All property names
	  System.out.println(PropertiesCache.getInstance().getAllPropertyNames());
	}
	

	public String getfacebook(){
		return PropertiesCache.getInstance().getProperty("facebook");
	}
	public String getallproperties(){
		return PropertiesCache.getInstance().getAllPropertyNames().toString();
	}
	public String getfacebookUrl(){
		return PropertiesCache.getInstance().getProperty("facebookUrl");
	}
	// Browser Related 
	public String getFBBrowserLaunchMessage(){
		return PropertiesCache.getInstance().getProperty("facebookUrl");
	}
}
	