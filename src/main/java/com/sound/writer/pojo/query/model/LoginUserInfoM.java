package com.sound.writer.pojo.query.model;

import java.io.Serializable;

import com.sound.writer.pojo.Student;
import com.sound.writer.pojo.Teacher;
import com.sound.writer.pojo.UserAccount;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "登录成功后返回的用户信息")
public class LoginUserInfoM extends UserAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1407444798898191976L;

	@ApiModelProperty(value = "学生信息")
	private Student student;
	@ApiModelProperty(value = "教师信息")
	private Teacher teacher;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "LoginUserInfoM [student=" + student + ", teacher=" + teacher + ", toString()=" + super.toString() + "]";
	}

}
