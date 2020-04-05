package com.my.testcase;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Suite;
import org.junit.runners.Parameterized.Parameters;
import com.report.html.HtmlFile;

/**
 * HtmlFile hf=new HtmlFile();
		hf.createLog("d:\\test11.html");
		hf.write("测试用例1校验方法func1", "ok",func1());
		hf.write("测试用例2","ok","not ok");
		hf.write("测试用例3","ok","not ok");
		hf.closeLog();
 * @author Administrator
 *
 */

//@RunWith(Parameterized.class)
public class TestParam2 {

	boolean b_expect;
	boolean b_actual;
	String s_expect;
	String s_actual;
	
	HtmlFile hf=new HtmlFile();
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void test1() {
//		@RunWith(Suite.class)
		@Suite.SuiteClasses({
			BaiduSearch.class,
			OpenUrl.class
		}) class TestSuite {
			
		}
	}
	
	public int add(int a, int b) {
		return a + b;
	}
	
//	@SuppressWarnings("rawtypes")
//	@Parameters
//	public static Collection Data() {
//		return Arrays.asList(new Object[][] {
//			{1, 2, 3},
//			{3, 2, 5},
//			{21, 22, 43},
//			{31, 32, 63},
//			{51, 25, 76},
//		});
//	}
	
}
