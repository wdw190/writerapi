package com.sound.writer.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "教师评阅后的作品图片")
public class ApprovedWorks implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1722815223946073986L;

	@ApiModelProperty(value = "主键UUID")
	private String uuid;
	@ApiModelProperty(value = "代办UUID")
	private String agentListUuid;
	@ApiModelProperty(value = "评阅后的作品图片保存的路径")
	private String imagePath;
	@ApiModelProperty(value = "评阅时间")
	private String approvedTime;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getAgentListUuid() {
		return agentListUuid;
	}

	public void setAgentListUuid(String agentListUuid) {
		this.agentListUuid = agentListUuid;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getApprovedTime() {
		return approvedTime;
	}

	public void setApprovedTime(String approvedTime) {
		this.approvedTime = approvedTime;
	}

	@Override
	public String toString() {
		return "ApprovedWorks [uuid=" + uuid + ", agentListUuid=" + agentListUuid + ", imagePath=" + imagePath
				+ ", approvedTime=" + approvedTime + "]";
	}

}
