package com.sailotech.testautomation.commonutilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import com.google.common.io.Files;


public class FileUtils {

	public FileUtils() {
	}

	public void readFeatureFile() {
		String userDir = System.getProperty("user.dir");

		Path testResources = Path.of(userDir).resolve("features");
		String fromPath = testResources.resolve("login.feature").toString();
		String featureFile = Path.of(userDir).resolve(System.getProperty("cucumber.features")).toString();
		System.out.println("featureFile" + featureFile);
		try {
			Files.copy(new File(fromPath), new File(featureFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
