package com.mryujl.thread;
/**
 * lambda推导
 * 演化过程：外部类-->静态内部类-->局部(方法)内部类-->匿名内部类-->lambda表达式(jkd8简化)
 * @author Administrator
 *
 */
public class LambdaTest01 {
	// 静态内部类
	static class Like2 implements ILike{
		@Override
		public void lambda() {
			System.out.println("i like lambda2");
		}
	}
	
	public static void main(String[] args) {
		ILike like = new Like();
		like.lambda();

		like = new Like2();
		like.lambda();
		
		// 方法内部类
		class Like3 implements ILike{
			@Override
			public void lambda() {
				System.out.println("i like lambda3");
			}
		}
		
		like = new Like3();
		like.lambda();
		
		// 匿名内部类
		like = new ILike() {
			@Override
			public void lambda() {
				System.out.println("i like lambda4");
			}
		};
		like.lambda();
		
		// lambda表达式
		like = () ->{
			System.out.println("i like lambda5");
		};
		like.lambda();
	}
}
interface ILike{
	void lambda();
}
// 外部类
class Like implements ILike{

	@Override
	public void lambda() {
		System.out.println("i like lambda");
	}
	
}