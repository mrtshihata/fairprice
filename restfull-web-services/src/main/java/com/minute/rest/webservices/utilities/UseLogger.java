/**
	 * grace tshihata
	 */
package com.minute.rest.webservices.utilities;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UseLogger {
	// use the classname for the logger, this way you can refactor
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/***
	 * Grace T: this is how to implement logs level
	 */
	/**
	 * Grace T: Defining log level SEVERE (highest) WARNING INFO CONFIG FINE
	 * FINER FINEST all the bellow timing related methods returns times in
	 * different format
	 * 
	 **/

	public void doSomeThingAndLog() {
		// ... more code
		LOGGER.info("hello");

		// now we demo the logging

		// set the LogLevel to Severe, only severe Messages will be written
		LOGGER.setLevel(Level.SEVERE);
		LOGGER.severe("Info Log");
		LOGGER.warning("Info Log");
		LOGGER.info("Info Log");
		LOGGER.finest("Really not important");

		// set the LogLevel to Info, severe, warning and info will be written
		// finest is still not written
		LOGGER.setLevel(Level.INFO);
		LOGGER.severe("Info Log");
		LOGGER.warning("Info Log");
		LOGGER.info("Info Log");
		LOGGER.finest("Really not important");
	}

	/**
	 * this method test the logs logic this will be disable later on*
	 */

	public static void main(String[] args) {
		UseLogger tester = new UseLogger();
		try {
			MyLogger.setup();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Problems with creating the log files");
		}
		tester.doSomeThingAndLog();
	}
}
