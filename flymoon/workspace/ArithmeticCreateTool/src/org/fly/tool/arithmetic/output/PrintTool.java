package org.fly.tool.arithmetic.output;

import java.util.List;

import org.fly.tool.arithmetic.data.ArithmeticData;

public class PrintTool {

	public static void println(String msg) {
		System.out.println(msg);
	}

	public static void print(String msg) {
		System.out.print(msg);
	}

	public static void printArithmeticList(List<ArithmeticData> arithmeticDataList) {
		int index = 1;
		for (ArithmeticData itemData : arithmeticDataList) {
			PrintTool.print(String.format(" %s : ", index));
			PrintTool.printArithmetic(itemData);
			PrintTool.println("");
			index++;
		}
	}

	public static void printArithmetic(ArithmeticData arithmeticData) {

		print(arithmeticData.toString());
	}
}
