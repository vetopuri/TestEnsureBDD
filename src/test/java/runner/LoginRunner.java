package runner;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import junit.awtui.TestRunner;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

//import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;


//@CucumberOptions(features = "src/test/resources/features/login.feature", glue = { "stepDefinition" , "Hooks"},
//plugin = {
//        "pretty",
//        "html:target/cucumber-reports/cucumber-pretty.html",
//        "json:target/cucumber-reports/CucumberTestReport.json",
//        "rerun:target/cucumber-reports/rerun.txt",
//        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
//}
//)
//public class LoginRunner extends AbstractTestNGCucumberTests{
//
//	String loginFeature = "Features/login.feature";
//}
//@RunWith(Cucumber.class) 
@CucumberOptions( features = {"${cucumber.features}"}, 
					glue = {"stepDefinition"}, 
					plugin = {"pretty", 
							"html:target/cucumber-reports/cucumber-pretty.html",
					        "json:target/cucumber-reports/CucumberTestReport.json",
					        "rerun:target/cucumber-reports/rerun.txt",
					       
} ) 
	public class LoginRunner  extends AbstractTestNGCucumberTests{ 
//		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"	
//		private static  String FEATURE_FILE_NAME = "login.feature"; 
//		
//		public static void main(String[] args) { 
//			
//			System.out.println("cucumber.features" +System.getProperty("cucumber.features"));
//			 
//			FEATURE_FILE_NAME = "src/test/resources/features/" + FEATURE_FILE_NAME;  
////			System.setProperty("featureFilePath", featureFilePath);
//			io.cucumber.core.cli.Main.main(args); 
//			} 
	}

