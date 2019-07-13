package com.dump.Dump.service;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dump.Dump.exception.PlatformException;
import com.dump.Dump.utils.Constants;


@Service
public class FileService {

	@Value("${upload.dir}")
	private String uploadDir;

	private File upload(MultipartFile file) throws IOException {
		String name = file.getOriginalFilename();
		File uploadFile = new File(name);
		uploadFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(uploadFile);
		fos.write(file.getBytes());
		fos.close();
		return uploadFile;
	}

	public void uploadFile(MultipartFile file) throws PlatformException, IOException {

		FileOutputStream fileOut = null;
		System.out.println("this is new line");
		if (ObjectUtils.isEmpty(file)) {
			throw new PlatformException(Constants.FILE_EMPTY, HttpStatus.BAD_REQUEST);
		}
		try {

			String path = this.uploadDir + file.getOriginalFilename();
			fileOut = new FileOutputStream(path);
			fileOut.write(file.getBytes());
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PlatformException(e.getMessage(), HttpStatus.BAD_REQUEST);
		} finally {

		}
	}

	public File getFile(String fileName) throws PlatformException {

		FileInputStream fileInStream = null;
		try {

			String path = this.uploadDir + fileName;
			File file = new File(path);
			
			return file;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PlatformException(e.getMessage(), HttpStatus.BAD_REQUEST);
		} finally {

		}
	}
	
	public List<String> getAllFiles(){
		File folder = new File(this.uploadDir);
		List<String> files = new ArrayList<>();
		for(File f : folder.listFiles()) {
			files.add(f.getName());
		}
		return files;
	}
}

