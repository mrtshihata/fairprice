package com.minute.rest.webservices.base;

public class GenericVariable {

	// Falcon Url section

	// Deprecated
	public static final String BaseUrl = "https://qa.physiciansolutions.davita.com/";
	public static final String DPS_QA_HOST = "https://qa.physiciansolutions.davita.com/";
	public static final String OrderUrl = BaseUrl + "/Orders";
	public static final String RoundingUrl = BaseUrl + "/rounding_ui";
	public static final String dashboardUrl = BaseUrl + "/dashboard_ui";
	// End of Deprecated URLs

	public static final String DEFAULT_HOST = "https://qa.physiciansolutions.davita.com";

	/**
	 * CWOW url section
	 */

	public static final String CWOW_INT_HOST = "https://cwow-int.davita.com/";
	public static final String CWOW_QA_HOST = "https://cwow-qa.davita.com";

	/**
	 * end of CWOW url section
	 */

	// Servers variables CWOW
	public static final String DIET_ORDER_CREATEEVENT_HOST = "http://sea1a2pappu279.davita.corp/";
	public static final String TRANSFORM_ORDER_CREATEEVENT_HOST = "https://cwow-int.davita.com";
	// CWOW Path
	public static final String DIET_ORDER_CREATEEVENT_PATH = "DecisionService/rest/v1/CommandEventsRuleApp/CommandEventRules";
	public static final String TRANSFORM_ORDER_CREATEEVENT_PATH = "/platform-command-controller/api/command/transform-process";
	public static final String CONFIRM_ORDER_CREATEEVENT_PATH = "/cwowmt-order-microservice/orders";
	// CWOW Credential Section

	public static final String CWOW_USERNAME_1 = "AARANZULLO";
	public static final String CWOW_USERNAME_2 = "AARCHESCANDELARIA";
	public static final String CWOW_USERNAME_AUTOMATION_RESTRICTED="ETHUMS";
	public static final String CWOW_PASSWORD_AUTOMATION_RESTRICTED="H6g9F4*!";
	public static final String CWOW_PASSWORD = "H6g9F4*!";

	// en of CWOW Credential Section

	// Falcon Credential Section
	public static final String FACLCON_USER_1 = "jojoseph";
	public static final String FACLCON_USER_2 = "ipaduser1";
	public static final String FACLCON_USER_3 = "hhelderman";
	public static final String FALCON_DEFAULT_PASSWORD = "1";

	// Mailing credentials
	public static final String GMAIL_USERNAME = "angular.automation.team";
	public static final String GMAIL_PASSWORD = "Angular1234";

	// team email
	public static final String GRACE_MAIL = "angular.automation.team";
	public static final String KEITH_MAIL = "Angular1234";
	public static final String KUNAL_MAIL = "angular.automation.team";
	public static final String MAGESH_MAIL = "Angular1234";
	public static final String YOLANDA_MAIL = "angular.automation.team";
	public static final String TAMARA_MAIL = "Angular1234";

	// Generic variable Section
	public static final String CHROME = "chrome";
	public static final String logintitle = "Login - DaVita Village Login Service";
	public static final String LOGOUT_TITLE = "Physician Solutions";
	// Devices Section
	public static final String BlackBerry_Z30 = "BlackBerry Z30";
	public static final String Blackberry_PlayBook = "Blackberry PlayBook";
	public static final String Galaxy_Note_3 = "Galaxy Note 3";
	public static final String Galaxy_Note_II = "Galaxy Note II";
	public static final String Galaxy_S_III = "Galaxy S III";
	public static final String Kindle_Fire_HDX = "Kindle Fire HDX";
	public static final String LG_Optimus_L70 = "LG Optimus L70";
	public static final String Laptop_with_HiDPI_screen = "Laptop with HiDPI screen";
	public static final String Laptop_with_MDPI_screen = "Laptop with MDPI screen";
	public static final String Laptop_with_touch = "Laptop with touch";
	public static final String Microsoft_Lumia_550 = "Microsoft Lumia 550";
	public static final String Microsoft_Lumia_950 = "Microsoft Lumia 950";
	public static final String Nexus_10 = "Nexus 10";
	public static final String Nexus_4 = "Nexus 4";
	public static final String Nexus_5 = "Nexus 5";
	public static final String Nexus_6 = "Nexus 6";
	public static final String Nexus_7 = "Nexus 7";
	public static final String Nokia_Lumia_520 = "Nokia Lumia 520";
	public static final String Nokia_N9 = "Nokia N9";
	public static final String iPad_Mini = "iPad Mini";
	public static final String iPhone_4 = "iPhone 4";
	public static final String Galaxy_S5 = "Galaxy S5";
	public static final String Nexus_5X = "Nexus 5X";
	public static final String Nexus_6P = "Nexus 6P";
	public static final String iPhone_5 = "iPhone 5";
	public static final String iPhone_6 = "iPhone 6";
	public static final String iPhone_6_Plus = "iPhone 6 Plus";
	public static final String iPad = "iPad";

	public static final String[] mobileArray = new String[] { BlackBerry_Z30, Blackberry_PlayBook, Galaxy_Note_3,
			Galaxy_S_III, Kindle_Fire_HDX, LG_Optimus_L70, Laptop_with_HiDPI_screen, Laptop_with_MDPI_screen,
			Laptop_with_touch, Microsoft_Lumia_550, Microsoft_Lumia_950, Nexus_10, Nexus_4, Nexus_5, Nexus_6, Nexus_7,
			Nokia_Lumia_520, Nokia_N9, iPad_Mini, iPhone_4, Galaxy_S5, Nexus_5X, Nexus_6P, iPhone_5, iPhone_6,
			iPhone_6_Plus, iPad };

	/**
	 * Devices Array grouping
	 */

	public static final String[] iPhoneArray = new String[] { iPhone_4, iPhone_5, iPhone_6, iPhone_6_Plus };

	public static final String[] iPadArray = new String[] { iPad_Mini, iPad };

	public static final String[] NexusArray = new String[] { Nexus_10, Nexus_4, Nexus_5, Nexus_6, Nexus_7, Nexus_5X,
			Nexus_6P };

	public static final String[] OXArray = new String[] { iPad_Mini, iPhone_4, iPhone_5, iPhone_6, iPhone_6_Plus,
			iPad };
	public static final String[] AndroidArray = new String[] { Galaxy_Note_3, Galaxy_S_III, LG_Optimus_L70, Nexus_10,
			Nexus_4, Nexus_5, Nexus_6, Nexus_7, Galaxy_S5, Nexus_5X, Nexus_6P };

	public static final String[] WindowsArray = new String[] { Microsoft_Lumia_550, Microsoft_Lumia_950,
			Nokia_Lumia_520, Nokia_N9 };

	public static final String[] LapTopArray = new String[] { Laptop_with_HiDPI_screen, Laptop_with_MDPI_screen,
			Laptop_with_touch };

	/**
	 * Order Summary Headers
	 */
	public final String PATIENT = "Patient";
	public final String FACILITY = "Facility";
	public final String STATUS = "Status";
	public final String ENTERED = "Entered";
	public final String ORDER = "Order";
	public final String JUSTIFICATION = "Justification";

	// Credentials to be used for DaVita One Physician App scripts
	// Added by pnayak - 02/01/18
	// username of Davita user having NPI and security page after login#
	public static final String usernameDvOPNPISecurityPage = "qadoc001";
	public static final String pwdDvOPNPISecurityPage = "j";

	// username of Davita user having NPI and NO security page after login#
	public static final String usernameDvOPNPINoSecurityPage = "jla98762";
	public static final String pwdDvOPNPINoSecurityPage = "j";

	// username of Davita user having No NPI and security page after login#
	public static final String usernameDvOPNoNPISecurityPage = "NeedInfo";
	public static final String pwdDvOPNoNPISecurityPage = "NeedInfo";

	// username of Davita user having No NPI and NO security page after login#
	public static final String usernameDvOPNoNPINoSecurityPage = "jla98762";
	public static final String pwdDvOPNoNPINoSecurityPage = "j";

	// username of Non-Davita users#
	public static final String usernameNonDavita = "NeedInfo";
	public static final String pwdNonDavita = "NeedInfo";

	/***
	 * Diet order details Auth:Grace Tshihata
	 */
	public static final String[] CaloriesArray = new String[] { "25", "30", "35", "40" };
	public static final String[] ProteinArray = new String[] { "1.2", "1.3", "1.4", "1.5" };
	public static final String[] DIET_ORDER_OTHER_MODIFICATION = new String[] { "medicationTest1", "Random Meds",
			"Falcon", "No Cancer" };
	public static final String[] DIET_ORDER_ORDER_SOURCE = new String[] { "Secure Message", "Verbal/Phone", "Written" };
	public static final String DIET_ORDER_PROVIDERS = "Joseph";

}
