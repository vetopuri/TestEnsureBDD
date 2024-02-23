package runner;

import org.testng.annotations.Test;

import com.sailotech.testautomation.commonutilities.FileUtils;

public class TestBDD {
	
	@Test
	public static void test() {
		System.out.println("copyfile");
		FileUtils fileUtils = new FileUtils();
		fileUtils.readFeatureFile();
	}

}
