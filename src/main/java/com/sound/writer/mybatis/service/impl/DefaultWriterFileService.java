package com.sound.writer.mybatis.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sound.writer.mybatis.dao.WriterDao;
import com.sound.writer.mybatis.service.RegisterResult;
import com.sound.writer.mybatis.service.WriterFileService;
import com.sound.writer.pojo.QualificationCertificate;
import com.sound.writer.storage.StorageService;
import com.sound.writer.utils.WriterUtils;

@Service("defaultWriterFileService")
public class DefaultWriterFileService implements WriterFileService {

	private static Logger logger = LogManager.getLogger(DefaultWriterFileService.class);

	@Autowired
	private ApplicationContext appContext;
	
	private WriterDao writerDao; 

	@Override
	public ResponseEntity<Resource> downloadFile(String phonenumber, String filename, HttpServletRequest request) {

		// 获取操作文件的BEAN
		StorageService storageService = (StorageService) appContext.getBean("fileSystemStorageService");

		logger.info("download:" + new StringBuilder().append(WriterUtils.getRealPath(request)).append("/images/")
				.append(phonenumber).toString());
		logger.info("filename:" + filename);
		// 初始化文件目录
		storageService.init(new StringBuilder().append(WriterUtils.getRealPath(request)).append("/images/")
				.append(phonenumber).toString());
		// 加载文件
		Resource file = storageService.loadAsResource(filename);
		// 返回
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	@Override
	public RegisterResult uploadFiles(String phoneNumber, MultipartFile[] files, HttpServletRequest request) {

		RegisterResult registerResult = new RegisterResult();

		//logger.info("phoneNumber=" + phoneNumber);

		// 获取操作文件的BEAN
		StorageService storageService = (StorageService) appContext.getBean("fileSystemStorageService");

		// 初始化文件目录
		storageService.init(new StringBuilder().append(WriterUtils.getRealPath(request)).append("/images/")
				.append(phoneNumber).toString());

//		for (MultipartFile file : files) {
//			try {
//				storageService.store(file);
//			} catch (Exception e) {
//
//				logger.info(new StringBuilder("文件上传失败:").append(file.getOriginalFilename()).append(" 用户：").append(phoneNumber).toString());
//				logger.info(e.getMessage());
//
//			}
//		}
		
		List<QualificationCertificate> qualificationCertificateList = new ArrayList<QualificationCertificate>();
		// 文件上传
		for (MultipartFile file : files) {

			QualificationCertificate qualificationCertificate = new QualificationCertificate();

			storageService.store(file);

			logger.info(new StringBuilder().append(WriterUtils.getContextPath(request)).append("/images/")
					.append(phoneNumber).append("/").append(file.getOriginalFilename()).toString());

			qualificationCertificate.setUuid(UUID.randomUUID().toString());
			qualificationCertificate.setPhoneNumber(phoneNumber);
			qualificationCertificate.setCertificateName(file.getName());
			qualificationCertificate.setCertificatePathView(new StringBuilder()
					.append(WriterUtils.getContextPath(request)).append("/images/").append(phoneNumber)
					.append("/").append(file.getOriginalFilename()).toString());
			qualificationCertificate.setCertificatePathDownload(new StringBuilder()
					.append(WriterUtils.getContextPath(request)).append("/writer/download/")
					.append(phoneNumber).append("/").append(file.getOriginalFilename()).toString());

			qualificationCertificateList.add(qualificationCertificate);
		}

		/**
		 * 维护证书信息
		 */
		if (qualificationCertificateList != null && qualificationCertificateList.size() > 0) {

			this.writerDao.insertQualificationCertificates(qualificationCertificateList);//批量插入证书
		}

		registerResult.setFlag("success");
		registerResult.setMsg("上传成功");

		return registerResult;
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
