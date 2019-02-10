package com.query.QueryApp.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileScanner {
	
	private BufferedReader bufferedReader;
	
	public FileScanner(File file) throws IOException {
		this.bufferedReader = new BufferedReader(new FileReader(file));
	}
	
	public String next() {
		try {
			String result = this.bufferedReader.readLine();
			return result == null ? "" : result;
		} catch (IOException e) {
			return "";
		}
	}

}

