package com.sound.writer.pojo.query.model;

import java.io.Serializable;
import java.util.List;

import com.sound.writer.pojo.ApplyNow;
import com.sound.writer.pojo.ReceiveFeeRecord;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "我的钱包")
public class WalletM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8208637584168382121L;
	

	@ApiModelProperty(value = "主键UUID")
	private String uuid;
	@ApiModelProperty(value = "手机号码/账号")
	private String phoneNumber;
	@ApiModelProperty(value = "金额")
	private float amount;
	@ApiModelProperty(value = "费用领取记录")
	List<ReceiveFeeRecord> receiveFeeRecordList ;
	@ApiModelProperty(value = "提现记录")
	List<ApplyNow> applyNowList;
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
	public List<ReceiveFeeRecord> getReceiveFeeRecordList() {
		return receiveFeeRecordList;
	}
	public void setReceiveFeeRecordList(List<ReceiveFeeRecord> receiveFeeRecordList) {
		this.receiveFeeRecordList = receiveFeeRecordList;
	}
	public List<ApplyNow> getApplyNowList() {
		return applyNowList;
	}
	public void setApplyNowList(List<ApplyNow> applyNowList) {
		this.applyNowList = applyNowList;
	}
	@Override
	public String toString() {
		return "WalletM [uuid=" + uuid + ", phoneNumber=" + phoneNumber + ", amount=" + amount
				+ ", receiveFeeRecordList=" + receiveFeeRecordList + ", applyNowList=" + applyNowList + "]";
	}
	
	
	
	
	
	

}
