package com.mryujl.thread;

/**
 * lambda推导 加入参数 演化过程：外部类-->静态内部类-->局部(方法)内部类-->匿名内部类-->lambda表达式(jkd8简化)
 * 
 * @author Administrator
 *
 */
public class LambdaTest02 {
	// 静态内部类

	public static void main(String[] args) {
		ILove love = new Love();
		love.lambda(5);

		love = (int a) -> {
			System.out.println("i like lambda2-->" + a);
		};
		love.lambda(6);

		// 简化
		love = (a) -> {
			System.out.println("i like lambda3-->" + a);
		};
		love.lambda(60);

		// 继续简化
		love = a -> {
			System.out.println("i like lambda4-->" + a);
		};
		love.lambda(70);

		// 再继续简化
		love = a -> System.out.println("i like lambda5-->" + a);
		love.lambda(80);
	}
}

interface ILove {
	void lambda(int a);
}

// 外部类
class Love implements ILove {

	@Override
	public void lambda(int a) {
		System.out.println("i like lambda-->" + a);
	}

}