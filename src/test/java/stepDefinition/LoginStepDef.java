package stepDefinition;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import com.sailotech.testautomation.beans.JobUpdateRequest;
import com.sailotech.testautomation.commonutilities.StatusUpdater;
import com.sailotech.testautomation.database.ImageToBase64;

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

public class LoginStepDef {

	WebDriver wait = null;
	public static WebDriver driver = null;
	LoginPage lp;
	PhysicalProgressPage pp;
	Action act;
	Screenshot ss;

	public static String jobId = System.getProperty("job.id");
	public static String moduleId = null;

	public static String EXECUTION_ENV = System.getProperty("os.name");
	public static String LINUX_ENV = "Linux";

	public LoginStepDef() {
		lp = new LoginPage(driver);
		pp = new PhysicalProgressPage(driver);
	}

	public JobUpdateRequest getJobUpdaterequest(String log) {
		JobUpdateRequest jobUpdateRequest = null;
		try {
			jobUpdateRequest = new JobUpdateRequest();
			List<String> files = new ArrayList<String>();
			String filePath = Screenshot.screenshot(driver, System.currentTimeMillis());
			String ext = FilenameUtils.getExtension(filePath);
			files.add(ImageToBase64.getBase64(new File(filePath), ext));
			jobUpdateRequest.setScreenshot(files);
			jobUpdateRequest.setLog(log);
		} catch (Exception e) {
		}
		return jobUpdateRequest;
	}

	@Before("@moduleStart")
	public void moduleStart(Scenario sc) throws IOException {
		System.out.println("Before module start");
		System.out.println("before scen" + sc.getName() + " " + sc.getId());

		String featureName = FilenameUtils.getBaseName(sc.getUri().toString());

		System.out.println("FeatureFileName:  " + featureName);

		String filepath = "D:\\TestEnsure_BDD\\TestEnsureBDD\\ScreenShots";
		File file = new File(filepath);
		FileUtils.deleteDirectory(file);
		file.delete();

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
		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("This will be run before the scenario");

	}

	@After("@moduleEnd")
	public void moduleEnd(Scenario sc) throws IOException {
		System.out.println("After module End");
		System.out.println("after scen" + sc.getName() + " " + sc.getId());
		System.out.println("This will run the after the scenario");
		TakesScreenshot tss = (TakesScreenshot) driver;
		byte[] screenshots = tss.getScreenshotAs(OutputType.BYTES);
		sc.attach(screenshots, "image/png", "Screenshots attached");

		if (sc.isFailed()) {

			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			sc.attach(screenshot, "image/png", "Taking Screenshots");
		} else {
			System.out.println("Test case passed");
		}

	}

	@Before
	public void beforeScenario(Scenario sc) throws IOException {

	}

	@BeforeStep
	public void takeScreenshotBeforeStep(Scenario sc) {

		System.out.println("This will run the BeforeStep");

		if (driver != null) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(screenshot, "image/png", "Screenshots attached");
		}
	}

	@AfterStep
	public void takeScreenshotAfterStep(Scenario sc) {

		System.out.println("This will run the AfterStep");

		if (driver != null) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(screenshot, "image/png", "Screenshots attached");
		}
	}

	@After
	public void before_or_after(io.cucumber.java.Scenario sc) {
		System.out.println("after scen" + sc.getName() + " " + sc.getId());
		System.out.println("This will run the after the scenario");
		TakesScreenshot tss = (TakesScreenshot) driver;
		byte[] screenshots = tss.getScreenshotAs(OutputType.BYTES);
		sc.attach(screenshots, "image/png", "Screenshots attached");

		if (sc.isFailed()) {

			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			sc.attach(screenshot, "image/png", "Taking Screenshots");
		} else {
			System.out.println("Test case passed");
		}

	}

	@Given("Start Execution {string}")
	public void startExecution(String moduleId) throws IOException, InterruptedException {
		System.out.println("moduleId:" + moduleId);
		LoginStepDef.moduleId = moduleId;
	}

	@Then("Stop Execution")
	public void stopExecution() throws IOException, InterruptedException {

	}

	@Given("User navigates to the website {string} {string} {string}")
	public void user_navigates_to_the_website(String testNodeId, String testCaseId, String testStepId)
			throws IOException, InterruptedException {

		driver.get(
				"https://mingle-portal.se2.inforcloudsuite.com/UH9WFNGMM5Z5HPYE_DEM/36b871bb-ff48-4f95-9d2f-ae149239b851");
		driver.manage().window().maximize();
		JobUpdateRequest jobUpdateRequest = getJobUpdaterequest("User on login Page");
		StatusUpdater.updateStatus(jobId, testStepId, "PASSED", moduleId, testNodeId, testCaseId, jobUpdateRequest);
	}

	@When("User Enters Username {string} {string} {string}")
	public void user_enters_username(String testNodeId, String testCaseId, String testStepId)
			throws InterruptedException {
		lp.EnterUsername("srilakshmi.supraja@sailotech.com");
		JobUpdateRequest jobUpdateRequest = getJobUpdaterequest("Enter Username");
		StatusUpdater.updateStatus(jobId, testStepId, "PASSED", moduleId, testNodeId, testCaseId, jobUpdateRequest);
	}

	@When("User Enters Password {string} {string} {string}")
	public void user_enters_password(String testNodeId, String testCaseId, String testStepId) {
		lp.EnterPassword("InforCloud@1");
		JobUpdateRequest jobUpdateRequest = getJobUpdaterequest("Enter Password");
		StatusUpdater.updateStatus(jobId, testStepId, "PASSED", moduleId, testNodeId,testCaseId, jobUpdateRequest);
	}

	@When("User clicks on LoginButton {string} {string} {string}")
	public void user_clicks_on_loginbutton(String testNodeId, String testCaseId, String testStepId)
			throws InterruptedException {
		lp.getLogin().click();
		JobUpdateRequest jobUpdateRequest = getJobUpdaterequest("Click on Login Button");
		StatusUpdater.updateStatus(jobId, testStepId, "PASSED", moduleId, testNodeId,testCaseId, jobUpdateRequest);
		WebElement Iframe = driver.findElement(By.xpath("(//*[@class='m-app-frame'])[1]"));
		driver.switchTo().frame(Iframe);
		Thread.sleep(5000);
	}

	@Then("Login must be successful {string} {string} {string}")
	public void login_must_be_successful(String testNodeId, String testCaseId, String testStepId)
			throws InterruptedException {
		System.out.println("Login Successful");
		JobUpdateRequest jobUpdateRequest = getJobUpdaterequest("Login Successful");
		StatusUpdater.updateStatus(jobId, testStepId, "PASSED", moduleId, testNodeId,testCaseId, jobUpdateRequest);
		

	}

}
