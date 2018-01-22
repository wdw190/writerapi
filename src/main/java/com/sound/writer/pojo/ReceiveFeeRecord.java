package com.sound.writer.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "费用领取记录")
public class ReceiveFeeRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6133485093821652243L;
	@ApiModelProperty(value = "主键UUID", hidden = true)
	private String uuid;
	@ApiModelProperty(value = "代办ID", required = true)
	private String worksListUuid;
	@ApiModelProperty(value = "领取金额", required = true)
	private float receiveTheAmount;
	@ApiModelProperty(value = "领取时间", required = true)
	private String receiveTime;
	@ApiModelProperty(value = "领取人", required = true)
	private String recipients;

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

	public float getReceiveTheAmount() {
		return receiveTheAmount;
	}

	public void setReceiveTheAmount(float receiveTheAmount) {
		this.receiveTheAmount = receiveTheAmount;
	}

	public String getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}

	public String getRecipients() {
		return recipients;
	}

	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}

	@Override
	public String toString() {
		return "ReceiveFeeRecord [uuid=" + uuid + ", worksListUuid=" + worksListUuid + ", receiveTheAmount="
				+ receiveTheAmount + ", receiveTime=" + receiveTime + ", recipients=" + recipients + "]";
	}

}
