package stepDefinition;


import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.apache.bcel.classfile.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import com.google.common.io.Files;

import cucumber.deps.com.thoughtworks.xstream.io.path.Path;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.LoginPage;
import pageObject.PhysicalProgressPage;



public class LoginStepDef{
	
	WebDriver wait= null;
	public static WebDriver driver=null;
	LoginPage lp;
	PhysicalProgressPage pp;
	Action act;
	Screenshot ss;
	
	public static String EXECUTION_ENV = System.getProperty("os.name");
	public static String LINUX_ENV = "Linux";

	@Before
	public void beforeScenario() throws IOException{
		
		

		String filepath = "D:\\BDD Projects\\TestEnsureBDD\\ScreenShots";
	    File file = new File(filepath);
	    FileUtils.deleteDirectory(file);
	    file.delete();
	    
		//System.setProperty("driver","D:\\BDD Projects\\TestEnsureBDD\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();

		options.addArguments("start-maximized");
		options.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

		System.out.println("EXECUTION_ENV" + EXECUTION_ENV);
		System.out.println("LINUX_ENV" + LINUX_ENV);

		if (EXECUTION_ENV.equals(LINUX_ENV)) {
			options.setBinary("/usr/bin/google-chrome");
			options.addArguments("--no-sandbox"); // Bypass OS security model
			options.addArguments("--headless");
			options.addArguments("--disable-extensions");
			options.addArguments("--start-maximized");
			options.addArguments("--ignore-certificate-errors");
		} else if (EXECUTION_ENV.equals(LINUX_ENV)) {
			options.addArguments("--disable-notifications");
			options.addArguments("--remote-allow-origins=*");
			System.setProperty("java.awt.headless", "false");
			options.addArguments("--disable-features=VizDisplayCompositor");
		}
		driver = WebDriverManager.chromedriver().capabilities(options).create();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		lp= new LoginPage(driver);
		pp= new PhysicalProgressPage(driver);
		System.out.println("This will be run before the scenario");
		
	}
	
	@BeforeStep
	public void takeScreenshotBeforeStep(Scenario sc) {
		
		System.out.println("This will run the BeforeStep");
		
		if(driver != null) {
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		sc.attach(screenshot, "image/png", "Screenshots attached");
		}
	}

	@AfterStep
	public void takeScreenshotAfterStep(Scenario sc) {
		
		System.out.println("This will run the AfterStep");
		
		if(driver != null) {
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		sc.attach(screenshot, "image/png", "Screenshots attached");
		}
	}
	@After
	public void before_or_after(io.cucumber.java.Scenario sc) {
		
		System.out.println("This will run the after the scenario");
		TakesScreenshot tss = (TakesScreenshot) driver;
		byte[] screenshots = tss.getScreenshotAs(OutputType.BYTES);
		sc.attach(screenshots, "image/png", "Screenshots attached");
		
		if(sc.isFailed()) {
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			sc.attach(screenshot, "image/png", "Taking Screenshots");
		}
			else {
				System.out.println("Test case passed");
			}
			
		}
//		String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
//		String ScreenshotName = "screenshot_"+ timestamp +".png";
//		String ScreenshotDirectory = "D:\\BDD Projects\\TestEnsureBDD\\target";
//		File dest = new File(("D:\\BDD Projects\\TestEnsureBDD\\target\\")+"screenshot"+ timestamp +".png");
//		
//		
//		}
//		 try { 
//			 Files.createParentDirs(ScreenshotDirectory);
//			 Files.write(Paths.get(ScreenshotDirectory + ScreenshotName), scr); 
//			 sc.attach(scr, "image/png", ScreenshotName);
//		 } 
//		 catch (IOException e) { 
//			 e.printStackTrace(); 
//			 } 
//		if(sc.isFailed()) {			
//			TakesScreenshot ts = (TakesScreenshot) driver;
//			byte[] screenshot= ts.getScreenshotAs(OutputType.BYTES);
//			sc.attach(screenshot, "image/png", "Taking Screenshots");
//		}
//			else {
//				TakesScreenshot ts = (TakesScreenshot) driver;
//				byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
//				sc.attach(screenshot, "image/png", "Screenshots attached");
//			}
//			
//		}
	
	@Given("User navigates to the website")
	public void user_navigates_to_the_website() throws IOException, InterruptedException {
		
		
//		Files.deleteIfExists(Paths.get("D:\\BDD Projects\\TestEnsureBDD\\ScreenShots"));
		
		driver.get("https://mingle-portal.se2.inforcloudsuite.com/UH9WFNGMM5Z5HPYE_DEM/36b871bb-ff48-4f95-9d2f-ae149239b851");
		driver.manage().window().maximize();
		lp.EnterUsername("srilakshmi.supraja@sailotech.com");
		lp.EnterPassword("InforCloud@1");
		lp.getLogin().click();
		Thread.sleep(5000);
		WebElement Iframe = driver.findElement(By.xpath("(//*[@class='m-app-frame'])[1]"));
		driver.switchTo().frame(Iframe);
		Thread.sleep(5000);
		ss.screenshot(driver, System.currentTimeMillis());
//		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//		String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
//		String ScreenshotName = "screenshot_"+ timestamp +".png";
//		String ScreenshotDirectory = "D:\\BDD Projects\\TestEnsureBDD\\target\\";
// //      File dest = new File(("D:\\BDD Projects\\TestEnsureBDD\\target\\")+"screenshot"+ timestamp +".png");
////        FileUtils.copyFile(scr, dest);
//        Thread.sleep(3000);
	}
	@When("User login with Username and Password")
	public void user_login_with_username_and_password() throws InterruptedException{
		
		pp.ClickonProject();
		Thread.sleep(5000);
		pp.ClickonProgress();
		Thread.sleep(5000);
		pp.ClickonGenerate();
		Thread.sleep(5000);
		pp.ClickOnGeneratePhysicalProgress();
		Thread.sleep(5000);
		pp.ClickOnGeneratePhysicalProgressbyExtensionorCost();
		Thread.sleep(5000);
		pp.ClickOnProjectCodeSearchButoon();
		pp.EnterValueinProjectCodeTextBox("PRJ000013");
		pp.EnterProjecDescr("test ensure");
		ss.screenshot(driver, System.currentTimeMillis());
		Thread.sleep(3000);
		pp.ClickOnFirstCheckBox();
		Thread.sleep(3000);
		pp.ClickOnOkButton();
		pp.ClickOnActivityCodeSearchButoon();
		pp.EnterValueinActivityCodeTextBox("cube");
		pp.EnterProjecDescr("cube");
		Thread.sleep(3000);
		pp.ClickOnFirstCheckBox();
		Thread.sleep(3000);
		pp.ClickOnOkButton();
		Thread.sleep(5000);
		ss.screenshot(driver, System.currentTimeMillis());
		pp.ClickOnGenerateButton();
		pp.ClickonPhysicalProgress();
		Thread.sleep(2000);
		pp.ClickonNewViewButton();
		Thread.sleep(2000);
		pp.getProjectSearchButton().click();
		pp.EnterValueinProjectCodeTextBox("PRJ000013");
		pp.EnterProjecDescr("test ensure");
		Thread.sleep(3000);
		pp.ClickOnFirstCheckBox();
		Thread.sleep(3000);
		pp.ClickOnOkButton();
		Thread.sleep(3000);
		pp.getActivitySearchButton().click();
		pp.EnterValueinActivityCodeTextBox("cube");
		pp.EnterProjecDescr("cube");
		Thread.sleep(3000);
		pp.ClickOnFirstCheckBox();
		Thread.sleep(3000);
		pp.ClickOnOkButton();
		Thread.sleep(2000);
		pp.getSaveButton().click();
		Thread.sleep(3000);
		pp.getNewButton().click();
		Thread.sleep(2000);
		pp.getCumulativeTextBox().click();
		Thread.sleep(2000);
		pp.getCumulativeInputTextBox().sendKeys("8");
		Thread.sleep(2000);
		pp.getPhysicalProgressCheckBox().click();
		Thread.sleep(2000);
		pp.getApproveButtton().click();
		Thread.sleep(2000);
		pp.getActionsButton().click();
		Thread.sleep(2000);
		pp.getUnapproveButton().click();
		Thread.sleep(2000);
		pp.getDeleteButtton().click();
		Thread.sleep(2000);
		pp.getPopupYesOrOKButton().click();
		Thread.sleep(2000);
		pp.getPopupYesOrOKButton().click();
		Thread.sleep(2000);
		pp.getReferencesButtton().click();
		pp.getMenuIteamButtton().click();
		Thread.sleep(5000);
		
		

	}
	@Then("Login must be successful")
	public void login_must_be_successful() throws InterruptedException {
		System.out.println("Login Successful");
		pp.getPPAMSessionTabCloseButton().click();
		Thread.sleep(3000);
		pp.getPopupNoButton().click();
		pp.ClickonClose();
	
	    
	}




}
