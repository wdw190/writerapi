package com.sound.writer.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="账号基本信息")
public class UserAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8877734209851950346L;
	@ApiModelProperty(notes = "手机号码", required = true)
	private String phoneNumber;
	@ApiModelProperty(notes = "登录密码", required = true)
	private String password;
	@ApiModelProperty(notes = "账号类型：学生-student;教师-teacher", required = true)
	private String accountType;
	@ApiModelProperty(notes = "注册日期：YYYY-MM-DD HH24:MI:SS", required = true)
	private String registeredTime;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getRegisteredTime() {
		return registeredTime;
	}

	public void setRegisteredTime(String registeredTime) {
		this.registeredTime = registeredTime;
	}

	@Override
	public String toString() {
		return "UserAccount [phoneNumber=" + phoneNumber + ", password=" + password + ", accountType=" + accountType
				+ ", registeredTime=" + registeredTime + "]";
	}
	
	

}
