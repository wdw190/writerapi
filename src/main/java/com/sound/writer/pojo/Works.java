package com.sound.writer.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "作品")
public class Works implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2212829072787245482L;

	@ApiModelProperty(value = "账号/手机号码/作品所有人",required=true)
	private String phoneNumber;
	@ApiModelProperty(value = "UUID主键",hidden=true)
	private String uuid;
	@ApiModelProperty(value = "作品名称",required=true)
	private String title;
	@ApiModelProperty(value = "作品文本内容",hidden=true)
	private String content;
	@ApiModelProperty(value = "图片作品路径",hidden=true)
	private String imageContentPath;
	@ApiModelProperty(value = "创作时间",required=true)
	private String creationTime;
	@ApiModelProperty(value = "是否公开 0:否 1:是",required=true)
	private String isItOpen;
	@ApiModelProperty(value = "代办任务UUID",hidden=true)
	private String agentListUuid;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageContentPath() {
		return imageContentPath;
	}

	public void setImageContentPath(String imageContentPath) {
		this.imageContentPath = imageContentPath;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public String getIsItOpen() {
		return isItOpen;
	}

	public void setIsItOpen(String isItOpen) {
		this.isItOpen = isItOpen;
	}

	public String getAgentListUuid() {
		return agentListUuid;
	}

	public void setAgentListUuid(String agentListUuid) {
		this.agentListUuid = agentListUuid;
	}

	@Override
	public String toString() {
		return "Works [phoneNumber=" + phoneNumber + ", uuid=" + uuid + ", title=" + title + ", content=" + content
				+ ", imageContentPath=" + imageContentPath + ", creationTime=" + creationTime + ", isItOpen=" + isItOpen
				+ ", agentListUuid=" + agentListUuid + "]";
	}

}
