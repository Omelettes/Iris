package org.fly.tool.arithmetic.demo;

import java.util.List;

import org.fly.tool.arithmetic.core.ArithmeticCreateCore;
import org.fly.tool.arithmetic.data.ArithmeticData;
import org.fly.tool.arithmetic.output.PrintTool;

public class ArithmeticCreateToolApplication {

	public static void main(String[] args) {

		ArithmeticCreateCore createCore = new ArithmeticCreateCore();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < args.length; i++) {
			sb.append(args[i]).append(" ");
		}

		String cmdStr = sb.toString();
		PrintTool.print(cmdStr);
		PrintTool.println("");
		// String cmdStr = "+ 100 - 50 * 100 / 70";
		List<ArithmeticData> dataList = createCore.createRandomArithmetic(2, cmdStr);
		PrintTool.printArithmeticList(dataList);
	}

}
