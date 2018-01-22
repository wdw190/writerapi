package com.sound.writer.pojo.query.model;

import java.io.Serializable;

import com.sound.writer.pojo.MyWorksM;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "单个作品详情")
public class MySingleWorksResultM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5533498001425091304L;

	@ApiModelProperty(value = "作品详情")
	private MyWorksM myWorksM;
	@ApiModelProperty(value = "标志位 success:成功 failed:失败")
	private String flag;
	@ApiModelProperty(value = "提示信息")
	private String msg;

	public MyWorksM getMyWorksM() {
		return myWorksM;
	}

	public void setMyWorksM(MyWorksM myWorksM) {
		this.myWorksM = myWorksM;
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
		return "MySingleWorksResultM [myWorksM=" + myWorksM + ", flag=" + flag + ", msg=" + msg + "]";
	}

}
