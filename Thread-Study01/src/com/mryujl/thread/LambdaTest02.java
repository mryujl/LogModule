package com.mryujl.thread;

/**
 * lambda�Ƶ� ������� �ݻ����̣��ⲿ��-->��̬�ڲ���-->�ֲ�(����)�ڲ���-->�����ڲ���-->lambda���ʽ(jkd8��)
 * 
 * @author Administrator
 *
 */
public class LambdaTest02 {
	// ��̬�ڲ���

	public static void main(String[] args) {
		ILove love = new Love();
		love.lambda(5);

		love = (int a) -> {
			System.out.println("i like lambda2-->" + a);
		};
		love.lambda(6);

		// ��
		love = (a) -> {
			System.out.println("i like lambda3-->" + a);
		};
		love.lambda(60);

		// ������
		love = a -> {
			System.out.println("i like lambda4-->" + a);
		};
		love.lambda(70);

		// �ټ�����
		love = a -> System.out.println("i like lambda5-->" + a);
		love.lambda(80);
	}
}

interface ILove {
	void lambda(int a);
}

// �ⲿ��
class Love implements ILove {

	@Override
	public void lambda(int a) {
		System.out.println("i like lambda-->" + a);
	}

}