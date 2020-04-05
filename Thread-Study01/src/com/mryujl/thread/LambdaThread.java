package com.mryujl.thread;

/**
 * Lambda���ʽ ���̣߳���һ�Σ���ʹ��
 * �ݻ����̣��ⲿ��-->��̬�ڲ���-->�ֲ�(����)�ڲ���-->�����ڲ���-->lambda���ʽ(jkd8��)
 * @author Administrator
 *
 */
public class LambdaThread {
	// ��̬�ڲ���
	static class Test implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 15; i++) {
				System.out.println("һ��coding");
			}
		}
	}

	public static void main(String[] args) {

		// �ֲ��ڲ���
		class Test2 implements Runnable {
			@Override
			public void run() {
				for (int i = 0; i < 15; i++) {
					System.out.println("һ��coding");
				}
			}
		}
		new Thread(new Test2()).start();

		// �����ڲ��� ��������ӿڻ��߸���
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 15; i++) {
					System.out.println("һ�߳���");
				}
			}
		}).start();

		// jkd8�� lambda
		new Thread(() -> {
			for (int i = 0; i < 15; i++) {
				System.out.println("һ�߳���");
			}
		}).start();

	}
}
