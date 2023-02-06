package com.ktdsuniversity.edu.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileWriter {
	
	public static File createNewFile() throws IOException {
		File textFile = new File("C:\\logss", "test.txt");
		textFile.createNewFile();
		return textFile;
	}
	
	public static File createNewfileThrowsRuntimeException () {
		File textFile = new File("C:\\logsss", "test.txt");
		try {
			textFile.createNewFile();
		} catch (IOException ioe) {
			throw new RuntimeException(ioe.getMessage(), ioe);
			
		}
		return textFile;
	}
	
	public static void main(String[] args) {

//		File textFile = new File ("C:\\logs", "text.txt");
		File textFile = new File("C:\\logs");
		if (textFile.isDirectory()) {
//		if (textFile.exists() && textFile.isFile()) {
			// java.io.Outputstream
			// java.il.FileOutputStream
			OutputStream fos = null;
			try {
				fos = new FileOutputStream(textFile);
				fos.write("파일 내용을 씁니다.".getBytes());
				fos.flush();
				fos.close();
			} catch (FileNotFoundException e) {
//				e.printStackTrace();
			} catch (IOException e) {
//				e.printStackTrace();
			} finally {
				if (fos != null) {
					try {
						fos.close();
					} catch (IOException e) {}
				}
			}
		}
		
		
//		createNewfileThrowsRuntimeException();
		
//		try {
//			createNewFile();
//		} catch (IOException ioe) {
//			System.out.println("에러가 발생했습니다. " + ioe.getMessage());
//		}
	}
}
