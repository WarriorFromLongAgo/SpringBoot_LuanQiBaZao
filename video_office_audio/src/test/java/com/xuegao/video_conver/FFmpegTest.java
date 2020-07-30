package com.xuegao.video_conver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FFmpegTest {

	public static void main(String[] args) {
		
		String srcFile = "";
		String destFile = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("please input source video File path:");
		srcFile = scanner.next();
		System.out.println("please input out File path:");
		destFile = scanner.next();
		transfer(srcFile, destFile);

	}

	public static boolean transfer(String inFile, String outFile) {
		String command = "ffmpeg -i " + inFile
				+ " -y -f image2 -ss 00:00:01 -t 00:00:01 -s 720x480 "
				+ outFile;
		try {
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(command);
			InputStream stderr = proc.getErrorStream();
			InputStreamReader isr = new InputStreamReader(stderr);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null){
				System.out.println(line);
			}
		} catch (Throwable t) {
			t.printStackTrace();
			return false;
		}
		return true;
	}

}
