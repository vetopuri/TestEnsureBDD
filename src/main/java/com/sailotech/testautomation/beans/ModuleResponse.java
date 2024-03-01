package com.sailotech.testautomation.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ModuleResponse {
    private String _id;
    private String projectID;
    private String suiteName;
    private String suiteDescription;
    private Map<String, String> testPlaceholders;
    private List<TestNodeResponse> testNodes;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getProjectID() {
		return projectID;
	}
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	public String getSuiteName() {
		return suiteName;
	}
	public void setSuiteName(String suiteName) {
		this.suiteName = suiteName;
	}
	public String getSuiteDescription() {
		return suiteDescription;
	}
	public void setSuiteDescription(String suiteDescription) {
		this.suiteDescription = suiteDescription;
	}
	public Map<String, String> getTestPlaceholders() {
		return testPlaceholders;
	}
	public void setTestPlaceholders(Map<String, String> testPlaceholders) {
		this.testPlaceholders = testPlaceholders;
	}
	public List<TestNodeResponse> getTestNodes() {
		return testNodes;
	}
	public void setTestNodes(List<TestNodeResponse> testNodes) {
		this.testNodes = testNodes;
	}
	@Override
	public String toString() {
		return "ModuleResponse [_id=" + _id + ", projectID=" + projectID + ", suiteName=" + suiteName
				+ ", suiteDescription=" + suiteDescription + ", testPlaceholders=" + testPlaceholders + ", testNodes="
				+ testNodes + "]";
	}
    
    
}
