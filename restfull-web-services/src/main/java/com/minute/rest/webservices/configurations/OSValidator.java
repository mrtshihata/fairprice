package com.minute.rest.webservices.configurations;

import com.minute.rest.webservices.utilities.PropertyCaller;

public class OSValidator {

	private static String OS = System.getProperty("os.name").toLowerCase();

	public static void main(String[] args) {
		
		System.out.println(getOS());

//		if (isWindows()) {
//			System.out.println("This is Windows");
//		} else if (isMac()) {
//			System.out.println("This is Mac");
//		} else if (isUnix()) {
//			System.out.println("This is Unix or Linux");
//		} else if (isSolaris()) {
//			System.out.println("This is Solaris");
//		} else {
//			System.out.println("Your OS is not support!!");
//		}
	}
	String systemOsName;

	public static String getOS() {
		OSConfig();
		return OS;
	}

	public static void setOS(String oS) {
		OS = oS;
	}

	public static void OSConfig() {
	
		PropertyCaller prop = new PropertyCaller();
		if (isWindows()) {
			
			setOS("windows");
		}
		if (isMac()) {
			setOS("mac");
		} 
		if (isUnix()) {
			setOS("linux");
		} 
		if (isSolaris()) {
			setOS("solaris");
		}
	}

	public static void OsDetector() {

	}

	public static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}

	public static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}

	public static boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);

	}

	public static boolean isSolaris() {

		return (OS.indexOf("sunos") >= 0);

	}

}