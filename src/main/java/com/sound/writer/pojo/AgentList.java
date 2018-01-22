package com.sound.writer.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="代办")
public class AgentList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2857882970221506105L;
	
	@ApiModelProperty(value="UUID主键",hidden=true)
	private String uuid;
	@ApiModelProperty(value="任务(作品)名称/",required=true)
	private String taskTitle;
	//@ApiModelProperty(value="")
	//private String  worksUuid;
	@ApiModelProperty(value="提交人",required=true)
	private String sumitter;
	@ApiModelProperty(value="代办人",required=true)
	private String agentStaff;
	@ApiModelProperty(value="提交时间",required=true)
	private String submitTime;
	@ApiModelProperty(value="评阅方式 offline:离线  online:在线",required=true)
	private String reviewTheWay;
	
	@ApiModelProperty(value="评价状态 0:待评价 1:评价完成",required=true)
	private String evaluationStatus;
	@ApiModelProperty(value="缴费状态 0:未缴费 1:已缴费",required=true)
	private String paymentStatus;
	@ApiModelProperty(value="费用领用状态 0:未领取 1:已领取",required=true)
	private String receiveTheFeeStaus;
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
	public String getAgentStaff() {
		return agentStaff;
	}
	public void setAgentStaff(String agentStaff) {
		this.agentStaff = agentStaff;
	}
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public String getReviewTheWay() {
		return reviewTheWay;
	}
	public void setReviewTheWay(String reviewTheWay) {
		this.reviewTheWay = reviewTheWay;
	}
	public String getEvaluationStatus() {
		return evaluationStatus;
	}
	public void setEvaluationStatus(String evaluationStatus) {
		this.evaluationStatus = evaluationStatus;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getReceiveTheFeeStaus() {
		return receiveTheFeeStaus;
	}
	public void setReceiveTheFeeStaus(String receiveTheFeeStaus) {
		this.receiveTheFeeStaus = receiveTheFeeStaus;
	}
	@Override
	public String toString() {
		return "AgentList [uuid=" + uuid + ", taskTitle=" + taskTitle + ", sumitter=" + sumitter + ", agentStaff="
				+ agentStaff + ", submitTime=" + submitTime + ", reviewTheWay=" + reviewTheWay + ", evaluationStatus="
				+ evaluationStatus + ", paymentStatus=" + paymentStatus + ", receiveTheFeeStaus=" + receiveTheFeeStaus
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	

}
