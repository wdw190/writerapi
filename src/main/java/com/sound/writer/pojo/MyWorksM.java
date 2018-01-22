package com.sound.writer.pojo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "我的作品")
public class MyWorksM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1460604305346657885L;

	@ApiModelProperty(value = "UUID主键")
	private String uuid;
	@ApiModelProperty(value = "任务(作品)名称/")
	private String taskTitle;
	@ApiModelProperty(value = "提交人")
	private String sumitter;

	@ApiModelProperty(value = "提交时间")
	private String submitTime;
	@ApiModelProperty(value = "评价状态 0:待评价 1:评价完成")
	private String evaluationStatus;

	@ApiModelProperty(value = "作品图片")
	private java.util.List<Works> worksList;

	@ApiModelProperty(value = "评阅教师")
	private Teacher teacher;

	@ApiModelProperty(value = "缴费信息")
	private CostInfo costInfo;
	
	@ApiModelProperty(value = "评阅信息")
	private List<ChangeTheResult> changeTheResult;

	@ApiModelProperty(value = "作品评阅结果图片")
	private java.util.List<ApprovedWorks> approvedWorksList;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getSumitter() {
		return sumitter;
	}

	public void setSumitter(String sumitter) {
		this.sumitter = sumitter;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	public String getEvaluationStatus() {
		return evaluationStatus;
	}

	public void setEvaluationStatus(String evaluationStatus) {
		this.evaluationStatus = evaluationStatus;
	}

	public java.util.List<Works> getWorksList() {
		return worksList;
	}

	public void setWorksList(java.util.List<Works> worksList) {
		this.worksList = worksList;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
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
		return "MyWorksM [uuid=" + uuid + ", taskTitle=" + taskTitle + ", sumitter=" + sumitter + ", submitTime="
				+ submitTime + ", evaluationStatus=" + evaluationStatus + ", worksList=" + worksList + ", teacher="
				+ teacher + ", costInfo=" + costInfo + ", changeTheResult=" + changeTheResult + ", approvedWorksList="
				+ approvedWorksList + ", toString()=" + super.toString() + "]";
	}

	

	

}
