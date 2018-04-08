/**
	 * grace tshihata
	 */
package com.minute.rest.webservices.utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertyWriter extends UtilitiesBeans {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * */

	public static void writePropertyStr(String key1, String value1, String file) {

		Properties prop = new Properties();
		OutputStream output = null;

		try {

			if (file.isEmpty() || file == null) {
                  
				output = new FileOutputStream("defaultSave.properties");

				// set the properties value
				if (key1.isEmpty() || key1 == null) {
					String catchmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
					systemAlert(SystemUtility.hourString());
					systemStop("the value of key can't be empty " + catchmethod);
				}else{
					LOGGER.info("adding key: "+key1+ " and Value: "+value1);
				prop.setProperty(key1, value1);

				// save properties to project root folder
				prop.store(output, null);
				LOGGER.info("successfully saved key: "+key1+ " and Value: "+value1);
				}
			} else if (!file.isEmpty()) {
				output = new FileOutputStream(file);

				// set the properties value
				prop.setProperty(key1, value1);

				// save properties to project root folder
				prop.store(output, null);
			}
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static void writePropertyInt(String key1, int value1) {

		Properties prop = new Properties();
		OutputStream output = null;

		String StringValue = Integer.toString(value1);

		try {

			output = new FileOutputStream("config.properties");

			// set the properties value
			prop.setProperty(key1, StringValue);

			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static void writePropertyBool(String key1, boolean value1) {

		Properties prop = new Properties();
		OutputStream output = null;

		String StringValue = Boolean.toString(value1);

		try {

			output = new FileOutputStream("config.properties");

			// set the properties value
			prop.setProperty(key1, StringValue);

			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static void writePropertyLong(String key1, long value1) {

		Properties prop = new Properties();
		OutputStream output = null;

		String StringValue = Long.toString(value1);

		try {

			output = new FileOutputStream("config.properties");

			// set the properties value
			prop.setProperty(key1, StringValue);

			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
}