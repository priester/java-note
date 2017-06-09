package reflect;

import java.lang.reflect.Method;

/**
 * 任何类都是是Class的对象
 * @author fany
 *
 */
public class ClassDemo {

	public static void initClass() {
		
		ClassDemo demo = new ClassDemo();
		//class创建
		Class<?> c1 = ClassDemo.class;
		Class<?> c2 = demo.getClass();
		
		Class<?> c3 = null;
		try {
			c3 = Class.forName("reflect.ClassDemo");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(c1 == c2);
		System.out.println(c1 == c3);
	}

	/**
	 * 打印方法
	 * @param o
	 */
	public void printMethodMassege(Object o) {
		Class<?> c1 = o.getClass();
		Method[] methods = c1.getMethods();
		for (Method m : methods) {
			System.out.print(m.getReturnType().getName() + " ");
			System.out.print(m.getName());
			Class<?>[] parameters = m.getParameterTypes();
			System.out.print("(");
			for (Class<?> c : parameters) {
				System.out.print(c.getName());
			}
			System.out.println(")");
		}
	}

	public static void main(String[] args) {
//		ClassDemo demo = new ClassDemo();
		
		String s = "123";
		// demo.printMethodMassege(s);

		Class<?> c = ClassDemo.class;
		ClassDemo demo = null;
		try {
			demo = (ClassDemo)c.newInstance();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Method m = null;
		try {
			// 先获取相应的method对象
			// getMethod第一个参数是方法名，第二个参数是该方法的参数类型，
			// 因为存在同方法名不同参数这种情况，所以只有同时指定方法名和参数类型才能唯一确定一个方法
			m = c.getMethod("printMethodMassege", Object.class);
			// 第一个参数是具体调用该方法的对象
			// 第二个参数是执行该方法的具体参数
			m.invoke(demo, s);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
