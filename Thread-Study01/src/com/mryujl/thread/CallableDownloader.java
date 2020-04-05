package com.mryujl.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * �˽�ʵ�ֶ��̵߳ķ�������
 * ʵ��callable�ӿ���дcall����
 * @author Administrator
 *
 */
public class CallableDownloader implements Callable<Boolean> {
	private String url;//Զ��·��
	private String name;//�洢����
	
	public CallableDownloader(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}

	@Override
	public Boolean call() throws Exception {
		WebDownloader wd = new WebDownloader();
		wd.download(url, name);
		System.out.println(name);
		return false;
	}

	public static void main(String[] args) {
		CallableDownloader td1 = new CallableDownloader("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2688721595,1840055009&fm=26&gp=0.jpg", "phone.jpg");
		CallableDownloader td2 = new CallableDownloader("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2265345458,1470507777&fm=26&gp=0.jpg", "phone2.jpg");
		CallableDownloader td3 = new CallableDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1585742282374&di=7090b88befc84bc661744f48fbded61c&imgtype=0&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D2146671969%2C27331522%26fm%3D214%26gp%3D0.jpg", "phone3.jpg");
		
		//����ִ�з���
		ExecutorService ser = Executors.newFixedThreadPool(1);
		// �ύִ��
		FutureTask<Boolean> result1 = (FutureTask<Boolean>) ser.submit(td1);
		FutureTask<Boolean> result2 = (FutureTask<Boolean>) ser.submit(td2);
		FutureTask<Boolean> result3 = (FutureTask<Boolean>) ser.submit(td3);
		// ��ȡ���
		try {
			boolean r1 = result1.get();
			boolean r2 = result2.get();
			boolean r3 = result3.get();
			System.out.println(r1);
			System.out.println(r2);
			System.out.println(r3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		// �رշ���
		ser.shutdownNow();
	}
}










