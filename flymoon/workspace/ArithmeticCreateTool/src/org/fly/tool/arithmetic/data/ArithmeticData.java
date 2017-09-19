package org.fly.tool.arithmetic.data;

import org.fly.tool.arithmetic.constant.MarkEnum;

public class ArithmeticData {
	
	//左边数
	private double leftNumber;
	
	//符号
	private MarkEnum markEnum;
	
	//右边数
	private double rightNumber;
	
	//结果
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
}
