package com.sound.writer.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="评阅返回结果")
public class SaveChangeResultM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7015683672168371938L;
	
	
	@ApiModelProperty(value="标志 success:成功，failed:失败")
	private String flag;
	@ApiModelProperty(value="提示信息")
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
		return "SaveChangeResultM [flag=" + flag + ", msg=" + msg + "]";
	}
	
	
	

}
