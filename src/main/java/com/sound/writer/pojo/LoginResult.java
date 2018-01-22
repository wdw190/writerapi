package com.sound.writer.pojo;

import java.io.Serializable;

import com.sound.writer.pojo.query.model.LoginUserInfoM;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "登录返回信息")
public class LoginResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2513243728484634440L;

	@ApiModelProperty(value = "用户基本信息")
	private LoginUserInfoM loginUserInfoM;
	@ApiModelProperty(value = "登录成功的标志:success-成功，failed-失败")
	private String flag;
	@ApiModelProperty(value = "提示信息")
	private String msg;

	public LoginUserInfoM getLoginUserInfoM() {
		return loginUserInfoM;
	}

	public void setLoginUserInfoM(LoginUserInfoM loginUserInfoM) {
		this.loginUserInfoM = loginUserInfoM;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "LoginResult [loginUserInfoM=" + loginUserInfoM + ", flag=" + flag + ", msg=" + msg + "]";
	}

}
