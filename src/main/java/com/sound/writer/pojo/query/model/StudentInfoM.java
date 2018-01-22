package com.sound.writer.pojo.query.model;

import java.io.Serializable;

import com.sound.writer.pojo.StudentInfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="学生信息返回结果")
public class StudentInfoM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3774032671431609359L;
	@ApiModelProperty(value="学生信息详情")
	private StudentInfo studentInfo;
	@ApiModelProperty(value="标志位  success:成功 failed:失败")
	private String flag;
	@ApiModelProperty(value="学生信息详情")
	private String msg;
	public StudentInfo getStudentInfo() {
		return studentInfo;
	}
	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
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
		return "StudentInfoM [studentInfo=" + studentInfo + ", flag=" + flag + ", msg=" + msg + "]";
	}
	
	
	

}
