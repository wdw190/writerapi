package com.sound.writer.mybatis.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.sound.writer.mybatis.exception.WriterException;
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

public interface WriterService {


	/**
	 * 学生用户注册
	 * 
	 * @param student
	 * @return
	 * @throws WriterException
	 */
	public RegisterResult registerStudent(Student student) throws WriterException;
	
	/**
	 * 教师用户注册
	 * @param teacher
	 * @param files
	 * @param request
	 * @return
	 * @throws WriterException
	 */
	public RegisterResult registerTeacherWithFiles(Teacher teacher, MultipartFile[] files,
			HttpServletRequest request) throws WriterException ;
	
	
	public LoginResult LoginWithUNameAndPass(LoginM loginM);
	
	/**
	 * 作品提交
	 * @param agentList
	 * @param works
	 * @param costInfo
	 * @return
	 * @throws WriterException
	 */
	public  SubmitWorksResult submitWorks(AgentList agentList,Works works,CostInfo costInfo,MultipartFile[] files,HttpServletRequest request)  throws WriterException ;
	
	/**
	 * 基于代办人查询代办
	 * @param agentQueryConditionsM
	 * @return
	 * @throws WriterException
	 */
	
	public AgentResultM findAgentListByAgentStaff(AgentQueryConditionsM agentQueryConditionsM) throws WriterException;
	
	/**
	 * 根据代办ID查询代办详情
	 * @param agentUUID
	 * @return
	 */
	public AgentSingleM findAgentInfoByUUID(String agentUUID);
	
	/**
	 * 保存评阅结果
	 * @param changeTheResult
	 * @param files
	 * @param request
	 * @return
	 * @throws WriterException
	 */
	public SaveChangeResultM saveChangeTheResult(ChangeTheResult changeTheResult,MultipartFile[] files,HttpServletRequest request) throws WriterException;
	
	/**
	 * 查询我的作品
	 * @param phoneNumber
	 * @return
	 */
	public MyWorksResultM acquireMyWorks(String phoneNumber);
	
	
	public MySingleWorksResultM acquireMySingleWorks(String agentUUID);
	
	public TeacherResultListM acquireTeacherList(TeacherQueryConditionsM teacherQueryConditionsM);
	
	public StudentInfoM acquireStudent(String phoneNumber);
	
	/**
	 * 费用领取
	 * @param receiveFeeRecord
	 * @return
	 */
	public ReceiveFeeRecordResultM receiveFee(ReceiveFeeRecord receiveFeeRecord);
	
	
	public  WalletResultM  receiveMyWalletInfo(String phoneNumber);
	

}
