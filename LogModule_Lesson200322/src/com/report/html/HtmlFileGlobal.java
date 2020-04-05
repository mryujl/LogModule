package com.report.html;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class HtmlFileGlobal {

	private static Logger logger = Logger.getLogger(HtmlFileGlobal.class.getName());
	private static FileHandler fileHTML;

	public static void createLog(String p_logName) {
		try {
			fileHTML = new FileHandler(p_logName);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		fileHTML.setFormatter(new HtmlReportFormatter());
		logger.addHandler(fileHTML);
	}

	public static void closeLog() {
		fileHTML.close();
		RecordStore.p_pass = 0;
		RecordStore.p_fail = 0;
		RecordStore.result = "";
		RecordStore.expected = "";
		RecordStore.actual = "";
	}

	public static void write(String p_info, String p_expected, String p_actual) {
		RecordStore.actual = p_actual;
		RecordStore.expected = p_expected;
		if (p_expected.equals(p_actual)) {
			RecordStore.result = "Pass";
		}else {
			RecordStore.result = "Fail";
		}
		try {
			logger.info(p_info);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("logger write exception!");
		}
	}

	public static void write(String p_info, Boolean p_expected,Boolean p_actual) {
		RecordStore.actual = p_actual;
		RecordStore.expected = p_expected;
		if (p_expected == p_actual) {
			RecordStore.result = "Pass";
		}else{
			RecordStore.result = "Fail";
		}
		try {
			logger.info(p_info);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("logger write exception!");
		}
	}
	
	public static void write(String p_info) {
		try {
			logger.info(p_info);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("logger write exception!");
		}
	}
	
}
