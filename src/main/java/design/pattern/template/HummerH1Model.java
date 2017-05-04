package design.pattern.template;

/*
 * 悍马车是每个越野者的最爱，其中H1最接近军用系列
 */
public class HummerH1Model extends HummerModel {
	@Override
	public void alarm() {
		System.out.println("悍马H1鸣笛...");
	}

	@Override
	public void engineBoom() {
		System.out.println("悍马H1引擎声音是这样在...");
	}

	@Override
	public void start() {
		System.out.println("悍马H1发动...");
	}

	@Override
	public void stop() {
		System.out.println("悍马H1停车...");
	}
}
