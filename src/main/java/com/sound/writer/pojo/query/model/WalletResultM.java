package com.sound.writer.pojo.query.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="我的钱包返回结果")
public class WalletResultM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2677945128054128340L;
	@ApiModelProperty(value="钱包" )
	WalletM walletM;
	
	@ApiModelProperty(value="标志位 success:成功 failed:失败" )
	private String falg;
	@ApiModelProperty(value="提示信息")
	private String msg;
	public WalletM getWalletM() {
		return walletM;
	}
	public void setWalletM(WalletM walletM) {
		this.walletM = walletM;
	}
	public String getFalg() {
		return falg;
	}
	public void setFalg(String falg) {
		this.falg = falg;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "WalletResultM [walletM=" + walletM + ", falg=" + falg + ", msg=" + msg + ", toString()="
				+ super.toString() + "]";
	}

	
	

}
