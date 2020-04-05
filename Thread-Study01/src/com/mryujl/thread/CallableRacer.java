package com.mryujl.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * ģ���������
 * 
 * @author Administrator
 *
 */
public class CallableRacer implements Callable<Integer> {
	private static String winner;// ʤ����

	@Override
	public Integer call() throws Exception {
		for (int steps = 1; steps <= 100; steps++) {
			if (Thread.currentThread().getName().equals("pool-1-thread-1") && steps % 10 == 0) {
				Thread.sleep(200);
			}
			System.out.println(Thread.currentThread().getName() + "--->" + steps++);
			boolean flag = gameOver(steps);
			if (flag) {
				return steps;
			}
		}
		return null;
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
		CallableRacer racer = new CallableRacer();

		// ����ִ�з���
		ExecutorService ser = Executors.newFixedThreadPool(2);
		// �ύִ��
		FutureTask<Integer> result1 = (FutureTask<Integer>) ser.submit(racer);
		FutureTask<Integer> result2 = (FutureTask<Integer>) ser.submit(racer);
		// ��ȡ���
		try {
			Integer r1 = result1.get();
			Integer r2 = result2.get();
			System.out.println(r1);
			System.out.println(r2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		// �رշ���
		ser.shutdownNow();
	}
}
