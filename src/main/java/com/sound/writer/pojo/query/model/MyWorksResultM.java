package com.sound.writer.pojo.query.model;

import java.io.Serializable;

import com.sound.writer.pojo.MyWorksM;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "我的作品")
public class MyWorksResultM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5305418224627424195L;

	@ApiModelProperty(value = "作品详情")
	private java.util.List<MyWorksM> myWorksMList;
	@ApiModelProperty(value = "标志位 success:成功 failed:失败")
	private String flag;
	@ApiModelProperty(value = "提示信息")
	private String msg;

	public java.util.List<MyWorksM> getMyWorksMList() {
		return myWorksMList;
	}

	public void setMyWorksMList(java.util.List<MyWorksM> myWorksMList) {
		this.myWorksMList = myWorksMList;
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
		return "MyWorksResultM [myWorksMList=" + myWorksMList + ", flag=" + flag + ", msg=" + msg + "]";
	}

}
