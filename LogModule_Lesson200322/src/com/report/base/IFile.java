package com.report.base;

public interface IFile { //理论上每一个动作都应该创建一个接口，但是由于接口本身不是特别多，我统一写在一个接口中了

	void write(String p_info); //文件中写一句话
	void createLog(String p_info);
	void closeLog();
	void write(String p_info1,String p_info2); //例如properties文件，写key和value
	void write(String p_info1,String p_info2,String p_info3); //例如ini文件，写section，key和value
	void write(String p_info1,Boolean p_info2,Boolean p_info3);
	String read(); //读文件全部内容
	String read(String p_info);//读properties文件文件，通过key读value
	String read(String p_info1,String p_info2);//读ini文件，通过section、key读value
}
