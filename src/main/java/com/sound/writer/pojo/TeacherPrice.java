package com.sound.writer.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "教师评阅费用信息")
public class TeacherPrice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2379036753630950517L;

	@ApiModelProperty(value = "主键UUID")
	private String uuid;
	@ApiModelProperty(value = "手机号码/账号")
	private String phoneNumber;
	@ApiModelProperty(value = "生效开始时间")
	private String startTime;
	@ApiModelProperty(value = "生效结束时间")
	private String endTime;
	@ApiModelProperty(value = "评阅费用")
	private float price;
	@ApiModelProperty(value = "是否有效")
	private int enabled;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "TeacherPrice [uuid=" + uuid + ", phoneNumber=" + phoneNumber + ", startTime=" + startTime + ", endTime="
				+ endTime + ", price=" + price + ", enabled=" + enabled + "]";
	}

}
