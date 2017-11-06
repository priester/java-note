package spring.aop.jdk;

public class RealSubject implements Subject {

	@Override
	public void result() {
		System.out.println("result");
	}

	@Override
	public void say() {
		System.out.println("say");
	}

}
