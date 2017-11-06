package spring.aop.jdk;

public class RealSubject implements Sub {

	@Override
	public void result() {
		System.out.println("result");
	}

	@Override
	public void say() {
		System.out.println("say");
	}

}
