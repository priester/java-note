package thread;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 使用一个共有的Thread实现资源共享
 * 对同一个对象有读写操作时需要加锁
 * @author fany
 * 
 */

public class MyThreadByRunnable implements Runnable {

	public static final Format DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss:SSS");

	public int i = 0;

	public synchronized void run() {
		i++;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar c2 = Calendar.getInstance();
		System.out.println(Thread.currentThread().getName() + ":" + i +" ;当前时间"+DATE_FORMAT.format(c2.getTime()));

	}

	public static void main(String[] args) throws InterruptedException {

		List<Thread> threadList = new ArrayList<Thread>();

		Calendar c1 = Calendar.getInstance();
		System.out.println(DATE_FORMAT.format(c1.getTime()));

		MyThreadByRunnable myThread = new MyThreadByRunnable();
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
