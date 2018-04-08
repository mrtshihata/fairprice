/**
	 * grace tshihata
	 */
package com.minute.rest.webservices.utilities;

import java.io.PrintStream;
import java.util.logging.Logger;

public class UtilitiesBeans {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Grace T: this is to exit / stop the execution of the system, should be
	 * used wisely as it stop the all process, Should throw the proper reason
	 * Should be used as the end process of a scenario, Mostly for quitting /
	 * killing a process
	 */
	public static void systemStop(String exitReason) {
		LOGGER.info("exiting system with reason: " + exitReason);
		System.exit(0);
	}

	/**
	 * Grace T: use system alert instead of printing independently any line this
	 * is to warn the automation engineer of a system deviation or exception
	 * handled
	 */
	public static void systemAlert(PrintStream printStream) {
		LOGGER.warning("Alert system happening at: " + printStream);
		System.err.println("Alert system happening at: " + printStream);
	}
	
	/**
	 * Grace T: use system alert instead of printing independently any line this
	 * is to warn the automation engineer of a system deviation or exception
	 * handled
	 */
	public static void systemAlert (String alertReason) {
		LOGGER.warning("Alert system with reason: " + alertReason);
		System.err.println("Alert system with reason: " + alertReason);
	}

}
