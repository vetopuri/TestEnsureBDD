package com.sailotech.testautomation.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonPropertyOrder({ "testCaseID", "_id", "testCaseTitle", "testCaseDescription", "dependsOn", "tags",
		"testCaseSteps" })
public class TestNodeSingularResponse {
	private String _id;
	private String testCaseID;
	private String testCaseTitle;
	private String testCaseDescription;
	private String dependsOn;
	private List<Object> testCaseSteps;
	private List<String> tags;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getTestCaseID() {
		return testCaseID;
	}
	public void setTestCaseID(String testCaseID) {
		this.testCaseID = testCaseID;
	}
	public String getTestCaseTitle() {
		return testCaseTitle;
	}
	public void setTestCaseTitle(String testCaseTitle) {
		this.testCaseTitle = testCaseTitle;
	}
	public String getTestCaseDescription() {
		return testCaseDescription;
	}
	public void setTestCaseDescription(String testCaseDescription) {
		this.testCaseDescription = testCaseDescription;
	}
	public String getDependsOn() {
		return dependsOn;
	}
	public void setDependsOn(String dependsOn) {
		this.dependsOn = dependsOn;
	}
	public List<Object> getTestCaseSteps() {
		return testCaseSteps;
	}
	public void setTestCaseSteps(List<Object> testCaseSteps) {
		this.testCaseSteps = testCaseSteps;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	@Override
	public String toString() {
		return "TestNodeSingularResponse [_id=" + _id + ", testCaseID=" + testCaseID + ", testCaseTitle="
				+ testCaseTitle + ", testCaseDescription=" + testCaseDescription + ", dependsOn=" + dependsOn
				+ ", testCaseSteps=" + testCaseSteps + ", tags=" + tags + "]";
	}
	
	
}
