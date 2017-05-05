package design.pattern.template;

/*
 * 悍马车是每个越野者的最爱，其中H2最接近军用系列
 */
public class HummerH2Model extends HummerModel {
	@Override
	protected void alarm() {
		System.out.println("悍马H2鸣笛...");
	}

	@Override
	protected void engineBoom() {
		System.out.println("悍马H2引擎声音是这样在...");
	}

	@Override
	protected void start() {
		System.out.println("悍马H2发动...");
	}

	@Override
	protected void stop() {
		System.out.println("悍马H2停车...");
	}
}
