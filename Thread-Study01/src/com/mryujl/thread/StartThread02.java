package com.mryujl.thread;

/**
 * 创建线程方式二： 
 * 1、创建：继承Runnable+重写run
 * 2、启动：创建实现类对象+Thread类对象+start
 * @author Administrator
 *
 * 推荐：避免单继承的局限性，优先使用接口
 * 		方便共享资源
 */
public class StartThread02 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 15; i++) {
			System.out.println("一边coding");
		}
	}
	
	public static void main(String[] args) {
		// 创建实现类对象
//		StartThread02 st = new StartThread02();
//		// 创建代理类对象
//		Thread thread = new Thread(st);
//		// 启动
//		thread.start();
		new Thread(new StartThread02()).start();
		for (int i = 0; i < 15; i++) {
			System.out.println("一边玩手机");
		}
	}

}
