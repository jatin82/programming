package fileReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRead {
	
	
	public static void writeFile(String filePath) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)); // this is best use this for writing files
		writer.write("this is written using BufferedWriter\n");
		writer.close();	
		// another way
		
		FileOutputStream fos = new FileOutputStream(new File(filePath));
		String str = "\nthis is written using FileOutputStream";
		fos.write(str.getBytes());
		fos.close();
	}
	
	
	public static void readFileStatic(String filePath) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String currentLine;
		while((currentLine = reader.readLine())!=null) {
			System.out.println(currentLine);
		}
		
		FileInputStream fos = new FileInputStream(new File(filePath));
		int c;
		while((c = fos.read())!=-1) {
			System.out.println((char)c);
		}
		
		
	}

	
	public void readFile(String filePath) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String currentLine;
		while((currentLine = reader.readLine())!=null) {
			System.out.println(currentLine);
		}
		
		FileInputStream fos = new FileInputStream(new File(filePath));
		int c;
		while((c = fos.read())!=-1) {
			System.out.println((char)c);
		}
		
		
	}
	/*
	 * 
	
	project structure

--->src-->fileReader-->FileRead.java
--->src-->my.txt	 



	 */
	
	
	
	public void readFilePath(String filePath) throws IOException {
		readFile(getClass().getResource(filePath).getPath()); // only be loaded from non static method
		
	}
//	
	public static void main(String[] args) throws IOException {
		new FileRead().readFilePath("/my.txt"); // slash is required here in non static
		readFileStatic(FileRead.class.getClassLoader().getResource("my.txt").getPath()); // slash is required here in non static
		
		writeFile(FileRead.class.getClassLoader().getResource("my.txt").getPath());
		
	}

}
