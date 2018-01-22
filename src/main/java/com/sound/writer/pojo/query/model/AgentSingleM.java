package com.sound.writer.pojo.query.model;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="单条代办详情")
public class AgentSingleM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7044225082664071404L;
	
	
	@ApiModelProperty(value="代办")
	AgentM  agentM;
	@ApiModelProperty(value="标志位 success:成功 failed:失败" )
	private String falg;
	@ApiModelProperty(value="提示信息")
	private String msg;
	public AgentM getAgentM() {
		return agentM;
	}
	public void setAgentM(AgentM agentM) {
		this.agentM = agentM;
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
		return "AgentSingleM [agentM=" + agentM + ", falg=" + falg + ", msg=" + msg + "]";
	}
	
	
	

}
