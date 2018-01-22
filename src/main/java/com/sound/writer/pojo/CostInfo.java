package com.sound.writer.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="缴费记录")
public class CostInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3867456557381183050L;

	@ApiModelProperty(value="UUID主键",hidden=true)
	private String uuid;
	@ApiModelProperty(value="代办任务UUID",hidden=true)
	private String worksListUuid;
	@ApiModelProperty(value="金额",required=true)
	private float amount;
	@ApiModelProperty(value="费用发生时间",required=true)
	private String timeOfOccurrence;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getWorksListUuid() {
		return worksListUuid;
	}
	public void setWorksListUuid(String worksListUuid) {
		this.worksListUuid = worksListUuid;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getTimeOfOccurrence() {
		return timeOfOccurrence;
	}
	public void setTimeOfOccurrence(String timeOfOccurrence) {
		this.timeOfOccurrence = timeOfOccurrence;
	}
	@Override
	public String toString() {
		return "CostInfo [uuid=" + uuid + ", worksListUuid=" + worksListUuid + ", amount=" + amount
				+ ", timeOfOccurrence=" + timeOfOccurrence + "]";
	}

	

}
