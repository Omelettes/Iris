package org.fly.tool.arithmetic.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.fly.tool.arithmetic.constant.MarkEnum;
import org.fly.tool.arithmetic.data.ArithmeticData;
import org.fly.tool.arithmetic.print.PrintTool;

public class ArithmeticCreateCore {

	private Random random = new Random();

	public List<ArithmeticData> createRandomArithmetic(int figures, String cmdStr) {
		List<ArithmeticData> dataList = new ArrayList();
		String[] cmdArray = cmdStr.split(" ");

		int index = 0;
		while (index < cmdArray.length) {
			if ("-+".equals(cmdArray[index].trim())) {
				int count = Integer.valueOf(cmdArray[index + 1].trim());
				for (int i = 0; i < count; i++) {
					ArithmeticData itemData = createAddition(figures);
					dataList.add(itemData);
				}
			}
			if ("--".equals(cmdArray[index].trim())) {
				int count = Integer.valueOf(cmdArray[index + 1].trim());
				for (int i = 0; i < count; i++) {
					ArithmeticData itemData = createSubtraction(figures);
					dataList.add(itemData);
				}
			}
			if ("-*".equals(cmdArray[index].trim())) {
				int count = Integer.valueOf(cmdArray[index + 1].trim());
				for (int i = 0; i < count; i++) {
					ArithmeticData itemData = createMultiplication(figures);
					dataList.add(itemData);
				}
			}
			if ("-/".equals(cmdArray[index].trim())) {
				int count = Integer.valueOf(cmdArray[index + 1].trim());
				for (int i = 0; i < count; i++) {
					ArithmeticData itemData = createDivision(figures);
					dataList.add(itemData);
				}
			}

			index++;
		}

		return dataList;
	}

	public ArithmeticData createAddition(int figures) {
		ArithmeticData arithmeticData = new ArithmeticData();
		arithmeticData.setLeftNumber(randomNumber(figures));
		arithmeticData.setMarkEnum(MarkEnum.addition);
		arithmeticData.setRightNumber(randomNumber(figures));

		arithmeticData.setResultNumber(arithmeticData.getLeftNumber() + arithmeticData.getRightNumber());

		return arithmeticData;
	}

	public ArithmeticData createSubtraction(int figures) {
		ArithmeticData arithmeticData = new ArithmeticData();
		arithmeticData.setLeftNumber(randomNumber(figures));
		arithmeticData.setMarkEnum(MarkEnum.subtraction);
		arithmeticData.setRightNumber(randomNumber(figures));

		arithmeticData.setResultNumber(arithmeticData.getLeftNumber() - arithmeticData.getRightNumber());

		return arithmeticData;
	}

	public ArithmeticData createMultiplication(int figures) {
		ArithmeticData arithmeticData = new ArithmeticData();
		arithmeticData.setLeftNumber(randomNumber(figures));
		arithmeticData.setMarkEnum(MarkEnum.multiplication);
		arithmeticData.setRightNumber(randomNumber(figures));

		arithmeticData.setResultNumber(arithmeticData.getLeftNumber() * arithmeticData.getRightNumber());

		return arithmeticData;
	}

	public ArithmeticData createDivision(int figures) {
		ArithmeticData arithmeticData = new ArithmeticData();
		arithmeticData.setLeftNumber(randomNumber(figures));
		arithmeticData.setMarkEnum(MarkEnum.division);

		double rightNumber = 0;
		while ((rightNumber = randomNumber(figures)) == 0) {
		}
		arithmeticData.setRightNumber(rightNumber);

		arithmeticData.setResultNumber(arithmeticData.getLeftNumber() / arithmeticData.getRightNumber());

		return arithmeticData;
	}

	public double randomNumber(int figures) {

		int bound = 10;
		for (int i = 2; i <= figures; i++) {
			bound *= 10;
		}
		int number = random.nextInt(bound);

		return number;
	}

	public static void main(String[] args) throws Exception {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < args.length; i++) {
			sb.append(args[i]).append(" ");
		}

		String cmdStr = sb.toString();
		PrintTool.print(cmdStr);
		ArithmeticCreateCore demo = new ArithmeticCreateCore();
		// String cmdStr = "+ 100 - 50 * 100 / 70";
		List<ArithmeticData> dataList = demo.createRandomArithmetic(2, cmdStr);

		for (ArithmeticData itemData : dataList) {
			PrintTool.printlnArithmetic(itemData);
		}

		// PrintTool.print(String.valueOf(demo.randomNumber(1)));
		// PrintTool.printlnArithmetic(demo.createAddition(2));
		// PrintTool.printlnArithmetic(demo.createSubtraction(2));
		// PrintTool.printlnArithmetic(demo.createMultiplication(2));
		// PrintTool.printlnArithmetic(demo.createDivision(2));
	}
}
