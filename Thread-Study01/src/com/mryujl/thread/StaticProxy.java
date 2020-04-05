package com.mryujl.thread;

/**
 * 静态代理
 * 公共接口：
 * 1、真实角色
 * 2、代理角色
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
// 真实角色
class You implements Marry{

	@Override
	public void happyMarry() {
		System.out.println("You and Chang'e fly to moon.");
		
	}
	
}
// 代理角色
class WeddingCompany implements Marry{
	// 真实角色
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
		System.out.println("布置猪窝。。。");
	}
	
	private void after() {
		System.out.println("闹玉兔。。。");
	}
}
