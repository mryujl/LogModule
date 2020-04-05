package com.mryujl.thread;

/**
 * Lambda表达式 简化线程（用一次）的使用
 * 演化过程：外部类-->静态内部类-->局部(方法)内部类-->匿名内部类-->lambda表达式(jkd8简化)
 * @author Administrator
 *
 */
public class LambdaThread {
	// 静态内部类
	static class Test implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 15; i++) {
				System.out.println("一边coding");
			}
		}
	}

	public static void main(String[] args) {

		// 局部内部类
		class Test2 implements Runnable {
			@Override
			public void run() {
				for (int i = 0; i < 15; i++) {
					System.out.println("一边coding");
				}
			}
		}
		new Thread(new Test2()).start();

		// 匿名内部类 必须借助接口或者父类
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 15; i++) {
					System.out.println("一边唱歌");
				}
			}
		}).start();

		// jkd8简化 lambda
		new Thread(() -> {
			for (int i = 0; i < 15; i++) {
				System.out.println("一边唱歌");
			}
		}).start();

	}
}
