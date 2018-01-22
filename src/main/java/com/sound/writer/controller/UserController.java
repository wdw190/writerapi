package com.sound.writer.controller;

import java.security.Principal;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sound.writer.mybatis.service.RegisterResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
//@EnableResourceServer
@RequestMapping(path = "/client")
@Api(value = "客户端账号", description = "客户端账号信息")
public class UserController {

	@RequestMapping(path = "/user", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "账号信息", httpMethod = "GET", response = Principal.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功返回账号信息") })
	public Principal user(Principal user) {

		return user;
	}

}
