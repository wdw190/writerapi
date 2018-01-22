package com.sound.writer.pojo.query.model;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="代办返回结果")
public class AgentResultM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3273485392108578173L;
	
	@ApiModelProperty(value="代办")
	List<AgentM>  agentMList;
	@ApiModelProperty(value="标志位 success:成功 failed:失败" )
	private String falg;
	@ApiModelProperty(value="提示信息")
	private String msg;

	public List<AgentM> getAgentMList() {
		return agentMList;
	}

	public void setAgentMList(List<AgentM> agentMList) {
		this.agentMList = agentMList;
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
	
	

}
