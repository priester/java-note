package design.pattern.template;

/**
 * 客户开始使用这个模型
 */
public class Client {
	public static void main(String[] args) {
		// 客户开着H1型号，出去遛弯了
		HummerModel h1 = new HummerH1Model();
		h1.setAlarmFlag(true);
		h1.run(); // 汽车跑起来了；
		// 客户开H2型号，出去玩耍了
		HummerModel h2 = new HummerH2Model();
		h2.setAlarmFlag(false);
		h2.run();
	}
}
