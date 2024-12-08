package com.jpa.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jpa.test.helper.FileUploadaHelper;

@RestController

public class FileUplaod {
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		System.out.print(file.getOriginalFilename());
		try {
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request");
			}

			if (!file.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request");
			}
			boolean f = FileUploadaHelper.uploadFile(file);
			if(f)
			{
				return ResponseEntity.ok("uploaded");
			}
			// NOW FILE UPLOAD CODE
			// C:\Users\hp\Documents\workspace-spring-tool-suite-4-4.21.0.RELEASE\BootRestBook\src\main\resources\static
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok("worikng");
	}
}
