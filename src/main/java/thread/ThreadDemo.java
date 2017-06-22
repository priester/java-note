package thread;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ThreadDemo {

	
	public int i = 0;

	public static void main(String[] args) throws InterruptedException {

		ThreadDemo threadDemo = new ThreadDemo();
		MyThread myThread = new MyThread(threadDemo);

		for (int i = 0; i < 10; i++) {
			// Thread thread = new MyThread(threadDemo);
			Thread.sleep(1000);
			Thread thread = new Thread(myThread); 
			thread.start();
		}
	}
}

class MyThread extends Thread {

	public static final Format DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss:SSS");

	public ThreadDemo threadDemo;

	MyThread(ThreadDemo threadDemo) {
		this.threadDemo = threadDemo;
	}

	@Override
	public synchronized void run() {
		int i = threadDemo.i;
		threadDemo.i = i++;
		Calendar c2 = Calendar.getInstance();
		System.out.println(Thread.currentThread().getName() + ":" + threadDemo.i
				+ " ;当前时间" + DATE_FORMAT.format(c2.getTime()));

	}

}
