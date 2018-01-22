package com.sound.writer.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="作品提交返回结果")
public class SubmitWorksResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3519085978638295765L;

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
		return "SubmitWorksResult [flag=" + flag + ", msg=" + msg + "]";
	}

}
