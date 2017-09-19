package org.fly.tool.arithmetic.print;

import org.fly.tool.arithmetic.data.ArithmeticData;

public class PrintTool {

	public static int DIVISION_FLOAT_COUNT = 2;

	public static void print(String msg) {
		System.out.println(msg);
	}

	public static void printlnArithmetic(ArithmeticData arithmeticData) {
		String markStr = null;
		int floatCount = 0;
		switch (arithmeticData.getMarkEnum()) {
		case addition:
			markStr = "+";
			break;
		case subtraction:
			markStr = "-";
			break;
		case multiplication:
			markStr = "*";
			break;
		case division:
			markStr = "/";
			floatCount = DIVISION_FLOAT_COUNT;
			break;
		default:
			break;
		}

		// if (markStr == null) {
		// throw new Exception("Î´Öª·ûºÅ:" + arithmeticData.getMarkEnum());
		// }

		String floatMsg = String.format(String.format("%%.%df", floatCount), arithmeticData.getResultNumber());
		String msg = String.format(" %.0f %s %.0f = %s ", arithmeticData.getLeftNumber(), markStr,
				arithmeticData.getRightNumber(), floatMsg);

		print(msg);
	}
}
