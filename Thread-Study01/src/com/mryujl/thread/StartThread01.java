package com.mryujl.thread;

/**
 * 创建线程方式一： 
 * 1、创建：继承Thread+重写run
 * 2、启动：创建子类对象+start
 * @author Administrator
 *
 */
public class StartThread01 extends Thread {

	public static void main(String[] args) {
		// 创建
		StartThread01 thread = new StartThread01();
		// 启动
//		thread.start();//不保证立即运行，由CPU调用
		thread.run();//普通方法调用
		for (int i = 0; i < 10; i++) {
			System.out.println("一边敲代码");
		}
	}
	/**
	 * 线程入口點
	 */
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("一边听课");
		}
	}
}
