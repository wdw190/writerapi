package com.sound.writer.pojo.query.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "登录需要的信息")
public class LoginM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2757379791156783585L;
	@ApiModelProperty(value = "账号/手机号码", required = true)
	private String phoneNumber;
	@ApiModelProperty(value = "密码", required = true)
	private String password;

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

}
