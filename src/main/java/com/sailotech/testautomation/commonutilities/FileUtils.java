package com.sailotech.testautomation.commonutilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import com.google.common.io.Files;

public class FileUtils {

	public FileUtils() {
	}

	public void appendFeatureFile(String line) throws InterruptedException{
		String userDir = System.getProperty("user.dir");

		Path testResources = Path.of(userDir).resolve("features");
		String fromPath = testResources.resolve("login1.feature").toString();
		String featureFile = Path.of(userDir).resolve(System.getProperty("cucumber.features")).toString();
		System.out.println("featureFile" + featureFile);
		try {
//			File createFile = new File(featureFile);
//			createFile.createNewFile();
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(featureFile), true));
			writer.write(line + "\n");
			writer.close();
			
			 File file= new File(featureFile);
			 //file.delete();
			// File fie =new File(featureFile);
			// Files.copy(new File(fromPath), new File(featureFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void copyFeatureFile() {
		String userDir = System.getProperty("user.dir");

		Path testResources = Path.of(userDir).resolve("features");
		String fromPath = testResources.resolve("login1.feature").toString();
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
