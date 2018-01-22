package com.sound.writer.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class WriterUtils {

	/**
	 * 获取上下文路径
	 * 
	 * @param request
	 * @return
	 */
	public static String getRealPath(HttpServletRequest request) {

		String path = request.getSession().getServletContext().getRealPath("/");

		if (path.endsWith("\\")) {
			path = path.replace("\\", "/");
			path = path.substring(0, path.length() - 1);
		}

		return path;

	}

	public static String getContextPath(HttpServletRequest request) {

		String contextPath = request.getSession().getServletContext().getContextPath();

		if (contextPath.endsWith("\\")) {
			contextPath = contextPath.replace("\\", "/");
			contextPath = contextPath.substring(0, contextPath.length() - 1);
		}

		return contextPath;

	}

	public static String getContextPath(HttpServletRequest request, String path) {

		ServletContext context = request.getSession().getServletContext().getContext(path);

		String contextPath = context.getContextPath();

		if (contextPath.endsWith("\\")) {
			contextPath = contextPath.replace("\\", "/");
			contextPath = contextPath.substring(0, contextPath.length() - 1);
		}

		return contextPath;

	}

	public static String getCurrentTime() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return sdf.format(new Date()).toString();

		
	}
	
	public static String getTimeName() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

		return sdf.format(new Date()).toString();

		
	}

}
