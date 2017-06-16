package timerTask;

import java.util.Calendar;
import java.util.Timer;

public class MyTimer extends Timer {
	public static void main(String[] args) {
		MyTimer myTimer = new MyTimer();
		MyTimerTask myTimerTask = new MyTimerTask();
		// myTimer.schedule(myTimerTask, Calendar.getInstance().getTime());
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		myTimer.schedule(myTimerTask, Calendar.getInstance().getTime(), 1000L);
		myTimer.scheduleAtFixedRate(myTimerTask, Calendar.getInstance().getTime(), 1000);
				
		System.out.println(8>>2);
	}
	
	
}
