package spring.aop.jdk;

import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) {
		Sub subject = (Sub)Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[]{Sub.class}, new JdkProxySubject(new RealSubject() ));
		subject.result();
	}
}
