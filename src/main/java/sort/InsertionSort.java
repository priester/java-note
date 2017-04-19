package sort;

import java.util.List;

/**
 * 
 * @author fany
 */
public class InsertionSort implements BaseSort {
	private List<Integer> list;

	// public List<Integer> sortAsc() {
	// for (int i = 1; i < list.size(); i++) {
	// for (int j = 0; j < i; j++) {
	// if (list.get(i) < list.get(j)) {
	// list.remove(i);
	// list.add(j, list.get(i));
	// }
	// }
	// }
	// return null;
	// }

	public void sortAsc() {
		for (int i = 1; i < list.size(); i++) {
			//当前用于排序的值
			int temp = list.get(i);
			for (int j = 0; j < i; j++) {
				//后面的结点只做了位移操作，不做比较操作
				if (list.get(j) > temp) {
					//位于当前排序的位置前的结点后移一个单位 （注意先移动后面的再移动前面的）
					while(j<i){
						list.set(i, list.get(i-1));
						i--;
					}
					list.set(j, temp);
					break;
				}
			}
		}
	}

	public InsertionSort(List<Integer> list) {
		super();
		this.list = list;
	}
}
