package thread;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MyThreadByThread extends Thread {

	/**
	 * 对同一个对象进行读写操作时需要加锁
	 */

	public static final Format DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss:SSS");

	public int i = 0;

	@Override
//	public synchronized void run() {
	public void run() {
		i++;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Calendar c2 = Calendar.getInstance();
		System.out.println(Thread.currentThread().getName() + ":" + i
				+ " ;当前时间" + DATE_FORMAT.format(c2.getTime()));
	}

	public static void main(String[] args) throws InterruptedException {
		List<Thread> threadList = new ArrayList<Thread>();

		Calendar c1 = Calendar.getInstance();
		System.out.println(DATE_FORMAT.format(c1.getTime()));

		MyThreadByThread myThread = new MyThreadByThread();
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(myThread);
			thread.start();
			threadList.add(thread);
		}

		for (Thread thread : threadList) {
			thread.join();
		}
		Calendar c2 = Calendar.getInstance();
		System.out.println(DATE_FORMAT.format(c2.getTime()));
	}
}
