package org.fly.tool.arithmetic.data;

import org.fly.tool.arithmetic.constant.MarkEnum;

public class ArithmeticData {

	public static int DIVISION_FLOAT_COUNT = 2;

	// 左边数
	private double leftNumber;

	// 符号
	private MarkEnum markEnum;

	// 右边数
	private double rightNumber;

	// 结果
	private double resultNumber;

	public double getLeftNumber() {
		return leftNumber;
	}

	public void setLeftNumber(double leftNumber) {
		this.leftNumber = leftNumber;
	}

	public MarkEnum getMarkEnum() {
		return markEnum;
	}

	public void setMarkEnum(MarkEnum markEnum) {
		this.markEnum = markEnum;
	}

	public double getRightNumber() {
		return rightNumber;
	}

	public void setRightNumber(double rightNumber) {
		this.rightNumber = rightNumber;
	}

	public double getResultNumber() {
		return resultNumber;
	}

	public void setResultNumber(double resultNumber) {
		this.resultNumber = resultNumber;
	}

	public String getArithmeticStr() {
		String markStr = null;
		switch (markEnum) {
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
			break;
		default:
			break;
		}

		String msg = String.format(" %.0f %s %.0f = ", getLeftNumber(), markStr, getRightNumber());

		return msg;
	}

	public String getFormatResultNumber() {
		int floatCount = 0;
		if (markEnum == MarkEnum.division) {
			floatCount = DIVISION_FLOAT_COUNT;
		}

		String floatMsg = String.format(String.format("%%.%df", floatCount), getResultNumber());

		return floatMsg;
	}

	/**
	 * 将算术题目对象转换成字符串
	 */
	@Override
	public String toString() {

		String msg = getArithmeticStr() + getFormatResultNumber();
		return msg;
	}
}
