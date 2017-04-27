package conllection;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArrayListNote {
	// TODO modCount ?

	/**
	 * --1、System.arraycopy() 位移实现 --2、removed（Object） 仅删除第一个
	 */

	@Test
	public void initArrayList() {
		List<String> l1 = new ArrayList<String>();
		List<String> l2 = new ArrayList<String>(10);
		List<String> l3 = new ArrayList<String>(l1);
		System.out.println(l1 == l2);
		System.out.println(l3 == l2);
		System.out.println(l3 == l1);
	}

	@Test
	// TODO trimToSize 去除多余的空间？？
	public void trimToSize() {
		ArrayList<String> list = new ArrayList<String>(10);
		list.add("1");
		list.add("1");
		list.trimToSize(); // 注意是ArrayList里面的方法，List中没有该方法
		System.out.println(list.get(0));
	}

	@Test
	// 容量扩充
	public void ensureCapacity() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.ensureCapacity(1000000);// 最后需要的容量
		for (int i = 0; i < 1000000; i++) {
			list.add(i);
		}
	}

	@Test
	/**
	 * contains <-- indexOf <--equals
	 */
	public void contains() {
		List<Object> list = new ArrayList<Object>();
		Object o1 = new Object();
		Object o2 = new Object();
		list.add(o1);
		System.out.println(list.contains(o2));
	}

	@Test
	public void testClone() {
		ArrayList<String> l1 = new ArrayList<String>(10);
		l1.add("1");
		@SuppressWarnings("unchecked")
		List<String> l2 = (List<String>) l1.clone(); // new list
		System.out.println("list 1 :" + l1.hashCode());
		System.out.println("list 2 :" + l2.hashCode());
		System.out.println(l1 == l2);
		System.out.println(l1.equals(l2));
	}

	@Test
	public void testSetReturn() {
		ArrayList<String> list = new ArrayList<String>(10);
		list.add("oldValue");
		System.out.println(list.set(0, "newValue"));
	}

	@Test
	public void testRemove() {
		ArrayList<String> list = new ArrayList<String>(10);
		list.add("1");
		list.add("1");
		list.add("1");
		System.out.println("remove:" + list.remove(0)); // return elementData;
		System.out.println("remove:" + list.remove("1")); // return ture or
															// false and remove
															// first element;
		System.out.println(list.get(0));
	}

	@Test
	// removeAll去除相同的结果，retainAll保留相同的部分
	public void testRemoveCon() {
		ArrayList<String> l1 = new ArrayList<String>(10);
		l1.add("1");
		l1.add("2");
		l1.add("3");
		@SuppressWarnings("unchecked")
		List<String> l3 = (List<String>) l1.clone();
		ArrayList<String> l2 = new ArrayList<String>(10);
		l2.add("3");
		l2.add("4");
		//--1、
		l1.removeAll(l2);
		for (String s1 : l1) {
			System.out.print(s1);
		}
		System.out.println("");
		//--2、
		l3.retainAll(l2);
		for (String s : l3) {
			System.out.print(s);
		}
	}
}
