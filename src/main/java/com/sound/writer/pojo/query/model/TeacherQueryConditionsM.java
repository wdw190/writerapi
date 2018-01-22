package com.sound.writer.pojo.query.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="教师列表查询条件")
public class TeacherQueryConditionsM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 368683874209090762L;

	@ApiModelProperty(value="手机号码/账号，不传参查所有")
	private String phoneNumber;
	@ApiModelProperty(value="职称/等级，不传参查所有")
	private String jobTitle;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Override
	public String toString() {
		return "TeacherQueryConditionsM [phoneNumber=" + phoneNumber + ", jobTitle=" + jobTitle + "]";
	}

}
