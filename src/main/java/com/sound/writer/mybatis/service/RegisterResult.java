package com.sound.writer.mybatis.service;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class RegisterResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2046584815271051447L;
	
	@ApiModelProperty(notes = "标志位：success-成功，failed-失败")
	private String  flag;
	@ApiModelProperty(notes = "描述信息")
	private String msg;

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
		return "RegisterResult [flag=" + flag + ", msg=" + msg + "]";
	}
	
	
	

}
