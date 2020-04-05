package com.report.html;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.report.html.HtmlFileGlobal;


public class TestCase2 {
	
	
	
	@BeforeClass
	public static void init(){
		
	}
	@AfterClass
	public static void destory(){
		
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HtmlFileGlobal.write("case1","1","1");
		System.out.println("test case1");
		assertEquals("1","1");
		
	}
	
	@Test
	public void test2() {
		HtmlFileGlobal.write("case2","1","2");
		System.out.println("test case2");
		assertEquals("1","2");
		
	}
	
	
	@Test
	public void test3() {
		HtmlFileGlobal.write("case3","1","2");
		System.out.println("test case2");
		assertEquals("1","2");
		
	}


}