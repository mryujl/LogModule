package com.mryujl.thread;

/**
 * ��̬����
 * �����ӿڣ�
 * 1����ʵ��ɫ
 * 2�������ɫ
 * 
 * @author Administrator
 *
 */
public class StaticProxy {
	public static void main(String[] args) {
		new WeddingCompany(new You()).happyMarry();
		
		
	}
}

interface Marry{
	void happyMarry();
}
// ��ʵ��ɫ
class You implements Marry{

	@Override
	public void happyMarry() {
		System.out.println("You and Chang'e fly to moon.");
		
	}
	
}
// �����ɫ
class WeddingCompany implements Marry{
	// ��ʵ��ɫ
	private Marry target;
	
	public WeddingCompany(Marry target) {
		this.target = target;
	}
	
	@Override
	public void happyMarry() {
		ready();
		this.target.happyMarry();
		after();
	}
	
	private void ready() {
		System.out.println("�������ѡ�����");
	}
	
	private void after() {
		System.out.println("�����á�����");
	}
}
