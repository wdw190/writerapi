package com.sound.writer.pojo.query.model;

import java.util.List;

import com.sound.writer.pojo.AgentList;
import com.sound.writer.pojo.ApprovedWorks;
import com.sound.writer.pojo.ChangeTheResult;
import com.sound.writer.pojo.CostInfo;
import com.sound.writer.pojo.Student;
import com.sound.writer.pojo.Works;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "代办")

public class AgentM extends AgentList {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5885972530482876002L;
	
	@ApiModelProperty(value = "学生信息/提交人信息")
	private Student student;

	@ApiModelProperty(value = "代办对应的作品")
	private java.util.List<Works> worksList;

	@ApiModelProperty(value = "代办对应的缴费信息")
	private CostInfo costInfo;

	@ApiModelProperty(value = "评阅信息")
	private List<ChangeTheResult> changeTheResult;

	@ApiModelProperty(value = "作品评阅结果图片")
	private java.util.List<ApprovedWorks> approvedWorksList;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public java.util.List<Works> getWorksList() {
		return worksList;
	}

	public void setWorksList(java.util.List<Works> worksList) {
		this.worksList = worksList;
	}

	public CostInfo getCostInfo() {
		return costInfo;
	}

	public void setCostInfo(CostInfo costInfo) {
		this.costInfo = costInfo;
	}

	public List<ChangeTheResult> getChangeTheResult() {
		return changeTheResult;
	}

	public void setChangeTheResult(List<ChangeTheResult> changeTheResult) {
		this.changeTheResult = changeTheResult;
	}

	public java.util.List<ApprovedWorks> getApprovedWorksList() {
		return approvedWorksList;
	}

	public void setApprovedWorksList(java.util.List<ApprovedWorks> approvedWorksList) {
		this.approvedWorksList = approvedWorksList;
	}

	@Override
	public String toString() {
		return "AgentM [student=" + student + ", worksList=" + worksList + ", costInfo=" + costInfo
				+ ", changeTheResult=" + changeTheResult + ", approvedWorksList=" + approvedWorksList + ", toString()="
				+ super.toString() + "]";
	}

	

	

	

}
