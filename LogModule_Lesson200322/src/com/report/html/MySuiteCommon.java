package com.report.html;

import com.report.html.HtmlFileGlobal;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;

public class MySuiteCommon {

	public static class TestSuite1 {
		public static Test suite() {

			// 这种是junit4兼容junit3用例的一个写法
			TestSuite suite = new TestSuite("Test for package1");
			suite.addTest(new JUnit4TestAdapter(TestCase2.class));
			suite.addTest(new JUnit4TestAdapter(TestCase3.class));

			return suite;
		}
	}

	public static void main(String[] args) throws Exception {
		// 加方法 自动化测试初始化
		HtmlFileGlobal.createLog("d:\\myReport4.html");
		junit.textui.TestRunner.run(TestSuite1.suite());
		HtmlFileGlobal.closeLog();
		// 加方法 报告整理
		// 加方法发送邮件

	}

}
