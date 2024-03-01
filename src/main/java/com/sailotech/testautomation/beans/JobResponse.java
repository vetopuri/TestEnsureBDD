package com.sailotech.testautomation.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JobResponse {
    private String _id;
    private String jenkinsJobID;
    private String jenkinsPath;
    private String releaseID;
    private String createdBy;
    private List<ModuleResponse> modules;
    private String __v;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getJenkinsJobID() {
		return jenkinsJobID;
	}
	public void setJenkinsJobID(String jenkinsJobID) {
		this.jenkinsJobID = jenkinsJobID;
	}
	public String getJenkinsPath() {
		return jenkinsPath;
	}
	public void setJenkinsPath(String jenkinsPath) {
		this.jenkinsPath = jenkinsPath;
	}
	public String getReleaseID() {
		return releaseID;
	}
	public void setReleaseID(String releaseID) {
		this.releaseID = releaseID;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public List<ModuleResponse> getModules() {
		return modules;
	}
	public void setModules(List<ModuleResponse> modules) {
		this.modules = modules;
	}
	public String get__v() {
		return __v;
	}
	public void set__v(String __v) {
		this.__v = __v;
	}
	@Override
	public String toString() {
		return "JobResponse [_id=" + _id + ", jenkinsJobID=" + jenkinsJobID + ", jenkinsPath=" + jenkinsPath
				+ ", releaseID=" + releaseID + ", createdBy=" + createdBy + ", modules=" + modules + ", __v=" + __v
				+ "]";
	}
    
}
