package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReaderFileDemo {

	public static String readerFile(String fileName) {
		InputStream is = null;
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			is = ReaderFileDemo.class.getResourceAsStream(fileName);
			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return sb.toString();
	}

	public static String readerFile2(String fileName) {
//		InputStream is = null;
		 BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			// is = ReaderFileDemo.class.getResourceAsStream(fileName);
			// InputStreamReader isr= new InputStreamReader(is,
			// "UTF-8");
			FileReader fi = new FileReader(new File("d://test.txt"));
			br = new BufferedReader(fi);
			String s = "";
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}

			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
//				is.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return sb.toString();
	}

	// public static String writeFile

	public static void main(String[] args) {
		readerFile2("io.core.note");
		// System.out.println(readerFile("io.core.note"));
	}
}
