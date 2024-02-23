package com.sailotech.testautomation.commonutilities;

import com.sailotech.testautomation.accelarators.TestBase;
import com.sailotech.testautomation.beans.JobUpdateRequest;
import com.sailotech.testautomation.util.DateFormatUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class StatusUpdater {

	private static RestTemplate restTemplate = new RestTemplateBuilder().rootUri("https://api.testensure.com").build();

//	public static void saveJobURL(String runID, String url, String videoUrl) {
//		try {
//			if (TestBase.jobID != null) {
//				HttpEntity<JobUpdateRequest> entity = new HttpEntity<>(
//						JobUpdateRequest.builder().reportPortalUrl(url).ltVideoUrl(videoUrl).build());
//
//				ResponseEntity<String> response = restTemplate.exchange(
//						String.format("/api/releases/jobUpdate/%s?bypass=true", runID), HttpMethod.PATCH, entity,
//						String.class, Map.of());
//				log.info(
//						"Successfully updated the report portal url to {} for run id {}, response code {}, response body {}",
//						url, runID, response.getStatusCode(), response.getBody());
//			}
//		} catch (Exception e) {
//			log.error("Failed updating the test case id {}, url {}, error: {}", runID, url, e.getMessage());
//		}
//	}

	public static void updateStatus(String runID, String testCaseStepID, String status, String moduleId,
			String testNodeId, String testCaseId, JobUpdateRequest jobUpdateRequest) {
		try {
//			if (jobID != null) {

			System.out.println("runID " + runID);
			System.out.println("testCaseStepID " + testCaseStepID);
			System.out.println("status " + status);
			System.out.println("moduleId " + moduleId);
			System.out.println("testCaseId " + testCaseId);
			System.out.println("testNodeId " + testNodeId);
			
			LocalDateTime moduleStartTime = LocalDateTime.now();
			LocalDateTime moduleEndTime = LocalDateTime.now();

			Duration moduleDuration = Duration.between(moduleStartTime, moduleEndTime);
			
			DateFormatUtil dateFormatUtil = new DateFormatUtil();
			Long duration = dateFormatUtil.getDurationEpoch(moduleDuration);

			Map<String, Object> requestBody = new HashMap<>();
			// jobUpdateRequest.setScreenshot(null);
			requestBody.put("deleteFile", false);
			requestBody.put("moduleId", moduleId);
			requestBody.put("testCaseId", testCaseId);
			requestBody.put("testNodeId", testNodeId);
			if (jobUpdateRequest != null)
				requestBody.put("images", jobUpdateRequest.getScreenshot());
			if (jobUpdateRequest != null)
				requestBody.put("log", jobUpdateRequest.getLog());

			if (moduleStartTime != null)
				requestBody.put("jobExecutionStart", String.valueOf(moduleStartTime));

			if (moduleStartTime != null && testCaseStepID != null)
				requestBody.put("executionStart", String.valueOf(moduleStartTime));

			if (moduleStartTime != null && testCaseStepID != null)
				requestBody.put("executionEnd", String.valueOf(moduleStartTime));

			if (duration != 0 && testCaseStepID != null)
				requestBody.put("executionDuration", duration);

			if (duration != 0)
				requestBody.put("moduleDuration", duration);

//			if (TestBase.defectType != null)
				requestBody.put("defectType", null);

			if (duration != 0)
				requestBody.put("jobDuration", duration);

			HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody);

			System.out.println("requestEntity " + requestEntity);
			ResponseEntity<String> response = restTemplate.exchange(
					String.format("/api/releases/jobUpdate/%s/%s/%s?bypass=true", runID, testCaseStepID, status),
					HttpMethod.PATCH, requestEntity, String.class, Map.of());
			System.out.println("response :: " + response);
//				log.info("Successfully updated the test case id {}, run id {}, response code {}, response body {}",
//						testCaseStepID, runID, response.getStatusCode(), response.getBody());
//			}
		} catch (Exception e) {
			e.printStackTrace();
//			log.error("Failed updating the test case id {}, run id {}, error: {}", testCaseStepID, runID,
//					e.getMessage());
		}
	}
}
