package com.mryujl.thread;

/**
 * lambda推导 加入参数 带返回值的
 * lambda
 * 避免匿名內部类定义過多
 * 其实质属于函数式编程的概念
 * @author Administrator
 *
 */
public class LambdaTest04 {

	public static void main(String[] args) {
		new Thread(() -> {
			for (int i = 0; i <= 5; i++) {
				System.out.println("一边学习lambda。。。");
			}
		}).start();
		new Thread(() -> System.out.println("一边崩溃中。。。")).start();
	}
}
