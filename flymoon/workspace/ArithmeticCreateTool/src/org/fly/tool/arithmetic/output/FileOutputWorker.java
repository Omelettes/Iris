package org.fly.tool.arithmetic.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.fly.tool.arithmetic.data.ArithmeticData;

public class FileOutputWorker {

	public void writeToTwoFile(String arithmeticPath, String resultPath, List<ArithmeticData> arithmeticDataList,
			boolean isOverWrite) throws IOException {
		File arithmeticFile = new File(arithmeticPath);
		if (arithmeticFile.exists() && isOverWrite) {
			arithmeticFile.delete();
		}
		arithmeticFile.createNewFile();

		File resultFile = new File(resultPath);
		if (resultFile.exists() && isOverWrite) {
			resultFile.delete();
		}
		resultFile.createNewFile();

		FileOutputStream arithmeticOutputStream = null;
		FileOutputStream resultOutputStream = null;
		try {
			arithmeticOutputStream = new FileOutputStream(arithmeticFile);
			resultOutputStream = new FileOutputStream(resultFile);

			int index = 1;
			for (ArithmeticData item : arithmeticDataList) {
				String arithmeticMsg = item.getArithmeticStr();
				arithmeticMsg = index + " " + arithmeticMsg + "\r\n";
				byte[] arithmeticByte = arithmeticMsg.getBytes("utf-8");
				arithmeticOutputStream.write(arithmeticByte);

				String resultMsg = item.getFormatResultNumber();
				resultMsg = index + " " + resultMsg + "\r\n";
				byte[] resultByte = resultMsg.getBytes("utf-8");
				resultOutputStream.write(resultByte);

				index++;
			}

			PrintTool.println("文件写入完成");
		} catch (Exception ex) {
			throw ex;
		} finally {
			arithmeticOutputStream.flush();
			resultOutputStream.flush();
			arithmeticOutputStream.close();
			resultOutputStream.close();
		}
	}

	public void writeToFile(String filePath, List<ArithmeticData> arithmeticDataList, boolean isOverWrite)
			throws IOException {
		File writeFile = new File(filePath);
		if (writeFile.exists() && isOverWrite) {
			writeFile.delete();
		}

		writeFile.createNewFile();
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(writeFile);

			int index = 1;
			for (ArithmeticData item : arithmeticDataList) {
				String outputMsg = item.toString();
				outputMsg = index + " " + outputMsg + "\r\n";
				byte[] outputByte = outputMsg.getBytes("utf-8");
				fileOutputStream.write(outputByte);
				index++;
			}

			fileOutputStream.flush();
		} catch (Exception ex) {
			throw ex;
		} finally {
			fileOutputStream.close();
		}
	}

}
