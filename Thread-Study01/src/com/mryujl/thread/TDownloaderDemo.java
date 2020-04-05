package com.mryujl.thread;

public class TDownloaderDemo {

	public static void main(String[] args) {
		ThreadDownloader td1 = new ThreadDownloader("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2688721595,1840055009&fm=26&gp=0.jpg", "phone.jpg");
		ThreadDownloader td2 = new ThreadDownloader("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2265345458,1470507777&fm=26&gp=0.jpg", "phone2.jpg");
		ThreadDownloader td3 = new ThreadDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1585742282374&di=7090b88befc84bc661744f48fbded61c&imgtype=0&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D2146671969%2C27331522%26fm%3D214%26gp%3D0.jpg", "phone3.jpg");
	
		// 启动三个线程
		td1.start();
		td2.start();
		td3.start();
	}

}
