package com.sound.writer.mybatis.dao;

import java.util.List;

import com.sound.writer.mybatis.exception.WriterException;
import com.sound.writer.pojo.ApprovedWorks;
import com.sound.writer.pojo.ChangeTheResult;
import com.sound.writer.pojo.MyWorksM;
import com.sound.writer.pojo.QualificationCertificate;
import com.sound.writer.pojo.ReceiveFeeRecord;
import com.sound.writer.pojo.StudentInfo;
import com.sound.writer.pojo.UserAccount;
import com.sound.writer.pojo.Wallet;
import com.sound.writer.pojo.Works;
import com.sound.writer.pojo.query.model.AgentM;
import com.sound.writer.pojo.query.model.AgentQueryConditionsM;
import com.sound.writer.pojo.query.model.LoginM;
import com.sound.writer.pojo.query.model.LoginUserInfoM;
import com.sound.writer.pojo.query.model.TeacherM;
import com.sound.writer.pojo.query.model.TeacherQueryConditionsM;
import com.sound.writer.pojo.query.model.WalletM;

public interface WriterDao {

	/**
	 * 注册
	 * 
	 * @param userAccount
	 * @return
	 */
	public int insertUserAccount(UserAccount userAccount) throws WriterException;

	public int insertStudent(com.sound.writer.pojo.Student student) throws WriterException;

	public int insertTeacher(com.sound.writer.pojo.Teacher teacher) throws WriterException;

	public int insertQualificationCertificates(java.util.List<QualificationCertificate> list) throws WriterException;

	public LoginUserInfoM queryUserByUNameAndPass(LoginM loginM) throws WriterException;

	public int insertAgentList(com.sound.writer.pojo.AgentList agentList) throws WriterException;

	public int insertWorks(java.util.List<Works> list) throws WriterException;

	public int insertCostInfo(com.sound.writer.pojo.CostInfo costInfo) throws WriterException;

	public List<AgentM> findAgentListByAgentStaff(AgentQueryConditionsM agentQueryConditionsM) throws WriterException;

	public AgentM findAgentInfoByUUID(String agentUUID) throws WriterException;

	public int insertChangeResult(ChangeTheResult changeTheResult) throws WriterException;

	public int updateAgentEvaluationStatusByUUID(String agentUUID) throws WriterException;

	public int insertApprovedWorks(java.util.List<ApprovedWorks> list) throws WriterException;

	public List<MyWorksM> findMyWorksBYPhoneNum(String phoneNumber) throws WriterException;

	public MyWorksM findMySingleWorksInfo(String uuid) throws WriterException;

	public List<TeacherM> findTeacherInfoList(TeacherQueryConditionsM teacherQueryConditionsM) throws WriterException;

	public StudentInfo findStudentInfoByPhoneNumber(String phoneNumber) throws WriterException;

	public int insertReceiveFeeRecord(ReceiveFeeRecord receiveFeeRecord) throws WriterException;

	public int addWalletMoney(ReceiveFeeRecord receiveFeeRecord) throws WriterException;
	
	public int updateAgentReceiveTheFeeStaus(String agentUUID)  throws WriterException;
	
	public int addWallet(Wallet wallet) throws WriterException;
	
	public List<ReceiveFeeRecord> findReceiveFeeRecordList(String phoneNumber) throws WriterException;
	
	public WalletM  findMyWalletInfo(String phoneNumber)  throws WriterException; 

}
