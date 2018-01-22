package com.sound.writer.pojo.query.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="代办查询条件")
public class AgentQueryConditionsM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8656145346090244542L;

	@ApiModelProperty(value="代办人账号/手机号码" ,required=true)
	private String agentStaff;
	@ApiModelProperty(value="代办状态 0:在办 1:已办" ,required=true)
	private String evaluationStatus;

	public String getAgentStaff() {
		return agentStaff;
	}

	public void setAgentStaff(String agentStaff) {
		this.agentStaff = agentStaff;
	}

	public String getEvaluationStatus() {
		return evaluationStatus;
	}

	public void setEvaluationStatus(String evaluationStatus) {
		this.evaluationStatus = evaluationStatus;
	}

	@Override
	public String toString() {
		return "AgentQueryConditionsM [agentStaff=" + agentStaff + ", evaluationStatus=" + evaluationStatus + "]";
	}

}
