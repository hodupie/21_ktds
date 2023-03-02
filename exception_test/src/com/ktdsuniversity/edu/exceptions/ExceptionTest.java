package com.ktdsuniversity.edu.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ExceptionTest {
	public static void main(String[] args) {
		
		List <String> lines = new ArrayList<>();
		//Exception 타입 -> 반드시 try-catch로 복구코드 적어주어야 함
		try {
			lines = Files.readAllLines(Paths.get("bad path"));
		}
		catch (IOException ioe) {
			try {
				lines = Files.readAllLines(Paths.get("good path"));
			}
			catch (IOException ioe2) {
				System.out.println("IOExcepton " + ioe2.getMessage());
			}
		}
	}	
}
