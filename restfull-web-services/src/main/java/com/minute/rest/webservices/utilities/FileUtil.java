/**
	 * grace tshihata
	 */
package com.minute.rest.webservices.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;


public class FileUtil {

	
	public static void writeToFile(String filePaht, String AddWahtYouWantToWriteAndSpecifyFormat) {
		try {
			if (filePaht == null) {
				FileUtils.writeStringToFile(new File("src/resource/java"), AddWahtYouWantToWriteAndSpecifyFormat);
			} else if (!(filePaht == null)) {
				FileUtils.writeStringToFile(new File(filePaht), AddWahtYouWantToWriteAndSpecifyFormat);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
