package conllection;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;



public class HashMapNote {
	/**
	 * 1.7 及之前采用数组和链表构成  --Entry<K,V>[] 
	 * 1.8  链表长度大于8时，使用红黑树
	 * threshold -阈值 ,该值为初始容量（初始容量默认为16）；当table被填充了，也就是为table分配内存空间后，threshold一般为 capacity*loadFactory
	 * threshold = tableSizeFor(initialCapacity);  幂运算      - - 移位或运算 
	 * 
	 */
	
	@Test
	public void initMap() {
		Map<Integer,Integer> m = new HashMap<Integer,Integer>(10); 
		m.put(1, 1);
		System.out.println(m.size());

		Map<Integer,Integer> m2 = new HashMap<Integer,Integer>(1); 
		m2.put(1, 1);
		System.out.println(m.size());
	}
}
