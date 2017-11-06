package arithmetic;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * 中文判断
 * @author fany
 *
 */
public class Chinese {
	
	private  static Logger logger = Logger.getLogger(Chinese.class);

	public static boolean isContainChineseByByte(String s) {

		boolean isContainChineseByByte = false;
//		System.out.println(s.getBytes());
//		System.out.println(s.getBytes().length);
		if (s.getBytes().length != s.length()) {
			isContainChineseByByte = true;
		}

		return isContainChineseByByte;
	}
	
	public static boolean isContainChineseByRegular(String s){
		boolean isContainChineseByByte = false;
		String regex = "[\u4e00-\u9fa5]";
		Pattern p= Pattern.compile(regex); 
		Matcher m = p.matcher(s);
		if(m.find()){
			isContainChineseByByte = true;
		} 
		return isContainChineseByByte;
	}
	
	public static void main(String[] args) {
		String s1 = "中国";
		String s2 = "zg";
		
		printBatesLenth(s1);
		printBatesLenth(s2);
		
		String s3 = "zg*";
		System.out.println(isContainChineseByByte(s1));
		System.out.println(isContainChineseByByte(s2));
		System.out.println(isContainChineseByByte(s3));
		logger.info("123");
	}

	private static void printBatesLenth(String s1) {
		try {
			System.out.println(s1.getBytes("UTF-8").length); 
			System.out.println(s1.getBytes("GBK").length);
			System.out.println(s1.getBytes().length);
			
		} catch (UnsupportedEncodingException e) {
		
			e.printStackTrace();
		}
	}
}
