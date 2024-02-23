package stepDefinition;

import java.io.File;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Screenshot {

	public static String screenshot(WebDriver driver, long ms) {
		String screenshot = null;

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String userDir = System.getProperty("user.dir");
			screenshot= Path.of(userDir).resolve("ScreenShots").resolve(ms + "TestEnsure.png").toString();
			FileUtils.copyFile(source, new File(screenshot));
			System.out.println("ScreenShot Taken");
		} catch (Exception e) {
			System.out.println("Exception while taking ScreenShot " + e.getMessage());
		}
		return screenshot;

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
