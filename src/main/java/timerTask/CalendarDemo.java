package timerTask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class CalendarDemo {
	private Calendar calendar = null;
	DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Before
	public void currentTime() {
		calendar = Calendar.getInstance();
		System.out.println();
		System.out.println("Current Time:" + f.format(calendar.getTime()));
	}

	@Test
	public void TestSetPrint() {
		// month + 1
		calendar.set(2016, 6, 1, 12, 11, 11);
		System.out.println(f.format(calendar.getTime()));
		
		calendar.set(2016, 0, 1, 25, 11, 11);
		System.out.println(f.format(calendar.getTime()));


		calendar.set(2016, 5, 32, 12, 11, 11);
		System.out.println(f.format(calendar.getTime()));
	}

	@Test
	public void TestPrintMessage() {
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH + 1));
		System.out.println(calendar.get(Calendar.DATE));
		System.out.println(calendar.get(Calendar.HOUR));
		System.out.println(calendar.get(Calendar.MINUTE));
		System.out.println(calendar.get(Calendar.SECOND));
		System.out.println(calendar.get(Calendar.MILLISECOND));

		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
	}

	@Test
	public void TestTimeOperation() {
		calendar.add(Calendar.YEAR, 1);
		System.out.println(f.format(calendar.getTime()));
		calendar.add(Calendar.MONTH, -1);
		System.out.println(f.format(calendar.getTime()));
		Calendar newcalendar = Calendar.getInstance();
		// 前>后,返回1
		System.out.println(calendar.compareTo(newcalendar));
	}

}
