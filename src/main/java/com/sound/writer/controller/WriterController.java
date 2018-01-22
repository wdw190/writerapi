package com.sound.writer.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sound.writer.mybatis.exception.WriterException;
import com.sound.writer.mybatis.service.RegisterResult;
import com.sound.writer.mybatis.service.WriterFileService;
import com.sound.writer.mybatis.service.WriterService;
import com.sound.writer.pojo.AgentList;
import com.sound.writer.pojo.ChangeTheResult;
import com.sound.writer.pojo.CostInfo;
import com.sound.writer.pojo.LoginResult;
import com.sound.writer.pojo.ReceiveFeeRecord;
import com.sound.writer.pojo.SaveChangeResultM;
import com.sound.writer.pojo.Student;
import com.sound.writer.pojo.SubmitWorksResult;
import com.sound.writer.pojo.Teacher;
import com.sound.writer.pojo.Works;
import com.sound.writer.pojo.query.model.AgentQueryConditionsM;
import com.sound.writer.pojo.query.model.AgentResultM;
import com.sound.writer.pojo.query.model.AgentSingleM;
import com.sound.writer.pojo.query.model.LoginM;
import com.sound.writer.pojo.query.model.MySingleWorksResultM;
import com.sound.writer.pojo.query.model.MyWorksResultM;
import com.sound.writer.pojo.query.model.ReceiveFeeRecordResultM;
import com.sound.writer.pojo.query.model.StudentInfoM;
import com.sound.writer.pojo.query.model.TeacherQueryConditionsM;
import com.sound.writer.pojo.query.model.TeacherResultListM;
import com.sound.writer.pojo.query.model.WalletResultM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/writer")
@Api(value = "作文家", description = "作文家应用API在线手册")
public class WriterController {

	private static Logger logger = LogManager.getLogger(WriterController.class);

	private WriterService writerService;

	private WriterFileService writerFileService;

	@RequestMapping(path = "/register/student", method = RequestMethod.POST, headers = "content-type=application/json", consumes = {
			"application/json" }, produces = "application/json")
	@ApiOperation(value = "学生用户注册", httpMethod = "POST", response = RegisterResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "注册成功") })
	public RegisterResult registerStudent(@RequestBody Student student) {
		RegisterResult registerResult = new RegisterResult();
		try {
			registerResult = this.writerService.registerStudent(student);
		} catch (WriterException e) {
			registerResult.setFlag("failed");
			registerResult.setMsg(e.getMessage());
		}

		return registerResult;

	}

	@RequestMapping(path = "/register/teacher/withoutfiles", method = RequestMethod.POST, headers = "content-type=application/json", consumes = {
			"application/json" }, produces = "application/json")
	@ApiOperation(value = "教师用户注册(不包含文件上传暂不可用)", httpMethod = "POST", response = RegisterResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "注册成功") })

	public RegisterResult registerTeacher(@RequestBody Teacher teacher) {

		RegisterResult registerResult = new RegisterResult();

		logger.info(teacher.toString());

		registerResult.setFlag("success");
		registerResult.setMsg("注册成功");

		return registerResult;

	}

	@RequestMapping(path = "/register/teacher/withfiles", method = RequestMethod.POST, headers = "content-type=application/json", consumes = {
			"multipart/form-data" }, produces = "application/json")
	@ApiOperation(value = "教师用户注册(包含文件上传)", httpMethod = "POST", response = RegisterResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "注册成功") })
	public RegisterResult registerTeacherWithFiles(Teacher teacher, @RequestParam(name = "files") MultipartFile[] files,
			HttpServletRequest request) throws WriterException {
		RegisterResult registerResult = new RegisterResult();

		try {
			registerResult = this.writerService.registerTeacherWithFiles(teacher, files, request);
		} catch (Exception e) {
			registerResult.setFlag("failed");
			registerResult.setMsg(e.getMessage());
		}

		return registerResult;

	}

	@RequestMapping(path = "/upload/{phoneNumber}", method = RequestMethod.POST, headers = "content-type=application/json", consumes = {
			"multipart/form-data" }, produces = "application/json")
	@ApiOperation(value = "文件上传", httpMethod = "POST", response = RegisterResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "上传成功") })

	public RegisterResult uploadFiles(@PathVariable(name = "phoneNumber") String phoneNumber,
			@RequestParam(name = "files") MultipartFile[] files, HttpServletRequest request) {
		RegisterResult registerResult = new RegisterResult();
		registerResult = this.writerFileService.uploadFiles(phoneNumber, files, request);
		return registerResult;

	}

	@GetMapping("/download/{phonenumber}/{filename:.+}")
	@ResponseBody
	@ApiOperation(value = "文件下载", httpMethod = "GET")
	public ResponseEntity<Resource> downloadFile(@PathVariable(name = "phonenumber") String phonenumber,
			@PathVariable(name = "filename") String filename, HttpServletRequest request) {

		return this.writerFileService.downloadFile(phonenumber, filename, request);
	}

	@RequestMapping(path = "/login/unamepass", method = RequestMethod.POST, headers = "content-type=application/json", consumes = {
			"application/json" }, produces = "application/json")
	@ApiOperation(value = "用户名密码登录", httpMethod = "POST", response = LoginResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "登录成功") })
	public LoginResult loginWithUNameAndPass(@RequestBody LoginM loginM) {

		LoginResult loginResult = this.writerService.LoginWithUNameAndPass(loginM);

		return loginResult;

	}

	@RequestMapping(path = "/submit/works", method = RequestMethod.POST, headers = "content-type=application/json", consumes = {
			"multipart/form-data" }, produces = "application/json")
	@ApiOperation(value = "作品提交", httpMethod = "POST", response = SubmitWorksResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "作品提交成功") })
	public SubmitWorksResult submitWorks(AgentList agentList, Works works, CostInfo costInfo,
			@RequestParam(name = "files") MultipartFile[] files, HttpServletRequest request) {

		SubmitWorksResult submitWorksResult = new SubmitWorksResult();

		try {
			submitWorksResult = this.writerService.submitWorks(agentList, works, costInfo, files, request);
		} catch (WriterException e) {

			submitWorksResult.setFlag("failed");
			submitWorksResult.setMsg(e.getMessage());

		}

		return submitWorksResult;
	}

	@RequestMapping(path = "/agent/list", method = RequestMethod.POST, headers = "content-type=application/json", consumes = {
			"application/json" }, produces = "application/json")
	@ApiOperation(value = "代办/已办列表", httpMethod = "POST", response = AgentResultM.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功") })
	public AgentResultM retrieveAgentList(@RequestBody AgentQueryConditionsM agentQueryConditionsM) {

		AgentResultM agentResultM = this.writerService.findAgentListByAgentStaff(agentQueryConditionsM);

		return agentResultM;
	}

	@RequestMapping(path = "/agent/single/{agentUUID}", method = RequestMethod.GET, produces = "application/json")
	@ApiImplicitParams({ @ApiImplicitParam(name = "agentUUID", value = "代办UUID") })
	@ApiOperation(value = "单条代办/已办详情", httpMethod = "GET", response = AgentSingleM.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "注册成功") })
	public AgentSingleM acquireSingleAgentInfo(@PathVariable(name = "agentUUID") String agentUUID) {

		AgentSingleM agentSingleM = this.writerService.findAgentInfoByUUID(agentUUID);

		return agentSingleM;

	}

	@RequestMapping(path = "/approved/works", method = RequestMethod.POST, headers = "content-type=application/json", consumes = {
			"multipart/form-data" }, produces = "application/json")
	@ApiOperation(value = "保存评阅结果", httpMethod = "POST", response = SaveChangeResultM.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "注册成功") })
	public SaveChangeResultM saveChangeTheResult(ChangeTheResult changeTheResult,
			@RequestParam(name = "files") MultipartFile[] files, HttpServletRequest request) {
		SaveChangeResultM saveChangeResultM = new SaveChangeResultM();

		try {
			saveChangeResultM = this.writerService.saveChangeTheResult(changeTheResult, files, request);
		} catch (WriterException e) {

			saveChangeResultM.setFlag("failed");

			saveChangeResultM.setMsg(e.getMessage());

		}

		return saveChangeResultM;

	}

	@RequestMapping(path = "/myworks/list/{phoneNumber}", method = RequestMethod.GET, produces = "application/json")
	@ApiImplicitParams({ @ApiImplicitParam(name = "phoneNumber", value = "用户名/手机号码") })
	@ApiOperation(value = "我的作品列表", httpMethod = "GET", response = MyWorksResultM.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功") })
	public MyWorksResultM retrieveMyWorksList(@PathVariable(name = "phoneNumber") String phoneNumber) {

		MyWorksResultM myWorksResultM = this.writerService.acquireMyWorks(phoneNumber);

		return myWorksResultM;
	}

	@RequestMapping(path = "/works/single/{agentUUID}", method = RequestMethod.GET, produces = "application/json")
	@ApiImplicitParams({ @ApiImplicitParam(name = "agentUUID", value = "作品ID") })
	@ApiOperation(value = "我的单个作品详情", httpMethod = "GET", response = MySingleWorksResultM.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功") })
	public MySingleWorksResultM acquireSingleWorksInfo(@PathVariable(name = "agentUUID") String agentUUID) {

		MySingleWorksResultM mySingleWorksResultM = this.writerService.acquireMySingleWorks(agentUUID);

		return mySingleWorksResultM;

	}

	@RequestMapping(path = "/teacher/list", method = RequestMethod.POST, headers = "content-type=application/json", consumes = {
			"application/json" }, produces = "application/json")
	@ApiOperation(value = "教师列表/教师基本信息", httpMethod = "POST", response = TeacherResultListM.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功") })
	public TeacherResultListM retrieveAgentList(@RequestBody TeacherQueryConditionsM teacherQueryConditionsM) {

		TeacherResultListM teacherResultListM = this.writerService.acquireTeacherList(teacherQueryConditionsM);

		return teacherResultListM;

	}

	@RequestMapping(path = "/student/baseinfo/{phoneNumber}", method = RequestMethod.GET, produces = "application/json")
	@ApiImplicitParams({ @ApiImplicitParam(name = "phoneNumber", value = "手机号码/账号", required = true) })
	@ApiOperation(value = "学生基本信息", httpMethod = "GET", response = StudentInfoM.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功") })

	public StudentInfoM studengInfo(@PathVariable(name = "phoneNumber") String phoneNumber) {

		StudentInfoM studentInfoM = this.writerService.acquireStudent(phoneNumber);

		return studentInfoM;
	}

	@RequestMapping(path = "/receive/fee", method = RequestMethod.POST, headers = "content-type=application/json", consumes = {
			"application/json" }, produces = "application/json")
	@ApiOperation(value = "领取费用", httpMethod = "POST", response = ReceiveFeeRecordResultM.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功") })
	public ReceiveFeeRecordResultM receiveFee(@RequestBody ReceiveFeeRecord receiveFeeRecord) {

		ReceiveFeeRecordResultM receiveFeeRecordResultM = this.writerService.receiveFee(receiveFeeRecord);

		return receiveFeeRecordResultM;

	}

	@RequestMapping(path = "/my/wallet/{phoneNumber}", method = RequestMethod.GET, produces = "application/json")
	@ApiImplicitParams({ @ApiImplicitParam(name = "phoneNumber", value = "手机号码/账号") })
	@ApiOperation(value = "我的钱包", httpMethod = "GET", response = WalletResultM.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功") })

	public WalletResultM myWallet(@PathVariable(name = "phoneNumber") String phoneNumber) {

		WalletResultM walletResultM = this.writerService.receiveMyWalletInfo(phoneNumber);

		return walletResultM;

	}

	public WriterService getWriterService() {
		return writerService;
	}

	@Autowired
	@Required
	public void setWriterService(@Qualifier("defaultWriterService") WriterService writerService) {
		this.writerService = writerService;
	}

	public WriterFileService getWriterFileService() {
		return writerFileService;
	}

	@Autowired
	@Required
	public void setWriterFileService(@Qualifier("defaultWriterFileService") WriterFileService writerFileService) {
		this.writerFileService = writerFileService;
	}

}
