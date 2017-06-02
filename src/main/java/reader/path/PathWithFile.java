package reader.path;

import java.io.File;

import org.junit.Test;

public class PathWithFile {

	@Test
	public void getFilePath1() {

		File f = new File(this.getClass().getResource("pathNote.txt").getPath());
		System.out.println(f);

	}

	@Test
	public void getFilePath2() {

		File f = new File(this.getClass().getResource("pathNote.txt")
				.getPath());
		System.out.println(f);

	}

	@Test
	/**
	 * getClassLoader() .resources路径
	 */
	public void getFilePath3() {
		File f = new File(this.getClass().getClassLoader()
				.getResource("log4j.properties").getPath());
		System.out.println(f);
	}
	
	@Test
	public void getFilePath4() {

		File f = new File(this.getClass().getResource("")
				.getPath());
		System.out.println(f);

	}
	
	@Test
	public void getFilePath5() {

		File f = new File(this.getClass().getClassLoader().getResource("")
				.getPath());
		System.out.println(f);
	}
	
	@Test
	public void getFilePath6() {

		File f = new File(this.getClass().getResource("/")
				.getPath());
		System.out.println(f);
	}
	
	@Test
	public void getFilePath7() {

		File f = new File(this.getClass().getResource("/log4j.properties")
				.getPath());
		System.out.println(f);
	}
}
