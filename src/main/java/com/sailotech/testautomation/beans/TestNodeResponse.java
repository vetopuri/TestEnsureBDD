package com.sailotech.testautomation.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonPropertyOrder({ "testNode", "_id" })
public class TestNodeResponse {
	private String _id;
	private List<TestNodeSingularResponse> testNode;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public List<TestNodeSingularResponse> getTestNode() {
		return testNode;
	}
	public void setTestNode(List<TestNodeSingularResponse> testNode) {
		this.testNode = testNode;
	}
	@Override
	public String toString() {
		return "TestNodeResponse [_id=" + _id + ", testNode=" + testNode + "]";
	}
	
	
}
