package com.mryujl.thread;

/**
 * ģ���������
 * 
 * @author Administrator
 *
 */
public class Racer implements Runnable {
	private static String winner;// ʤ����

	@Override
	public void run() {
		for (int steps = 1; steps <= 100; steps++) {
			if (Thread.currentThread().getName().equals("rabbit") && steps % 10 == 0) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "--->" + steps++);
			boolean flag = gameOver(steps);
			if (flag) {
				break;
			}
		}
	}

	private boolean gameOver(int steps) {
		if (winner != null) {// ����ʤ����
			return true;
		} else {
			if (steps == 100) {
				winner = Thread.currentThread().getName();
				System.out.println("winner==>" + winner);
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Racer racer = new Racer();
		new Thread(racer, "tortise").start();
		new Thread(racer, "rabbit").start();
	}
}
