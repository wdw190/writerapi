package com.sound.writer.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="证书基本信息")
public class QualificationCertificate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1621889529886908504L;

	@ApiModelProperty(notes = "唯一标示--主键")
	private String uuid;
	@ApiModelProperty(notes = "手机号码/账号")
	private String phoneNumber;
	@ApiModelProperty(notes = "证书名称")
	private String certificateName;
	@ApiModelProperty(notes = "证书查看路径")
	private String certificatePathView;
	@ApiModelProperty(notes = "证书下载路径")
	private String certificatePathDownload;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public String getCertificatePathView() {
		return certificatePathView;
	}

	public void setCertificatePathView(String certificatePathView) {
		this.certificatePathView = certificatePathView;
	}

	public String getCertificatePathDownload() {
		return certificatePathDownload;
	}

	public void setCertificatePathDownload(String certificatePathDownload) {
		this.certificatePathDownload = certificatePathDownload;
	}

	@Override
	public String toString() {
		return "QualificationCertificate [uuid=" + uuid + ", phoneNumber=" + phoneNumber + ", certificateName="
				+ certificateName + ", certificatePathView=" + certificatePathView + ", certificatePathDownload="
				+ certificatePathDownload + "]";
	}

}
