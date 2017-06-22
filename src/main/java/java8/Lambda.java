package java8;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Lambda {

	@Test
	public void testPrint() {
		List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3 });
		list.forEach(e -> System.out.print(e + " "));
		System.out.println();
		list.forEach((Integer e) -> System.out.print(e + " "));
		System.out.println();
		list.forEach(e -> {
			System.out.print(e);
			System.out.print(" ");
		});
	}

	@Test
	public void testSort() {
	
		List<Integer> list = Arrays.asList(new Integer[] { 1, 3, 2 });
		list.sort((e1, e2) -> e1.compareTo(e2));
		list.forEach(e -> System.out.print(e + " "));
		System.out.println();
		
		list.sort((e1, e2) -> {
			int result = e2.compareTo(e1);
			return result;
		});
		list.forEach(e -> System.out.print(e + " "));
		System.out.println();
		
		list.sort((e1, e2) -> {
			int result = e2.compareTo(e1);
			return -result;
		});
		list.forEach(e -> System.out.print(e + " "));
	}
	
}
