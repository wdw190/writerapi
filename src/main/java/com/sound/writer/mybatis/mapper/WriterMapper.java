package com.sound.writer.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sound.writer.pojo.ApplyNow;
import com.sound.writer.pojo.ApprovedWorks;
import com.sound.writer.pojo.ChangeTheResult;
import com.sound.writer.pojo.CostInfo;
import com.sound.writer.pojo.MyWorksM;
import com.sound.writer.pojo.QualificationCertificate;
import com.sound.writer.pojo.ReceiveFeeRecord;
import com.sound.writer.pojo.Student;
import com.sound.writer.pojo.StudentInfo;
import com.sound.writer.pojo.Teacher;
import com.sound.writer.pojo.TeacherPrice;
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

@Mapper
public interface WriterMapper {

	/**
	 * 注册账号
	 * 
	 * @param userAccount
	 * @return
	 */

	public int insertUserAccount(UserAccount userAccount);

	public int insertStudent(com.sound.writer.pojo.Student student);

	public int insertTeacher(com.sound.writer.pojo.Teacher teacher);

	public int insertQualificationCertificates(java.util.List<QualificationCertificate> list);

	public LoginUserInfoM queryUserByUNameAndPass(LoginM loginM);

	public int insertAgentList(com.sound.writer.pojo.AgentList agentList);

	public int insertWorks(java.util.List<Works> list);

	public int insertCostInfo(com.sound.writer.pojo.CostInfo costInfo);

	public List<AgentM> findAgentListByAgentStaff(AgentQueryConditionsM agentQueryConditionsM);

	public CostInfo findCostInfoByAgentListUUID(String agentListUuid);

	public List<Works> findWorksByAgentId(String agentListUuid);

	public AgentM findAgentInfoByUUID(String agentUUID);

	/**
	 * 插入批改结果
	 * 
	 * @param changeTheResult
	 * @return
	 */
	public int insertChangeResult(ChangeTheResult changeTheResult);

	/**
	 * 将代办的状态设置为已阅
	 * 
	 * @param agentUUID
	 * @return
	 */
	public int updateAgentEvaluationStatusByUUID(String agentUUID);

	public int insertApprovedWorks(java.util.List<ApprovedWorks> list);

	public Teacher findTeacherByPhoneNumber(String phoneNumber);

	public List<ApprovedWorks> findApprovedWorks(String agentListUuid);

	public List<MyWorksM> findMyWorksBYPhoneNum(String phoneNumber);

	public ChangeTheResult findChangeTheResultByAgentUUID(String agentListUuid);

	public MyWorksM findMySingleWorksInfo(String uuid);

	public UserAccount findUserAccountByPhoneNumber(String phoneNumber);

	public TeacherPrice findTeacherPriceByPhoneNumber(String phoneNumber);

	public List<QualificationCertificate> findQualificationCertificateList(String phoneNumber);

	public List<TeacherM> findTeacherInfoList(TeacherQueryConditionsM teacherQueryConditionsM);

	public StudentInfo findStudentInfoByPhoneNumber(String phoneNumber);

	public int insertReceiveFeeRecord(ReceiveFeeRecord receiveFeeRecord);

	public int addWalletMoney(ReceiveFeeRecord receiveFeeRecord);

	public int updateAgentReceiveTheFeeStaus(String agentUUID);

	public int addWallet(Wallet wallet);

	public List<ReceiveFeeRecord> findReceiveFeeRecordList(String phoneNumber);

	public List<ApplyNow> findApplyNowList(String phoneNumber);

	public WalletM findMyWalletInfo(String phoneNumber);

	public Student findStudentByPhoneNumber(String phoneNumber);

}
