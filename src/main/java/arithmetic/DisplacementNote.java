package arithmetic;

import org.junit.Test;

public class DisplacementNote {

	/**
	 * 测试 >>>
	 */
	@Test
	public void test1() throws Exception {
		int i = 14;
		System.out.println(Integer.toBinaryString(i));

		int i2 = i;
		i2 = i2 >>> 1;
		System.out.println(Integer.toBinaryString(i2));
		System.out.println(i2);

		int i3 = i;
		i3 = i3 | i3 >>> 1;
		System.out.println(Integer.toBinaryString(i3));
		System.out.println(i3);

		int i4 = i;
		i4 |= i4 >>> 1;
		System.out.println(Integer.toBinaryString(i4));
		System.out.println(i4);

		i |= i >>> 1;
		i |= i >>> 2;
		i |= i >>> 4;
		i |= i >>> 8;
		i |= i >>> 16;
		System.out.println(Integer.toBinaryString(i));
		System.out.println(i);
	}
}
