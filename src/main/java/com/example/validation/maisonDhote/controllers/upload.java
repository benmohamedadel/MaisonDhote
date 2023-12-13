package com.example.validation.maisonDhote.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class upload {
	 @PostMapping("/upload")
	    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
	        // Process the file (e.g., save to disk, store in a database, etc.)
	        // For simplicity, this example just prints the file name.
	        System.out.println("Received file: " + file.getOriginalFilename());

	        return new ResponseEntity<>("File uploaded successfully!", HttpStatus.OK);
	    }
}
