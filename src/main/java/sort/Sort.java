package sort;

import java.util.List;

public class Sort {
	public static BaseSort newBaseSort(List<Integer> list,int type) {
		BaseSort sort =null;
		if (type == 1){
			sort = new InsertionSort(list);
		}
		if (type == 2){
			sort = new QuickSort(list);
		}	
		return sort;
	}
}
