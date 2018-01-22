package com.sound.writer.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "钱包")
public class Wallet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5913204502428441161L;

	@ApiModelProperty(value = "主键UUID")
	private String uuid;
	@ApiModelProperty(value = "手机号码/账号")
	private String phoneNumber;
	@ApiModelProperty(value = "金额")
	private float amount;

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

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Wallet [uuid=" + uuid + ", phoneNumber=" + phoneNumber + ", amount=" + amount + "]";
	}

}
