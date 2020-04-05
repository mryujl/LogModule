package com.mryujl.thread;

public class ThreadDownloader extends Thread {
	private String url;//Ô¶³ÌÂ·¾¶
	private String name;//´æ´¢Ãû×Ö
	
	public ThreadDownloader(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}

	@Override
	public void run() {
		WebDownloader wd = new WebDownloader();
		wd.download(url, name);
		System.out.println(name);
	}
}
