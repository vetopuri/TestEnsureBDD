package stepDefinition;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Screenshot {
	
	public static void screenshot(WebDriver driver, long ms)
	{

	try {
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(source, new File("./ScreenShots/"+ms+"TestEnsure.png"));
	    System.out.println("ScreenShot Taken");
	} 
	catch (Exception e) 
	{
	    System.out.println("Exception while taking ScreenShot "+e.getMessage());
	}


	}
	
//	@Before
//	public void beforeScenario(){
//		
//		System.out.println("This will be run before the scenario");
//		
//	}
//
//	@After
//	public void before_or_after(io.cucumber.java.Scenario sc) {
//		
//		System.out.println("This will run the after the scenario");
//		
////		if(sc.isFailed()) {
////			
////			TakesScreenshot ts = (TakesScreenshot) driver;
////			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
////			sc.attach(screenshot, "image/png", "Taking Screenshots");
////		}
////			else {
////				TakesScreenshot ts = (TakesScreenshot) driver;
////				byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
////				sc.attach(screenshot, "image/png", "Screenshots attached");
////			}
//			
//		}
	}

