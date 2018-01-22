package com.sound.writer.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "批改结果")
public class ChangeTheResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2706053503219028815L;

	@ApiModelProperty(value = "主键UUID", hidden = true)
	private String uuid;
	@ApiModelProperty(value = "代办UUID")
	private String agentListUuid;
	@ApiModelProperty(value = "作品评分")
	private float worksScore;
	@ApiModelProperty(value = "作品评价")
	private String workEvaluation;
	@ApiModelProperty(value = "处理人")
	private String dealer;
	@ApiModelProperty(value = "处理时间")
	private String dealTime;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getAgentListUuid() {
		return agentListUuid;
	}
	public void setAgentListUuid(String agentListUuid) {
		this.agentListUuid = agentListUuid;
	}
	public float getWorksScore() {
		return worksScore;
	}
	public void setWorksScore(float worksScore) {
		this.worksScore = worksScore;
	}
	public String getWorkEvaluation() {
		return workEvaluation;
	}
	public void setWorkEvaluation(String workEvaluation) {
		this.workEvaluation = workEvaluation;
	}
	public String getDealer() {
		return dealer;
	}
	public void setDealer(String dealer) {
		this.dealer = dealer;
	}
	public String getDealTime() {
		return dealTime;
	}
	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}
	@Override
	public String toString() {
		return "ChangeTheResult [uuid=" + uuid + ", agentListUuid=" + agentListUuid + ", worksScore=" + worksScore
				+ ", workEvaluation=" + workEvaluation + ", dealer=" + dealer + ", dealTime=" + dealTime + "]";
	}

	

}
