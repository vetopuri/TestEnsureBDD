package com.sailotech.testautomation.beans;

import java.util.List;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobUpdateRequest {
	private String reportPortalUrl;
	private String ltVideoUrl;
	private List<String> screenshot;
	private String log;

	public String getReportPortalUrl() {
		return reportPortalUrl;
	}

	public void setReportPortalUrl(String reportPortalUrl) {
		this.reportPortalUrl = reportPortalUrl;
	}

	public String getLtVideoUrl() {
		return ltVideoUrl;
	}

	public void setLtVideoUrl(String ltVideoUrl) {
		this.ltVideoUrl = ltVideoUrl;
	}

	public List<String> getScreenshot() {
		return screenshot;
	}

	public void setScreenshot(List<String> screenshot) {
		this.screenshot = screenshot;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	@Override
	public String toString() {
		return "JobUpdateRequest [reportPortalUrl=" + reportPortalUrl + ", ltVideoUrl=" + ltVideoUrl + ", screenshot="
				+ screenshot + ", log=" + log + "]";
	}

}
