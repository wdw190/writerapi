package com.sound.writer.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="学生基本信息")
public class Student extends UserAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6141077799578554887L;
	@ApiModelProperty(value = "姓名", required = true)
	private String name;
	@ApiModelProperty(value = "年龄", required = true)
	private int age;
	@ApiModelProperty(value = "学校名称", required = true)
	private String schoolName;
	@ApiModelProperty(value = "年级代码")
	private int gradeCode;
	@ApiModelProperty(value = "年级名称", required = true)
	private String gradeDesc;

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

	public int getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(int gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getGradeDesc() {
		return gradeDesc;
	}

	public void setGradeDesc(String gradeDesc) {
		this.gradeDesc = gradeDesc;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", schoolName=" + schoolName + ", gradeCode=" + gradeCode
				+ ", gradeDesc=" + gradeDesc + ", toString()=" + super.toString() + "]";
	}

}
