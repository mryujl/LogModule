package com.mryujl.thread;

/**
 * �����̷߳�ʽ���� 
 * 1���������̳�Runnable+��дrun
 * 2������������ʵ�������+Thread�����+start
 * @author Administrator
 *
 * �Ƽ������ⵥ�̳еľ����ԣ�����ʹ�ýӿ�
 * 		���㹲����Դ
 */
public class StartThread02 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 15; i++) {
			System.out.println("һ��coding");
		}
	}
	
	public static void main(String[] args) {
		// ����ʵ�������
//		StartThread02 st = new StartThread02();
//		// �������������
//		Thread thread = new Thread(st);
//		// ����
//		thread.start();
		new Thread(new StartThread02()).start();
		for (int i = 0; i < 15; i++) {
			System.out.println("һ�����ֻ�");
		}
	}

}
