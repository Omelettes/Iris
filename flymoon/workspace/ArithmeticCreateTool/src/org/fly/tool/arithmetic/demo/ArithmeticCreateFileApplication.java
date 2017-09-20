package org.fly.tool.arithmetic.demo;

import java.io.IOException;
import java.util.List;

import org.fly.tool.arithmetic.core.ArithmeticCreateCore;
import org.fly.tool.arithmetic.data.ArithmeticData;
import org.fly.tool.arithmetic.input.FileInputWorker;
import org.fly.tool.arithmetic.output.FileOutputWorker;
import org.fly.tool.arithmetic.output.PrintTool;

public class ArithmeticCreateFileApplication {

	private static String CONFIG_PATH = "./config.txt";
	private String arithmeticPath = "./arithmetic.txt";
	private String resultPath = "./result.txt";

	public static void main(String[] args) throws Exception {
		// ArithmeticCreateCore createCore = new ArithmeticCreateCore();
		//
		// StringBuilder sb = new StringBuilder();
		// for (int i = 0; i < args.length; i++) {
		// sb.append(args[i]).append(" ");
		// }
		//
		// String cmdStr = sb.toString();
		// PrintTool.print(cmdStr);
		// PrintTool.println("");
		// String cmdStr = "+ 100 - 50 * 100 / 70";

		ArithmeticCreateFileApplication application = new ArithmeticCreateFileApplication();
		application.excute(args);

	}

	public void excute(String[] args) throws Exception {
		if (args.length == 2) {
			arithmeticPath = args[0].trim();
			resultPath = args[1].trim();
		}
		ArithmeticCreateCore createCore = new ArithmeticCreateCore();
		FileInputWorker inputWorker = new FileInputWorker();
		String configStr = inputWorker.readFile(CONFIG_PATH);
		PrintTool.println(configStr);
		List<ArithmeticData> dataList = createCore.createRandomArithmetic(2, configStr);
		FileOutputWorker fileWorker = new FileOutputWorker();
		fileWorker.writeToTwoFile(arithmeticPath, resultPath, dataList, true);
	}

}
