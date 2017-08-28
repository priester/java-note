package dictionary;

public class Unicode {

	public static String unicode2String(String unicode) {
		if (unicode.isEmpty())
			return null;
		StringBuilder sb = new StringBuilder();
		int i = -1;
		int pos = 0;

		while ((i = unicode.indexOf("\\u", pos)) != -1) {
			sb.append(unicode.substring(pos, i));
			if (i + 5 < unicode.length()) {
				pos = i + 6;
				sb.append((char) Integer.parseInt(unicode.substring(i + 2, i + 6), 16));
			}
		}

		return sb.toString();
	}

	public static String string2Unicode(String string) {

		if (string.isEmpty())
			return null;
		StringBuffer unicode = new StringBuffer();

		for (int i = 0; i < string.length(); i++) {
			System.out.println(string.length());
			// 取出每一个字符
			char c = string.charAt(i);
			// 转换为unicode
			unicode.append("\\u" + Integer.toHexString(c));

		}

		return unicode.toString();
	}

	/**
	 * 十进制转化为十六进制，结果为C8。
	 */
	public static String get10to16(int i) {
		return Integer.toHexString(i);
	}

	/**
	 * 十六进制转化为十进制，结果140。
	 */
	public static Long get16to10(String s) {
		
		return Long.parseLong(s,16);  
	}
	
	
	public static void main(String[] args) {
//		System.out.println("是".length());
//		System.out.println("𠀀".length());
//		System.out.println(string2Unicode("𠀀"));
//		System.out.println(string2Unicode("𠀀"));
//		System.out.println(string2Unicode("𠀁"));
//		System.out.println(get16to10("c"));
//		System.out.println(unicode2String("\\ud840\\udc00"));
//		System.out.println(get16to10("2A6D6")- get16to10("20000") +1);
//		System.out.println(get16to10("2A6D6"));
	
		
		
		for(char c = '\u4E00'; c < '\u9FA5';c++) {
			System.out.print(c);
		}
		
//		String begin= "20000";
//		String end="2A6D6";
		
		
//		System.out.println(get16to10(end)- get16to10(begin) +1);
//		for(String i = begin ; i<){
			
//		}


		// unicode.append("\\u" + Integer.toHexString(c));
	}
}
