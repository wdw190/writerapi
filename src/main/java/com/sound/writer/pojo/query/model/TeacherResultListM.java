package com.sound.writer.pojo.query.model;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="教师列表返回信息")
public class TeacherResultListM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1265129506575150705L;
	@ApiModelProperty(value="教师列表详细信息")
	private List<TeacherM> teacherMList;
	@ApiModelProperty(value="标志位 success:成功 failed:失败")
	private String flag;
	@ApiModelProperty(value="提示信息")
	private String msg;
	public List<TeacherM> getTeacherMList() {
		return teacherMList;
	}
	public void setTeacherMList(List<TeacherM> teacherMList) {
		this.teacherMList = teacherMList;
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
		return "TeacherResultListM [teacherMList=" + teacherMList + ", flag=" + flag + ", msg=" + msg + "]";
	}
	
	

}
