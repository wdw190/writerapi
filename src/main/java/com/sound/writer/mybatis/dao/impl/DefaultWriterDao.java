package com.sound.writer.mybatis.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import com.sound.writer.mybatis.dao.WriterDao;
import com.sound.writer.mybatis.exception.WriterException;
import com.sound.writer.mybatis.mapper.WriterMapper;
import com.sound.writer.pojo.AgentList;
import com.sound.writer.pojo.ApprovedWorks;
import com.sound.writer.pojo.ChangeTheResult;
import com.sound.writer.pojo.CostInfo;
import com.sound.writer.pojo.MyWorksM;
import com.sound.writer.pojo.QualificationCertificate;
import com.sound.writer.pojo.ReceiveFeeRecord;
import com.sound.writer.pojo.Student;
import com.sound.writer.pojo.StudentInfo;
import com.sound.writer.pojo.Teacher;
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

@Repository("defaultWriterDao")
public class DefaultWriterDao implements WriterDao {

	private static Logger logger = LogManager.getLogger(DefaultWriterDao.class);

	private SqlSession sqlSession;

	/**
	 * 插入账号
	 */
	@Override
	public int insertUserAccount(UserAccount userAccount) throws WriterException {

		int insertedNum = 0;

		try {
			WriterMapper mapper = this.sqlSession.getMapper(WriterMapper.class);

			insertedNum = mapper.insertUserAccount(userAccount);
		} catch (Exception ex) {

			throw new WriterException(ex.getMessage());

		}

		return insertedNum;
	}

	/**
	 * 插入学生基本信息
	 */
	@Override
	public int insertStudent(Student student) throws WriterException {

		int insertedNum = 0;

		try {
			WriterMapper mapper = this.sqlSession.getMapper(WriterMapper.class);

			insertedNum = mapper.insertStudent(student);
		} catch (Exception ex) {

			throw new WriterException(ex.getMessage());

		}

		return insertedNum;
	}

	/**
	 * 插入教师基本信息
	 */

	@Override
	public int insertTeacher(Teacher teacher) throws WriterException {

		int insertedNum = 0;

		try {
			WriterMapper mapper = this.sqlSession.getMapper(WriterMapper.class);

			insertedNum = mapper.insertTeacher(teacher);
		} catch (Exception ex) {

			throw new WriterException(ex.getMessage());

		}

		return insertedNum;
	}

	@Override
	public int insertQualificationCertificates(List<QualificationCertificate> list) throws WriterException {

		int insertedNum = 0;

		try {
			WriterMapper mapper = this.sqlSession.getMapper(WriterMapper.class);

			insertedNum = mapper.insertQualificationCertificates(list);
		} catch (Exception ex) {

			throw new WriterException(ex.getMessage());

		}

		return insertedNum;
	}

	/**
	 * 用户名和密码认证查询
	 */
	@Override
	public LoginUserInfoM queryUserByUNameAndPass(LoginM loginM) throws WriterException {

		LoginUserInfoM loginUserInfoM = new LoginUserInfoM();

		try {
			WriterMapper mapper = this.sqlSession.getMapper(WriterMapper.class);

			loginUserInfoM = mapper.queryUserByUNameAndPass(loginM);
		} catch (Exception ex) {

			throw new WriterException(ex.getMessage());
		}

		return loginUserInfoM;
	}

	/**
	 * 插入代办
	 */

	@Override
	public int insertAgentList(AgentList agentList) throws WriterException {

		int insertedRows = 0;

		try {
			WriterMapper mapper = this.sqlSession.getMapper(WriterMapper.class);

			insertedRows = mapper.insertAgentList(agentList);
		} catch (Exception e) {
			logger.error("--------------插入缴费记录失败---------------");
			logger.info(agentList.toString());
			logger.error("错误信息：" + e.getMessage());
			throw new WriterException(e.getMessage());
		}

		return insertedRows;
	}

	/**
	 * 批量插入作品
	 */
	@Override
	public int insertWorks(List<Works> list) throws WriterException {

		int insertedRows = 0;

		try {
			WriterMapper mapper = this.sqlSession.getMapper(WriterMapper.class);

			insertedRows = mapper.insertWorks(list);
		} catch (Exception e) {
			logger.error("---------------插入作品失败-------------------");
			logger.error(list.toString());
			logger.error("错误原因：" + e.getMessage());
			throw new WriterException(e.getMessage());
		}

		return insertedRows;
	}

	/**
	 * 插入缴费记录
	 */
	@Override
	public int insertCostInfo(CostInfo costInfo) throws WriterException {
		int insertedRows = 0;

		try {
			WriterMapper mapper = this.sqlSession.getMapper(WriterMapper.class);
			insertedRows = mapper.insertCostInfo(costInfo);
		} catch (Exception e) {
			logger.error("--------------插入缴费记录失败-------------");
			logger.error(costInfo.toString());
			logger.error("错误原因：" + e.getMessage());
			throw new WriterException(e.getMessage());
		}

		return insertedRows;
	}

	/**
	 * 根据指定的代办人获取代办
	 */
	@Override
	public List<AgentM> findAgentListByAgentStaff(AgentQueryConditionsM agentQueryConditionsM) throws WriterException {

		List<AgentM> agentMList = new ArrayList<AgentM>();

		try {
			WriterMapper mapper = this.sqlSession.getMapper(WriterMapper.class);

			agentMList = mapper.findAgentListByAgentStaff(agentQueryConditionsM);
		} catch (Exception e) {

			logger.error("--------根据代办人获取代办失败------------");
			logger.error("错误信息：" + e.getMessage());
			logger.error("错误原因：" + e.getCause());

			throw new WriterException(e.getMessage());
		}

		return agentMList;
	}

	/**
	 * 根据指定的代办ID获取代办详情
	 */

	@Override
	public AgentM findAgentInfoByUUID(String agentUUID) throws WriterException {

		AgentM agentM;

		try {
			WriterMapper mapper = this.sqlSession.getMapper(WriterMapper.class);

			agentM = mapper.findAgentInfoByUUID(agentUUID);
		} catch (Exception e) {
			throw new WriterException(e.getMessage());
		}

		return agentM;
	}

	/**
	 * 插入批改结果
	 */

	@Override
	public int insertChangeResult(ChangeTheResult changeTheResult) throws WriterException {

		int insertedRows = 0;

		try {
			WriterMapper mapper = this.sqlSession.getMapper(WriterMapper.class);
			insertedRows = mapper.insertChangeResult(changeTheResult);
		} catch (Exception e) {

			throw new WriterException(e.getMessage());

		}

		return insertedRows;
	}

	/**
	 * 将代办的状态设置为已阅
	 */
	@Override
	public int updateAgentEvaluationStatusByUUID(String agentUUID) throws WriterException {

		int updatedRows = 0;

		try {
			WriterMapper mapper = this.sqlSession.getMapper(WriterMapper.class);

			updatedRows = mapper.updateAgentEvaluationStatusByUUID(agentUUID);
		} catch (Exception e) {

			throw new WriterException(e.getMessage());

		}

		return updatedRows;
	}

	/**
	 * 批量插入 评阅后的作品
	 */

	@Override
	public int insertApprovedWorks(List<ApprovedWorks> list) throws WriterException {

		int insertedRows = 0;

		try {
			WriterMapper mapper = this.sqlSession.getMapper(WriterMapper.class);

			insertedRows = mapper.insertApprovedWorks(list);
		} catch (Exception e) {

			throw new WriterException(e.getMessage());

		}

		return insertedRows;
	}

	/**
	 * 查询我的作品
	 */

	@Override
	public List<MyWorksM> findMyWorksBYPhoneNum(String phoneNumber) throws WriterException {

		List<MyWorksM> myWorksMList = new ArrayList<MyWorksM>();

		try {
			WriterMapper mapper = this.sqlSession.getMapper(WriterMapper.class);
			myWorksMList = mapper.findMyWorksBYPhoneNum(phoneNumber);
		} catch (Exception e) {

			throw new WriterException(e.getMessage());
		}
		return myWorksMList;
	}

	/**
	 * 获取单个作品详情
	 */

	@Override
	public MyWorksM findMySingleWorksInfo(String uuid) throws WriterException {

		MyWorksM myWorksM;

		try {
			WriterMapper mapper = this.sqlSession.getMapper(WriterMapper.class);

			myWorksM = mapper.findMySingleWorksInfo(uuid);
		} catch (Exception e) {
			throw new WriterException(e.getMessage());
		}

		return myWorksM;
	}

	/**
	 * 教师列表查询
	 */

	@Override
	public List<TeacherM> findTeacherInfoList(TeacherQueryConditionsM teacherQueryConditionsM) throws WriterException {

		List<TeacherM> teacherMList = new ArrayList<TeacherM>();

		try {
			WriterMapper mapper = this.sqlSession.getMapper(WriterMapper.class);

			teacherMList = mapper.findTeacherInfoList(teacherQueryConditionsM);
		} catch (Exception e) {

			throw new WriterException(e.getMessage());

		}

		return teacherMList;
	}

	/**
	 * 学生基本信息查询
	 */

	@Override
	public StudentInfo findStudentInfoByPhoneNumber(String phoneNumber) throws WriterException {

		StudentInfo studentInfo;

		try {
			WriterMapper mapper = this.sqlSession.getMapper(WriterMapper.class);
			studentInfo = mapper.findStudentInfoByPhoneNumber(phoneNumber);
		} catch (Exception e) {

			throw new WriterException(e.getMessage());

		}
		return studentInfo;
	}

	/**
	 * 新增费用领取记录
	 */
	@Override
	public int insertReceiveFeeRecord(ReceiveFeeRecord receiveFeeRecord) throws WriterException {
		int insertedRows = 0;

		try {
			WriterMapper mapper = this.sqlSession.getMapper(WriterMapper.class);

			insertedRows = mapper.insertReceiveFeeRecord(receiveFeeRecord);
		} catch (Exception e) {
			throw new WriterException(e.getMessage());
		}

		return insertedRows;
	}

	/**
	 * 增加钱包金额
	 */
	@Override
	public int addWalletMoney(ReceiveFeeRecord receiveFeeRecord) throws WriterException {

		int updatedRows = 0;
		try {
			WriterMapper mapper = this.sqlSession.getMapper(WriterMapper.class);
			updatedRows = mapper.addWalletMoney(receiveFeeRecord);
		} catch (Exception e) {
			throw new WriterException(e.getMessage());
		}
		return updatedRows;
	}

	/**
	 * 修改已办任务的费用领取状态
	 */

	@Override
	public int updateAgentReceiveTheFeeStaus(String agentUUID) throws WriterException {

		int updatedRows = 0;

		try {
			WriterMapper mapper = this.sqlSession.getMapper(WriterMapper.class);

			updatedRows = mapper.updateAgentReceiveTheFeeStaus(agentUUID);
		} catch (Exception e) {
			throw new WriterException(e.getMessage());
		}
		return updatedRows;
	}

	/**
	 * 添加钱包账号
	 */

	@Override
	public int addWallet(Wallet wallet) throws WriterException {

		int insertedRows = 0;
		try {
			WriterMapper mapper = this.sqlSession.getMapper(WriterMapper.class);
			insertedRows = mapper.addWallet(wallet);
		} catch (Exception e) {

			throw new WriterException(e.getMessage());
		}

		return insertedRows;
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	/**
	 * 查询费用领取记录
	 */

	@Override
	public List<ReceiveFeeRecord> findReceiveFeeRecordList(String phoneNumber) throws WriterException {

		List<ReceiveFeeRecord> receiveFeeRecordList = new ArrayList<ReceiveFeeRecord>();

		try {
			WriterMapper mapper = this.sqlSession.getMapper(WriterMapper.class);

			receiveFeeRecordList = mapper.findReceiveFeeRecordList(phoneNumber);
		} catch (Exception e) {
			throw new WriterException(e.getMessage());
		}

		return receiveFeeRecordList;
	}

	/**
	 * 查询我的钱包
	 */

	@Override
	public WalletM findMyWalletInfo(String phoneNumber) throws WriterException {

		WalletM walletM;

		try {
			WriterMapper mapper = this.sqlSession.getMapper(WriterMapper.class);

			walletM = mapper.findMyWalletInfo(phoneNumber);
		} catch (Exception e) {
			throw new WriterException(e.getMessage());
		}

		return walletM;
	}

	@Autowired
	@Required
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

}
