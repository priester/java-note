package thread;

public class ThreadWithRW extends Thread {
	private String username = "user";
	private String password = "pass";

	public synchronized void set() {
		this.username = "username";
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.password = "password";
	}

	public synchronized void print() {
		System.out.println("username :" + username);
		System.out.println("password:" + password);
	}

	@Override
	public void run() {
		set();
	}

	public static void main(String[] args) {
		ThreadWithRW threadWithRW = new ThreadWithRW();
		Thread thread = new Thread(threadWithRW);
		thread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadWithRW.print();
	}
}
