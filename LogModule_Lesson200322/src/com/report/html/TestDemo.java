package com.report.html;

public class TestDemo {
	
	public static String func1(){
		return "OK";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HtmlFile hf=new HtmlFile();
		hf.createLog("d:\\test11.html");
		hf.write("测试用例1校验方法func1", "ok",func1());
		hf.write("测试用例2","ok","not ok");
		hf.write("测试用例3","ok","not ok");
		hf.closeLog();
		
		

	}

}
