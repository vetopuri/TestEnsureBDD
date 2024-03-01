package runner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.openqa.selenium.remote.server.handler.html5.GetLocalStorageKeys;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.sailotech.testautomation.beans.JSONKeyFinder;
import com.sailotech.testautomation.beans.JobResponse;
import com.sailotech.testautomation.beans.JsonUtils;
import com.sailotech.testautomation.beans.ModuleResponse;
import com.sailotech.testautomation.beans.ReleaseResponse;
import com.sailotech.testautomation.beans.TestNodeResponse;
import com.sailotech.testautomation.beans.TestNodeSingularResponse;
import com.sailotech.testautomation.commonutilities.FileUtils;
import com.sailotech.testautomation.util.DateFormatUtil;

import rp.org.apache.http.StatusLine;

public class TestBDD {

	private static ObjectMapper objectMapper = new ObjectMapper();
	private static RestTemplate restTemplate = new RestTemplateBuilder().rootUri("http://api.testensure.com").build();
	public static LocalDateTime jobStartTime = null;
	public static LocalDateTime moduleStartTime = null;
	public static Map<String, String> jsonsInputMap = new HashMap<>();
	public static LocalDateTime moduleEndTime = null;
	public static long moduleDurationSec = 0;
	public static DateFormatUtil dateFormatUtil = null;
	

	
	@Test
	public static void test() throws InterruptedException, MalformedURLException, IOException {
		System.out.println("copyfile");	
		String jobID = System.getProperty("job.id");
		JobResponse response = null;
		ReleaseResponse releaseResponse = null;
		ObjectMapper mapper = new ObjectMapper();

		String rpAccessToken = null;
		String rpUsername = null;

		if (jobID != null) {
			
			response = restTemplate.getForEntity(String.format("/api/releases/jobJson/%s?bypass=true", jobID), JobResponse.class).getBody();
			System.out.println(("JOB RESPONSE => " + objectMapper.writeValueAsString(response)));
 
		}
		if (response != null) {
			jobStartTime = LocalDateTime.now();
			List<ModuleResponse> modules = response.getModules();
			System.out.println(("MODULE RESPONSE => " + objectMapper.writeValueAsString(modules)));
			
			
			FileUtils fileUtils = new FileUtils();
			//fileUtils.createFeatureFile();

			fileUtils.appendFeatureFile("Feature: Login Functionality");
			fileUtils.appendFeatureFile("@moduleStart");
			fileUtils.appendFeatureFile("Scenario: It should process a sentence");

			for (ModuleResponse module : modules) {
				String moduleId = module.get_id();
				System.out.println("moduleId " + moduleId);
				fileUtils.appendFeatureFile("Given Start Execution \"" + moduleId + "\"");
				List<TestNodeResponse> testNodes = module.getTestNodes();

				for (TestNodeResponse testNode : testNodes) {
					String testNodeId = testNode.get_id();
					System.out.println("testNodeId " + testNodeId);
					List<TestNodeSingularResponse> testNodeObjs = testNode.getTestNode();
					fileUtils.appendFeatureFile("Scenario: " + testNodeObjs.get(0).getTestCaseID());
					for (TestNodeSingularResponse testNodeObj : testNodeObjs) {
						String testCaseId = testNodeObj.get_id();
						System.out.println("testCaseId " + testCaseId);
						String testCaseTitle = testNodeObj.getTestCaseTitle();
						System.out.println("testCaseTitle " + testCaseTitle);
						List<Object> testCaseSteps = testNodeObj.getTestCaseSteps();
						for (Object testCaseStepObj : testCaseSteps) {
							JsonNode testCaseStep = mapper.convertValue(testCaseStepObj, JsonNode.class);
							JSONKeyFinder keyFinder = new JSONKeyFinder();
							System.out.println("testCaseStepObj "+testCaseStepObj);
							Gson gson = new Gson();
					        String json = gson.toJson(testCaseStepObj); //convert 
					        System.out.println(json);
							JSONObject jsonObject = new JSONObject(json); 
							System.out.println("jsonObject-->"+jsonObject.toString());
							String key = "testStepDescription"; 
							JsonUtils jsonUtils = new JsonUtils();
							List<String> objValues = jsonUtils.getValuesInObject(jsonObject, key);
							String testStepDescription = objValues.get(0);
							String testCaseStepId = testCaseStep.get("_id").toString();
							System.out.println("id " + testCaseStepId);
							fileUtils.appendFeatureFile(testStepDescription + " \"" + testNodeId + "\" \"" + testCaseId
									+ "\" " + testCaseStepId);
						}

					}
				}
			}
			fileUtils.appendFeatureFile("@moduleEnd");
			fileUtils.appendFeatureFile("Scenario: It should process a sentence");
			fileUtils.appendFeatureFile("Then Stop Execution ");
		} else {
			FileUtils fileUtils = new FileUtils();
			fileUtils.copyFeatureFile();
		}
	}

	private static String getJsonValue(JobResponse response, String string) {
		// TODO Auto-generated method stub
		return null;
	}
}