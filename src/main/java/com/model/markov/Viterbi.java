package com.model.markov;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
/**
 * Viterbi --天气预测实例
 * 马尔科夫使用了上一次的期望值，而Viterbi使用了上一次的最大值
 * @author fany
 */
public class Viterbi {

	private static final int DROUGHT = 0;
	private static final int DRY = 1;
//	private static final int MOIST = 2;
	private static final int HUMIDITY = 3;

	// 初始概率向量,表示一年中晴天，阴天，雨天的概率
	private static final double[] initialP = { 0.63, 0.17, 0.2 };
	// 状态转移矩阵（前一天和后一天的关系）{{晴—晴,阴-晴,雨-晴},{晴—阴,阴-阴,雨-阴},{晴—雨,阴-雨,雨-雨}}
	private static final double[][] statusP = { { 0.5, 0.25, 0.25 },
			{ 0.375, 0.125, 0.375 }, { 0.125, 0.625, 0.375 } };
	// 混淆矩阵（发射概率） 显现和天气的关系{干旱{晴,阴,雨},干燥{晴,阴,雨},湿润{晴,阴,雨},潮湿{晴,阴,雨}}
	private static final double[][] emitP = { { 0.6, 0.25, 0.05 },
			{ 0.2, 0.25, 0.1 }, { 0.15, 0.25, 0.35 }, { 0.05, 0.25, 0.05 } };
	
	/**
	 * P(初始状态)*P(观察状态) 
	 * @param inputNO
	 * @return
	 * @throws Exception
	 */
	public static List<Double> firstDayP(int inputNO) throws Exception {
		List<Double> firstdayP = new ArrayList<Double>();
		for (int i = 0; i < initialP.length; i++) {
			firstdayP.add(new BigDecimal(initialP[i]).multiply(
					new BigDecimal(emitP[inputNO][i])).doubleValue());
		}
		return firstdayP;
	}

	/**
	 * 第二天开始，由前一天和显状态影响,只取期望最大的结果
	 * @param inputNO
	 * @param beforDayP
	 * @return
	 */
	
	public static List<Double> otherDayP(int inputNO, List<Double> beforDayP) {
		List<Double> otherDayP = new ArrayList<Double>();

		for (int i = 0; i < initialP.length; i++) {
			double maxResult = 0;
			for (int j = 0; j < initialP.length; j++) {
				double result = new BigDecimal(beforDayP.get(j))
						.multiply(new BigDecimal(statusP[i][j])).doubleValue();
				if(result > maxResult) {
					maxResult = result;
				}
			}
			BigDecimal resultP =new BigDecimal(maxResult).multiply(new BigDecimal(emitP[inputNO][i]));
			otherDayP.add(resultP.doubleValue());
		}

		return otherDayP;
	}

	public static void main(String[] args) throws Exception {

		List<Double> firstDayP = firstDayP(DROUGHT);
		for (double b : firstDayP) {
			System.out.print(b);
			System.out.print(" ");
		}
		System.out.println();
	
		List<Double> secondDayp = otherDayP(DRY, firstDayP);
		for (double b : secondDayp) {
			System.out.print(b);
			System.out.print(" ");
		}
		System.out.println();
		
		List<Double> threeDayp = otherDayP(HUMIDITY, secondDayp);
		for (double b : threeDayp) {
			System.out.print(b);
			System.out.print(" ");
		}
	}

}
