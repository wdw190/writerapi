package com.sound.writer.pojo.query.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="费用领取结果")
public class ReceiveFeeRecordResultM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6653011037803976402L;
	@ApiModelProperty(value="标志位 success:成功  failed:失败")
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
		return "ReceiveFeeRecordResultM [flag=" + flag + ", msg=" + msg + "]";
	}
	
	
	
	

}
