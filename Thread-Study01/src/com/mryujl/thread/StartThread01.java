package com.mryujl.thread;

/**
 * �����̷߳�ʽһ�� 
 * 1���������̳�Thread+��дrun
 * 2�������������������+start
 * @author Administrator
 *
 */
public class StartThread01 extends Thread {

	public static void main(String[] args) {
		// ����
		StartThread01 thread = new StartThread01();
		// ����
//		thread.start();//����֤�������У���CPU����
		thread.run();//��ͨ��������
		for (int i = 0; i < 10; i++) {
			System.out.println("һ���ô���");
		}
	}
	/**
	 * �߳�����c
	 */
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("һ������");
		}
	}
}
