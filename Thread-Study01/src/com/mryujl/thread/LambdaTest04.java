package com.mryujl.thread;

/**
 * lambda�Ƶ� ������� ������ֵ��
 * lambda
 * ���������Ȳ��ඨ���^��
 * ��ʵ�����ں���ʽ��̵ĸ���
 * @author Administrator
 *
 */
public class LambdaTest04 {

	public static void main(String[] args) {
		new Thread(() -> {
			for (int i = 0; i <= 5; i++) {
				System.out.println("һ��ѧϰlambda������");
			}
		}).start();
		new Thread(() -> System.out.println("һ�߱����С�����")).start();
	}
}
