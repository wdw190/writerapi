package com.sound.writer.mybatis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sound.writer.mybatis.dao.WriterDao;
import com.sound.writer.mybatis.exception.WriterException;
import com.sound.writer.pojo.AgentList;
import com.sound.writer.pojo.ApprovedWorks;
import com.sound.writer.pojo.ChangeTheResult;
import com.sound.writer.pojo.CostInfo;
import com.sound.writer.pojo.LoginResult;
import com.sound.writer.pojo.MyWorksM;
import com.sound.writer.pojo.QualificationCertificate;
import com.sound.writer.pojo.ReceiveFeeRecord;
import com.sound.writer.pojo.SaveChangeResultM;
import com.sound.writer.pojo.Student;
import com.sound.writer.pojo.StudentInfo;
import com.sound.writer.pojo.SubmitWorksResult;
import com.sound.writer.pojo.Teacher;
import com.sound.writer.pojo.UserAccount;
import com.sound.writer.pojo.Wallet;
import com.sound.writer.pojo.Works;
import com.sound.writer.pojo.query.model.AgentM;
import com.sound.writer.pojo.query.model.AgentQueryConditionsM;
import com.sound.writer.pojo.query.model.AgentResultM;
import com.sound.writer.pojo.query.model.AgentSingleM;
import com.sound.writer.pojo.query.model.LoginM;
import com.sound.writer.pojo.query.model.LoginUserInfoM;
import com.sound.writer.pojo.query.model.MySingleWorksResultM;
import com.sound.writer.pojo.query.model.MyWorksResultM;
import com.sound.writer.pojo.query.model.ReceiveFeeRecordResultM;
import com.sound.writer.pojo.query.model.StudentInfoM;
import com.sound.writer.pojo.query.model.TeacherM;
import com.sound.writer.pojo.query.model.TeacherQueryConditionsM;
import com.sound.writer.pojo.query.model.TeacherResultListM;
import com.sound.writer.pojo.query.model.WalletM;
import com.sound.writer.pojo.query.model.WalletResultM;
import com.sound.writer.storage.StorageService;
import com.sound.writer.utils.WriterUtils;

@Service("defaultWriterService")
public class DefaultWriterService implements WriterService {

	private static Logger logger = LogManager.getLogger(DefaultWriterService.class);

	private WriterDao writerDao;

	@Autowired
	private ApplicationContext appContext;

	@Override
	// 事务
	@Transactional
	public RegisterResult registerStudent(Student student) throws WriterException {

		RegisterResult registerResult = new RegisterResult();

		UserAccount userAccount = new UserAccount();

		userAccount.setAccountType(student.getAccountType());
		userAccount.setPassword(student.getPassword());
		userAccount.setPhoneNumber(student.getPhoneNumber());
		userAccount.setRegisteredTime(student.getRegisteredTime());

		try {

			this.writerDao.insertUserAccount(userAccount); // 插入账号信息
			this.writerDao.insertStudent(student); // 插入学生基本信息

			registerResult.setFlag("success");
			registerResult.setMsg("注册成功");

			logger.info("---------------下述学生-用户注册【成功】----------BEGIN--------");
			logger.info("用户信息：" + student.toString());
			logger.info("---------------学生-用户注册【成功】----------END--------");
		} catch (WriterException ex) {

			registerResult.setFlag("failed");
			registerResult.setMsg("注册失败:" + ex.getMessage());
			logger.error("---------------下述学生-用户注册【失败】----------BEGIN--------");
			logger.error("用户信息：" + student.toString());
			logger.error("失败原因:" + ex.getMessage());
			logger.error("---------------学生-用户注册【失败】----------END--------");

			throw ex;

		}

		return registerResult;

	}

	@Override
	@Transactional
	public RegisterResult registerTeacherWithFiles(Teacher teacher, MultipartFile[] files, HttpServletRequest request)
			throws WriterException {

		RegisterResult registerResult = new RegisterResult();

		// 构建账号实体
		UserAccount userAccount = new UserAccount();

		userAccount.setAccountType(teacher.getAccountType());
		userAccount.setPassword(teacher.getPassword());
		userAccount.setPhoneNumber(teacher.getPhoneNumber());
		userAccount.setRegisteredTime(teacher.getRegisteredTime());

		// 获取操作文件的BEAN
		StorageService storageService = (StorageService) appContext.getBean("fileSystemStorageService");

		try {

			this.writerDao.insertUserAccount(userAccount);// 注册账号
			this.writerDao.insertTeacher(teacher);// 插入教师基本信息

			// 当前时间--目录名
			String dirTimeName = WriterUtils.getTimeName();
			// 创建对应的文件目录
			storageService.init(new StringBuilder().append(WriterUtils.getRealPath(request)).append("/images/")
					.append(teacher.getPhoneNumber()).append("/certificate/").append(dirTimeName).toString());

			List<QualificationCertificate> qualificationCertificateList = new ArrayList<QualificationCertificate>();
			// 文件上传
			for (MultipartFile file : files) {

				QualificationCertificate qualificationCertificate = new QualificationCertificate();

				storageService.store(file);

				// logger.info(new
				// StringBuilder().append(WriterUtils.getContextPath(request)).append("/images/")
				// .append(teacher.getPhoneNumber()).append("/").append(file.getOriginalFilename()).toString());

				qualificationCertificate.setUuid(UUID.randomUUID().toString());
				qualificationCertificate.setPhoneNumber(teacher.getPhoneNumber());
				qualificationCertificate.setCertificateName(file.getName());
				qualificationCertificate
						.setCertificatePathView(new StringBuilder().append(WriterUtils.getContextPath(request))
								.append("/images/").append(teacher.getPhoneNumber()).append("/certificate/")
								.append(dirTimeName).append("/").append(file.getOriginalFilename()).toString());
				qualificationCertificate.setCertificatePathDownload(new StringBuilder()
						.append(WriterUtils.getContextPath(request)).append("/writer/download/")
						.append(teacher.getPhoneNumber()).append("/").append(file.getOriginalFilename()).toString());

				qualificationCertificateList.add(qualificationCertificate);
			}

			/**
			 * 维护证书信息
			 */
			if (qualificationCertificateList != null && qualificationCertificateList.size() > 0) {

				this.writerDao.insertQualificationCertificates(qualificationCertificateList);// 批量插入证书
			}

			// 添加钱包账号

			Wallet wallet = new Wallet();
			wallet.setUuid(UUID.randomUUID().toString());
			wallet.setPhoneNumber(teacher.getPhoneNumber());
			wallet.setAmount(Float.valueOf("0.0"));
			this.writerDao.addWallet(wallet);

			// 注册结果提示信息
			registerResult.setFlag("success");
			registerResult.setMsg("注册成功");
		} catch (Exception ex) {
			logger.error("----------教师用户注册失败-------------");
			logger.error("错误信息:" + ex.getMessage());
			logger.error("错误原因：" + ex.getCause());

			throw new WriterException(ex.getMessage());
		}

		return registerResult;

	}

	@Override
	public LoginResult LoginWithUNameAndPass(LoginM loginM) {
		LoginResult loginResult = new LoginResult();

		try {
			LoginUserInfoM loginUserInfoM = this.writerDao.queryUserByUNameAndPass(loginM);

			if (loginUserInfoM != null) {

				loginResult.setLoginUserInfoM(loginUserInfoM);
				loginResult.setFlag("success");
				loginResult.setMsg("登录成功");
			} else {
				loginResult.setFlag("failed");
				loginResult.setMsg("登录失败");
			}

		} catch (WriterException e) {

			logger.error("-------------登录异常------------");
			logger.error("错误信息:" + e.getMessage());
			logger.error("错误原因：" + e.getCause());

			loginResult.setFlag("failed");
			loginResult.setLoginUserInfoM(null);
			loginResult.setMsg(e.getMessage());
		}

		return loginResult;
	}

	/**
	 * 提交作品
	 */

	@Override
	@Transactional
	public SubmitWorksResult submitWorks(AgentList agentList, Works works, CostInfo costInfo, MultipartFile[] files,
			HttpServletRequest request) throws WriterException {

		SubmitWorksResult submitWorksResult = new SubmitWorksResult();

		try {
			// 插入代办
			String uuid_agent_list = UUID.randomUUID().toString();

			agentList.setUuid(uuid_agent_list);

			if (agentList.getSubmitTime() == null || agentList.getSubmitTime().trim().length() == 0) {

				agentList.setSubmitTime(WriterUtils.getCurrentTime());

			}

			this.writerDao.insertAgentList(agentList);
			// 插入作品
			// 获取操作文件的BEAN
			StorageService storageService = (StorageService) appContext.getBean("fileSystemStorageService");

			// 创建对应的文件目录

			String dirTimeName = WriterUtils.getTimeName();

			storageService.init(new StringBuilder().append(WriterUtils.getRealPath(request)).append("/images/")
					.append(works.getPhoneNumber()).append("/works/").append(dirTimeName).toString());

			java.util.List<Works> worksList = new ArrayList<Works>();

			for (MultipartFile file : files) {

				Works work = new Works();

				work.setPhoneNumber(works.getPhoneNumber());

				work.setUuid(UUID.randomUUID().toString());

				work.setTitle(works.getTitle());

				if (works.getCreationTime() == null || works.getCreationTime().trim().length() == 0) {
					work.setCreationTime(WriterUtils.getCurrentTime());
				} else {
					work.setCreationTime(works.getCreationTime());
				}

				work.setIsItOpen(works.getIsItOpen());

				work.setAgentListUuid(uuid_agent_list);

				storageService.store(file);

				String imageContentPath = new StringBuilder().append(WriterUtils.getContextPath(request))
						.append("/images/").append(works.getPhoneNumber()).append("/works/").append(dirTimeName)
						.append("/").append(file.getOriginalFilename()).toString();

				work.setImageContentPath(imageContentPath);

				worksList.add(work);

			}

			this.writerDao.insertWorks(worksList);

			// 插入缴费记录
			costInfo.setUuid(UUID.randomUUID().toString());
			costInfo.setWorksListUuid(uuid_agent_list);
			if (costInfo.getTimeOfOccurrence() == null || costInfo.getTimeOfOccurrence().trim().length() == 0) {

				costInfo.setTimeOfOccurrence(WriterUtils.getCurrentTime());

			}

			this.writerDao.insertCostInfo(costInfo);

			submitWorksResult.setFlag("success");
			submitWorksResult.setMsg("提交成功");

		} catch (Exception e) {

			logger.error("-------------提交作品失败------------");
			logger.error("错误信息:" + e.getMessage());
			logger.error("错误原因：" + e.getCause());

			throw new WriterException(e.getMessage());
		}

		return submitWorksResult;
	}

	@Override
	public AgentResultM findAgentListByAgentStaff(AgentQueryConditionsM agentQueryConditionsM) throws WriterException {

		AgentResultM agentResultM = new AgentResultM();

		try {
			List<AgentM> agentMList = new ArrayList<AgentM>();
			agentMList = this.writerDao.findAgentListByAgentStaff(agentQueryConditionsM);

			if (agentMList != null && agentMList.size() > 0) {
				agentResultM.setAgentMList(agentMList);
				agentResultM.setFalg("success");
				agentResultM.setMsg("成功获取代办");
			} else {
				agentResultM.setAgentMList(null);
				agentResultM.setFalg("success");
				agentResultM.setMsg("无代办");
			}
		} catch (Exception e) {

			logger.error("--------获取代办报错-----------");
			logger.error("错误信息：" + e.getMessage());
			logger.error("错误原因：" + e.getCause());

			agentResultM.setAgentMList(null);
			agentResultM.setFalg("failed");
			agentResultM.setMsg(e.getMessage());
		}

		return agentResultM;
	}

	/**
	 * 根据代办ID查询代办详情
	 */

	@Override
	public AgentSingleM findAgentInfoByUUID(String agentUUID) {

		AgentSingleM agentSingleM = new AgentSingleM();

		try {
			AgentM agentM = this.writerDao.findAgentInfoByUUID(agentUUID);

			if (agentM != null) {

				agentSingleM.setAgentM(agentM);
				agentSingleM.setFalg("success");
				agentSingleM.setMsg("成功获取代办详情");

			} else {
				agentSingleM.setAgentM(null);
				agentSingleM.setFalg("success");
				agentSingleM.setMsg("未查询到代办详情(制定的代办UUID不存在)");
			}

		} catch (WriterException e) {

			logger.error("-------------查询代办详情失败------------");
			logger.error("错误信息:" + e.getMessage());
			logger.error("错误原因：" + e.getCause());

			agentSingleM.setFalg("failed");
			agentSingleM.setMsg(e.getMessage());

		}

		return agentSingleM;
	}

	/**
	 * 保存评阅结果
	 */
	@Override
	@Transactional
	public SaveChangeResultM saveChangeTheResult(ChangeTheResult changeTheResult, MultipartFile[] files,
			HttpServletRequest request) throws WriterException {

		SaveChangeResultM saveChangeResultM = new SaveChangeResultM();

		try {
			// 保存评阅结果
			changeTheResult.setUuid(UUID.randomUUID().toString());
			this.writerDao.insertChangeResult(changeTheResult);

			// 将代办设置为 已评阅

			this.writerDao.updateAgentEvaluationStatusByUUID(changeTheResult.getAgentListUuid());

			// 保存评阅结果 图片

			// 获取操作文件的BEAN
			StorageService storageService = (StorageService) appContext.getBean("fileSystemStorageService");

			// 创建对应的文件目录

			String dirName = WriterUtils.getTimeName();

			storageService.init(new StringBuilder().append(WriterUtils.getRealPath(request)).append("/images/")
					.append(changeTheResult.getDealer()).append("/approved/").append(dirName).toString());

			java.util.List<ApprovedWorks> approvedWorksList = new ArrayList<ApprovedWorks>();
			for (MultipartFile file : files) {

				ApprovedWorks approvedWorks = new ApprovedWorks();

				approvedWorks.setUuid(UUID.randomUUID().toString());

				approvedWorks.setAgentListUuid(changeTheResult.getAgentListUuid());

				approvedWorks.setApprovedTime(changeTheResult.getDealTime());

				storageService.store(file);

				String imagePath = new StringBuilder().append(WriterUtils.getContextPath(request)).append("/images/")
						.append(changeTheResult.getDealer()).append("/approved/").append(dirName).append("/")
						.append(file.getOriginalFilename()).toString();

				approvedWorks.setImagePath(imagePath);

				approvedWorksList.add(approvedWorks);
			}

			this.writerDao.insertApprovedWorks(approvedWorksList);

			saveChangeResultM.setFlag("success");
			saveChangeResultM.setMsg("作品评阅成功");

		} catch (Exception e) {

			logger.error("----------评阅结果保存失败-----------");
			logger.error("错误信息：" + e.getMessage());
			logger.error("错误原因：" + e.getCause());

			throw new WriterException(e.getMessage());

		}

		return saveChangeResultM;
	}

	/**
	 * 我的作品
	 */

	@Override
	public MyWorksResultM acquireMyWorks(String phoneNumber) {

		MyWorksResultM MyWorksResultM = new MyWorksResultM();

		try {
			List<MyWorksM> myWorksMList = this.writerDao.findMyWorksBYPhoneNum(phoneNumber);

			if (myWorksMList != null && myWorksMList.size() > 0) {
				MyWorksResultM.setFlag("success");
				MyWorksResultM.setMsg("成功获取我的作品");
				MyWorksResultM.setMyWorksMList(myWorksMList);
			} else {
				MyWorksResultM.setFlag("success");
				MyWorksResultM.setMsg("未查询到我的作品");
				MyWorksResultM.setMyWorksMList(null);
			}

		} catch (WriterException e) {

			logger.error("---------获取我的作品失败-------------");
			logger.error("错误信息：" + e.getMessage());
			logger.error("错误原因：" + e.getCause());
			MyWorksResultM.setFlag("failed");
			MyWorksResultM.setMsg(e.getMessage());
			MyWorksResultM.setMyWorksMList(null);
		}

		return MyWorksResultM;
	}

	/**
	 * 单个作品详情
	 */

	@Override
	public MySingleWorksResultM acquireMySingleWorks(String agentUUID) {

		MySingleWorksResultM mySingleWorksResultM = new MySingleWorksResultM();

		try {
			MyWorksM myWorksM = this.writerDao.findMySingleWorksInfo(agentUUID);

			if (myWorksM != null) {

				mySingleWorksResultM.setMyWorksM(myWorksM);
				mySingleWorksResultM.setFlag("success");
				mySingleWorksResultM.setMsg("单个作品详情查询成功");

			} else {
				mySingleWorksResultM.setMyWorksM(null);
				mySingleWorksResultM.setFlag("success");
				mySingleWorksResultM.setMsg("查询的作品不存在");
			}

		} catch (WriterException e) {

			mySingleWorksResultM.setFlag("failed");
			mySingleWorksResultM.setMsg(e.getMessage());
			mySingleWorksResultM.setMyWorksM(null);

			logger.equals("-----------单个作品详情查询失败------------");
			logger.error("错误信息:" + e.getMessage());
			logger.error("错误原因:" + e.getCause());

		}

		return mySingleWorksResultM;
	}

	/**
	 * 教师列表
	 */

	@Override
	public TeacherResultListM acquireTeacherList(TeacherQueryConditionsM teacherQueryConditionsM) {

		TeacherResultListM teacherResultListM = new TeacherResultListM();

		try {
			List<TeacherM> teacherMList = this.writerDao.findTeacherInfoList(teacherQueryConditionsM);

			if (teacherMList != null && teacherMList.size() > 0) {
				teacherResultListM.setTeacherMList(teacherMList);
				teacherResultListM.setFlag("success");
				teacherResultListM.setMsg("成功获取教师列表");
			} else {
				teacherResultListM.setTeacherMList(null);
				teacherResultListM.setFlag("success");
				teacherResultListM.setMsg("未查询到教师信息");
			}

		} catch (WriterException e) {

			logger.error("-------------查询教师信息失败------------");
			logger.error("错误信息:" + e.getMessage());
			logger.error("错误原因：" + e.getCause());

			teacherResultListM.setTeacherMList(null);
			teacherResultListM.setFlag("failed");
			teacherResultListM.setMsg(e.getMessage());
		}

		return teacherResultListM;
	}

	/**
	 * 基本信息
	 */

	@Override
	public StudentInfoM acquireStudent(String phoneNumber) {

		StudentInfoM studentInfoM = new StudentInfoM();

		try {
			StudentInfo studentInfo = new StudentInfo();
			studentInfo = this.writerDao.findStudentInfoByPhoneNumber(phoneNumber);

			if (studentInfo != null) {

				studentInfoM.setStudentInfo(studentInfo);
				studentInfoM.setFlag("success");
				studentInfoM.setMsg("成功获取学生信息");
			} else {
				studentInfoM.setStudentInfo(null);
				studentInfoM.setFlag("success");
				studentInfoM.setMsg("不存在，未查询到。");
			}

		} catch (WriterException e) {

			logger.error("-------------查询学生基本信息失败------------");
			logger.error("错误信息:" + e.getMessage());
			logger.error("错误原因：" + e.getCause());

			studentInfoM.setStudentInfo(null);
			studentInfoM.setFlag("failed");
			studentInfoM.setMsg(e.getMessage());
		}

		return studentInfoM;

	}

	@Override
	@Transactional
	public ReceiveFeeRecordResultM receiveFee(ReceiveFeeRecord receiveFeeRecord) {

		ReceiveFeeRecordResultM receiveFeeRecordResultM = new ReceiveFeeRecordResultM();
		try {
			// 新增费用领取记录
			receiveFeeRecord.setUuid(UUID.randomUUID().toString());
			this.writerDao.insertReceiveFeeRecord(receiveFeeRecord);

			// 增加钱包金额
			this.writerDao.addWalletMoney(receiveFeeRecord);

			// 修改已办任务的费用领取状态
			this.writerDao.updateAgentReceiveTheFeeStaus(receiveFeeRecord.getWorksListUuid());

			receiveFeeRecordResultM.setFlag("success");
			receiveFeeRecordResultM.setMsg("费用领取成功");
		} catch (WriterException e) {

			logger.error("-------------费用领取失败------------");
			logger.error("错误信息:" + e.getMessage());
			logger.error("错误原因：" + e.getCause());

			receiveFeeRecordResultM.setFlag("failed");
			receiveFeeRecordResultM.setMsg("费用领取失败");
		}

		return receiveFeeRecordResultM;
	}

	/**
	 * 我的钱包
	 */

	@Override
	public WalletResultM receiveMyWalletInfo(String phoneNumber) {

		WalletResultM walletResultM = new WalletResultM();

		try {
			WalletM walletM = this.writerDao.findMyWalletInfo(phoneNumber);

			if (walletM != null) {

				walletResultM.setWalletM(walletM);
				walletResultM.setFalg("success");
				walletResultM.setMsg("查询我的钱包成功");

			} else {
				walletResultM.setWalletM(null);
				walletResultM.setFalg("success");
				walletResultM.setMsg("未查询到我的钱包");
			}

		} catch (WriterException e) {

			logger.error("-------------查询我的钱包失败------------");
			logger.error("错误信息:" + e.getMessage());
			logger.error("错误原因：" + e.getCause());
			
			walletResultM.setWalletM(null);
			walletResultM.setFalg("failed");
			walletResultM.setMsg(e.getMessage());
		}

		return walletResultM;
	}

	public WriterDao getWriterDao() {
		return writerDao;
	}

	@Autowired
	@Required
	public void setWriterDao(@Qualifier("defaultWriterDao") WriterDao writerDao) {
		this.writerDao = writerDao;
	}

}
