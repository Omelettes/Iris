package org.fly.tool.arithmetic.input;

import java.io.File;
import java.io.FileInputStream;

import org.fly.tool.arithmetic.output.PrintTool;

public class FileInputWorker {

	public String readFile(String filePath) throws Exception {
		File readFile = new File(filePath);
		if (!readFile.exists()) {
			throw new Exception("该文件不存在");
		}

		FileInputStream fileInputStream = null;

		try {
			fileInputStream = new FileInputStream(readFile);

			byte[] cacheByte = new byte[1024];

			StringBuilder sb = new StringBuilder();
			while (fileInputStream.read(cacheByte) != -1) {
				String msg = new String(cacheByte, "utf-8").trim();
				sb.append(msg);
			}

			PrintTool.println("文件读取完成");
			return sb.toString();
		} catch (Exception ex) {
			throw ex;
		} finally {
			fileInputStream.close();
		}

	}
}
