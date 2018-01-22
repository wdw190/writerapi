package com.sound.writer.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="教师基本信息")
public class Teacher extends UserAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6956512241891914787L;
	
	@ApiModelProperty(notes = "姓名", required = true)
	private String name;
	@ApiModelProperty(notes = "身份证号码", required = true)
	private String identificationNumber;
	@ApiModelProperty(notes = "学校名称", required = true)
	private String schoolName;
	@ApiModelProperty(notes = "职称", required = true)
	private String jobTitle;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", identificationNumber=" + identificationNumber + ", schoolName=" + schoolName
				+ ", jobTitle=" + jobTitle + ", toString()=" + super.toString() + "]";
	}
	
	
	

}
