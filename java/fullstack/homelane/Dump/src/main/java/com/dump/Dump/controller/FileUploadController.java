package com.dump.Dump.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dump.Dump.exception.PlatformException;
import com.dump.Dump.model.Player;
import com.dump.Dump.model.ResponseData;
import com.dump.Dump.respository.PlayerRepository;
import com.dump.Dump.service.FileService;
import com.dump.Dump.utils.Constants;
import com.dump.Dump.utils.Utils;

@RestController
public class FileUploadController {

	@Autowired
	private FileService fileService;

	@Autowired
	private PlayerRepository playerRepo;

	@PostMapping("/upload")
	public ResponseEntity<ResponseData> uploadFileController(@RequestParam("file") MultipartFile file)
			throws PlatformException, IOException {
		System.out.println("Uploading starts " + file);
		this.fileService.uploadFile(file);

		File fileSaved = this.fileService.getFile(file.getOriginalFilename());
		if (ObjectUtils.isEmpty(fileSaved)) {
			return new ResponseEntity<ResponseData>(
					new ResponseData<String>("File not found", Constants.FAILED, HttpStatus.NOT_FOUND),
					HttpStatus.NOT_FOUND);
		}

		
		List<Player> players = Utils.readFromFile(fileSaved);
		playerRepo.saveAll(players);
		return new ResponseEntity<ResponseData>(
				new ResponseData<String>("Database initialized", Constants.SUCCESS, HttpStatus.OK), HttpStatus.OK);

	}

}
