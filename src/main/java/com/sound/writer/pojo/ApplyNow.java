package com.sound.writer.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "")
public class ApplyNow implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3688929355177552499L;

	@ApiModelProperty(value = "UUID主键")
	private String uuid;
	@ApiModelProperty(value = "提现金额")
	private String amount;
	@ApiModelProperty(value = "提现发起时间")
	private String applyStartTime;
	@ApiModelProperty(value = "提现申请人")
	private String applySponsor;
	@ApiModelProperty(value = "提现申请处理人")
	private String applyDealer;
	@ApiModelProperty(value = "提现申请处理状态")
	private String applyDealStatus;
	@ApiModelProperty(value = "提现申请处理完成时间")
	private String applyDealTime;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getApplyStartTime() {
		return applyStartTime;
	}

	public void setApplyStartTime(String applyStartTime) {
		this.applyStartTime = applyStartTime;
	}

	public String getApplySponsor() {
		return applySponsor;
	}

	public void setApplySponsor(String applySponsor) {
		this.applySponsor = applySponsor;
	}

	public String getApplyDealer() {
		return applyDealer;
	}

	public void setApplyDealer(String applyDealer) {
		this.applyDealer = applyDealer;
	}

	public String getApplyDealStatus() {
		return applyDealStatus;
	}

	public void setApplyDealStatus(String applyDealStatus) {
		this.applyDealStatus = applyDealStatus;
	}

	public String getApplyDealTime() {
		return applyDealTime;
	}

	public void setApplyDealTime(String applyDealTime) {
		this.applyDealTime = applyDealTime;
	}

	@Override
	public String toString() {
		return "ApplyNow [uuid=" + uuid + ", amount=" + amount + ", applyStartTime=" + applyStartTime
				+ ", applySponsor=" + applySponsor + ", applyDealer=" + applyDealer + ", applyDealStatus="
				+ applyDealStatus + ", applyDealTime=" + applyDealTime + "]";
	}

}
