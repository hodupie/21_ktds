package com.ktdsuniversity.edu.recursive;

import java.io.File;

public class Recursive {
	
	public void recursive(int i) {
		System.out.println("실행중... " + i);
		i++;
		recursive(i);
	}
	
	public void readFile(File file) {
		File[] fileList = file.listFiles();
		for (File file2 : fileList) {
			System.out.println(file2.getAbsolutePath());

			if (file2.isDirectory()) {
				readFile(file2);
//				File[] fileList2 = file2.listFiles();
//				for (File file3 : fileList2) {
//					System.out.println(file3.getAbsolutePath());
//				}
			}
		}
	}
	
	public static void main(String[] args) {
		Recursive recursive = new Recursive();
//		recursive.recursive(0);
		recursive.readFile(new File("C:\\Devs"));
	}
}
