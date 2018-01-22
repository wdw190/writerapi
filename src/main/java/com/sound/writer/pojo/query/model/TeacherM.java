package com.sound.writer.pojo.query.model;

import java.io.Serializable;

import com.sound.writer.pojo.QualificationCertificate;
import com.sound.writer.pojo.TeacherPrice;
import com.sound.writer.pojo.UserAccount;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="教师基本信息")
public class TeacherM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(notes = "手机号码")
	private String phoneNumber;
	@ApiModelProperty(notes = "姓名")
	private String name;
	@ApiModelProperty(notes = "身份证号码")
	private String identificationNumber;
	@ApiModelProperty(notes = "学校名称")
	private String schoolName;
	@ApiModelProperty(notes = "职称")
	private String jobTitle;

	@ApiModelProperty(notes = "账号")
	UserAccount userAccount;
	@ApiModelProperty(notes = "评阅费用")
	TeacherPrice teacherPrice;
	@ApiModelProperty(notes = "证书")
	java.util.List<QualificationCertificate> qualificationCertificateList;

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

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public TeacherPrice getTeacherPrice() {
		return teacherPrice;
	}

	public void setTeacherPrice(TeacherPrice teacherPrice) {
		this.teacherPrice = teacherPrice;
	}

	public java.util.List<QualificationCertificate> getQualificationCertificateList() {
		return qualificationCertificateList;
	}

	public void setQualificationCertificateList(java.util.List<QualificationCertificate> qualificationCertificateList) {
		this.qualificationCertificateList = qualificationCertificateList;
	}

	@Override
	public String toString() {
		return "TeacherM [phoneNumber=" + phoneNumber + ", name=" + name + ", identificationNumber="
				+ identificationNumber + ", schoolName=" + schoolName + ", jobTitle=" + jobTitle + ", userAccount="
				+ userAccount + ", teacherPrice=" + teacherPrice + ", qualificationCertificateList="
				+ qualificationCertificateList + "]";
	}

}
