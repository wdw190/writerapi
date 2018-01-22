package com.sound;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sound.writer.mybatis.dao.WriterDao;
import com.sound.writer.mybatis.exception.WriterException;
import com.sound.writer.mybatis.service.WriterService;
import com.sound.writer.pojo.LoginResult;
import com.sound.writer.pojo.MyWorksM;
import com.sound.writer.pojo.ReceiveFeeRecord;
import com.sound.writer.pojo.StudentInfo;
import com.sound.writer.pojo.Teacher;
import com.sound.writer.pojo.UserAccount;
import com.sound.writer.pojo.query.model.AgentM;
import com.sound.writer.pojo.query.model.AgentQueryConditionsM;
import com.sound.writer.pojo.query.model.AgentResultM;
import com.sound.writer.pojo.query.model.AgentSingleM;
import com.sound.writer.pojo.query.model.LoginM;
import com.sound.writer.pojo.query.model.MySingleWorksResultM;
import com.sound.writer.pojo.query.model.MyWorksResultM;
import com.sound.writer.pojo.query.model.ReceiveFeeRecordResultM;
import com.sound.writer.pojo.query.model.StudentInfoM;
import com.sound.writer.pojo.query.model.TeacherM;
import com.sound.writer.pojo.query.model.TeacherQueryConditionsM;
import com.sound.writer.pojo.query.model.TeacherResultListM;
import com.sound.writer.pojo.query.model.WalletResultM;
import com.sound.writer.utils.WriterUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WriterTest {

	private WriterDao writerDao;

	private WriterService writerService;

	@Test
	public void demo1() {

		UserAccount userAccount = new UserAccount();

		userAccount.setAccountType("student");
		userAccount.setPassword("123456");
		userAccount.setPhoneNumber("13787262392");
		userAccount.setRegisteredTime("2017-12-26 12:00:00");
		System.out.println("------------------------");

		try {
			this.writerDao.insertUserAccount(userAccount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("------------------------");

	}

	@Test
	public void demo3() {

		Teacher teacher = new Teacher();

		teacher.setAccountType("teacher");
		teacher.setIdentificationNumber("372625198604785366");
		teacher.setJobTitle(null);
		teacher.setName("王奥文");
		teacher.setPassword("123456");
		teacher.setPhoneNumber("13787262399");
		teacher.setRegisteredTime("2017-12-27 10:44:44");
		teacher.setSchoolName("实验中学");

		try {
			this.writerDao.insertTeacher(teacher);

			System.out.println("--------------------------成功");

		} catch (WriterException e) {
			System.out.println("--------------------------失败");
			e.printStackTrace();
		}

	}

	@Test
	public void demo4() {

		LoginM loginM = new LoginM();

		loginM.setPhoneNumber("13787262395");
		loginM.setPassword("123456");

		LoginResult loginResult = this.writerService.LoginWithUNameAndPass(loginM);
		System.out.println("---------------------------");
		System.out.println(loginResult.toString());
		System.out.println("--------------------------");

	}

	@Test
	public void demo5() {

		AgentQueryConditionsM agentQueryConditionsM = new AgentQueryConditionsM();

		agentQueryConditionsM.setAgentStaff("13787262394");
		agentQueryConditionsM.setEvaluationStatus("0");

		AgentResultM agentResultM = this.writerService.findAgentListByAgentStaff(agentQueryConditionsM);
		System.out.println("------------------------"+agentResultM.getFalg());
		for (AgentM agentM : agentResultM.getAgentMList()) {

			System.out.println(agentM.toString());

		}
		System.out.println("------------------------");

	}

	@Test
	public void demo6() {

		AgentM agentm = this.writerDao.findAgentInfoByUUID("c89e4423-14a6-4787-bf65-cd66c45ed9a7");
		System.out.println("------------------------");
		if (agentm == null) {

			System.out.println("-----------未查询到");

		} else {
			System.out.println(agentm.toString());
		}
		System.out.println("------------------------");
	}

	@Test
	public void demo7() {

		AgentSingleM agentSingleM = this.writerService.findAgentInfoByUUID("593e266d-e799-46b6-ab05-9a6659d723de");
		System.out.println("------------------------");

		System.out.println(agentSingleM.toString());

		System.out.println("------------------------");
	}

	@Test
	public void demo8() {
		System.out.println("------------------------");
		System.out.println(WriterUtils.getTimeName());
		System.out.println("------------------------");
	}

	@Test
	public void demo9() {

		List<MyWorksM> myWorksMList = this.writerDao.findMyWorksBYPhoneNum("13787262391");

		System.out.println("------------------------");

		for (MyWorksM myWorksM : myWorksMList) {

			System.out.println(myWorksM.toString());

			System.out.println("------------------------");
		}

		System.out.println("------------------------");

	}

	@Test
	public void demo10() {

		System.out.println("------------------------");

		MyWorksResultM myWorksResultM = this.writerService.acquireMyWorks("13548622929");
		System.out.println("------------------------");
		System.out.println(myWorksResultM.toString());

		System.out.println("------------------------");

	}

	@Test
	public void demo11() {

		MyWorksM myWorksM = this.writerDao.findMySingleWorksInfo("c89e4423-14a6-4787-bf65-cd66c45ed9a7");

		System.out.println("------------------------");

		System.out.println(myWorksM.toString());

		System.out.println("------------------------");

	}

	@Test
	public void demo12() {

		MySingleWorksResultM MySingleWorksResultM = this.writerService
				.acquireMySingleWorks("c89e4423-14a6-4787-bf65-cd66c45ed9a7");

		System.out.println("------------------------");

		System.out.println(MySingleWorksResultM.toString());

		System.out.println("------------------------");

	}

	@Test
	public void demo13() {

		TeacherQueryConditionsM teacherQueryConditionsM = new TeacherQueryConditionsM();

		teacherQueryConditionsM.setPhoneNumber("13787262392");
		// teacherQueryConditionsM.setJobTitle("高级教师");

		List<TeacherM> teacherMList = this.writerDao.findTeacherInfoList(teacherQueryConditionsM);

		for (TeacherM teacherM : teacherMList) {

			System.out.println("------------------------");
			System.out.println(teacherM.toString());
			System.out.println("------------------------");

		}

	}

	@Test
	public void demo14() {

		TeacherQueryConditionsM teacherQueryConditionsM = new TeacherQueryConditionsM();

		teacherQueryConditionsM.setPhoneNumber("1378726239222");

		teacherQueryConditionsM.setJobTitle("高级教师");

		TeacherResultListM teacherResultListM = this.writerService.acquireTeacherList(teacherQueryConditionsM);
		
		System.out.println("------------------------");
		System.out.println(teacherResultListM.toString());
		System.out.println("------------------------");

	}
	
	@Test
	public void demo15(){
		
		StudentInfo StudentInfo = this.writerDao.findStudentInfoByPhoneNumber("13787262391");
		System.out.println("------------------------");
		System.out.println(StudentInfo.toString());
		System.out.println("------------------------");
	}
	
	@Test
	public void demo16(){
		
		StudentInfoM studentInfoM = this.writerService.acquireStudent("13787262391");
		System.out.println("------------------------");
		System.out.println(studentInfoM.toString());
		System.out.println("------------------------");
	}
	
	@Test
	public void demo17(){
		ReceiveFeeRecord receiveFeeRecord = new ReceiveFeeRecord();
		receiveFeeRecord.setWorksListUuid("c89e4423-14a6-4787-bf65-cd66c45ed9a7");
		receiveFeeRecord.setRecipients("13787262392");
		receiveFeeRecord.setReceiveTime("2018-01-11 11:52:52");
		receiveFeeRecord.setReceiveTheAmount(Float.valueOf("180.0"));
		
		ReceiveFeeRecordResultM receiveFeeRecordResultM =this.writerService.receiveFee(receiveFeeRecord);
		System.out.println("------------------------");
		System.out.println(receiveFeeRecordResultM.toString());
		System.out.println("------------------------");
	}
	
	@Test
	public void demo18(){
		
		WalletResultM walletResultM = this.writerService.receiveMyWalletInfo("13787262392");
		
		System.out.println("------------------------");
		System.out.println(walletResultM.toString());
		System.out.println("------------------------");
		
	}

	public WriterDao getWriterDao() {
		return writerDao;
	}

	@Autowired
	@Required
	public void setWriterDao(@Qualifier("defaultWriterDao") WriterDao writerDao) {
		this.writerDao = writerDao;
	}

	public WriterService getWriterService() {
		return writerService;
	}

	@Autowired
	@Required
	public void setWriterService(@Qualifier("defaultWriterService") WriterService writerService) {
		this.writerService = writerService;
	}

}
