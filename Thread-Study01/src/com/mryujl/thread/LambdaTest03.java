package com.mryujl.thread;

/**
 * lambda推导 加入参数 带返回值的
 * 
 * @author Administrator
 *
 */
public class LambdaTest03 {

	public static void main(String[] args) {
		IInterest interest = new Interest();
		interest.lambda(3, 4);
		
		interest = (int a,int b)->{
			System.out.println("i like lambda2-->" + (a + b));
			return a + b;
		};
		interest.lambda(20, 30);
		
		interest = (a,b)->{
			System.out.println("i like lambda3-->" + (a + b));
			return a + b;
		};
		interest.lambda(40, 30);
		
		interest = (a,b)-> a + b;
		interest = (a,c)-> 100;
		System.out.println(interest.lambda(100, 290));
	}
}

interface IInterest {
	int lambda(int a, int b);
}

// 外部类
class Interest implements IInterest {

	@Override
	public int lambda(int a, int c) {
		System.out.println("i like lambda-->" + (a + c));
		return a + c;
	}

}