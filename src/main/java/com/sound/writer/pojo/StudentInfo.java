package com.sound.writer.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "学生基本信息")
public class StudentInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7818469890604214028L;
	@ApiModelProperty(value = "手机号码")
	private String phoneNumber;
	@ApiModelProperty(value = "姓名")
	private String name;
	@ApiModelProperty(value = "年龄")
	private int age;
	@ApiModelProperty(value = "学校")
	private String schoolName;
	@ApiModelProperty(value = "年级代码")
	private String gradeCode;
	@ApiModelProperty(value = "年级")
	private String gradeDesc;
	@ApiModelProperty(value = "账号")
	UserAccount userAccount;
	
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getSchoolName() {
		return schoolName;
	}



	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}



	public String getGradeCode() {
		return gradeCode;
	}



	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}



	public String getGradeDesc() {
		return gradeDesc;
	}



	public void setGradeDesc(String gradeDesc) {
		this.gradeDesc = gradeDesc;
	}



	public UserAccount getUserAccount() {
		return userAccount;
	}



	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}



	@Override
	public String toString() {
		return "StudentInfo [phoneNumber=" + phoneNumber + ", name=" + name + ", age=" + age + ", schoolName="
				+ schoolName + ", gradeCode=" + gradeCode + ", gradeDesc=" + gradeDesc + ", userAccount=" + userAccount
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
