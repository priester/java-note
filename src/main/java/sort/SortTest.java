package sort;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SortTest {
	

	public static void main(String[] args) {
		Integer[] num = {1,2,3,4};
		List<Integer> list = Arrays.asList(num);
		Sort.newBaseSort(list,2).sortAsc();
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()){
			Integer i =itr.next();
			System.out.print(i);
		}
	}
}
