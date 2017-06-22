package sort;

import java.util.List;

public class QuickSort implements BaseSort {
	private List<Integer> list;

	public QuickSort(List<Integer> list) {
		super();
		this.list = list;
	}

	public void sortAsc() {
		sort(0, list.size() - 1);
	}

	public void sort(int low, int high) {
		if (low >= high) {
			return;
		}
		int partition = getMidle(list, low, high);
		sort(low, partition - 1);
		sort(partition + 1, high);
	}

	public int getMidle(List<Integer> list, int low, int high) {
		int temp = list.get(low);
		while (low < high) {
			while (low < high && list.get(high) >= temp) {
				high--;
			}
			list.set(low, list.get(high));
			
			while (low < high && list.get(low) <= temp) {
				low++;
			}
			list.set(high, list.get(low));
			
		}
		list.set(low, temp);
		return low;
	}
}
