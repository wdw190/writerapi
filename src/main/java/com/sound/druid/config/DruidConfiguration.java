//package com.sound.druid.config;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
//
//@Configuration
//public class DruidConfiguration {
//
//	private static final Logger log = LoggerFactory.getLogger(DruidConfiguration.class);
//
//	/**
//	 * Druid的内置监控页面
//	 * 
//	 * @return
//	 */
//	@Bean
//	public ServletRegistrationBean druidServlet() {
//		log.info("init Druid Servlet Configuration ");
//		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
//		servletRegistrationBean.setServlet(new StatViewServlet());
//		servletRegistrationBean.addUrlMappings("/druid/*");
//		Map<String, String> initParameters = new HashMap<String, String>();
//		initParameters.put("loginUsername", "admin");// 用户名
//		initParameters.put("loginPassword", "admin");// 密码
//		initParameters.put("resetEnable", "false");// 禁用HTML页面上的“Reset All”功能
//		initParameters.put("allow", ""); // IP白名单 (没有配置或者为空，则允许所有访问)
//		// initParameters.put("deny", "192.168.20.38");// IP黑名单
//		// (存在共同时，deny优先于allow)
//		servletRegistrationBean.setInitParameters(initParameters);
//		return servletRegistrationBean;
//	}
//
//	/**
//	 * WebStatFilter用于采集web-jdbc关联监控的数据。
//	 * 
//	 * @return
//	 */
//	@Bean
//	public FilterRegistrationBean filterRegistrationBean() {
//		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//		filterRegistrationBean.setFilter(new WebStatFilter());
//		filterRegistrationBean.addUrlPatterns("/*");
//		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//		//filterRegistrationBean.addInitParameter("profileEnable", "true");
//		
//		filterRegistrationBean.addInitParameter("principalSessionName", "currentusername");
//		return filterRegistrationBean;
//	}
//
//}
