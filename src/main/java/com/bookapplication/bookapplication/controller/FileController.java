package com.bookapplication.bookapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookapplication.bookapplication.helper.FileUploadHelper;

@RestController
public class FileController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    FileController(FileUploadHelper fileUploadHelper) {
        this.fileUploadHelper = fileUploadHelper;
    }

    @PostMapping("/upload_file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        System.out.println("file Name : " + file.getOriginalFilename());
        System.out.println("file size : " + file.getSize());
        System.out.println("file type : " + file.getContentType());

        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain the file");
        } else {
            System.out.println("File uploading in process...");
        }

        String content_type_of_file = file.getContentType();
        if (content_type_of_file != null && !content_type_of_file.equals("image/png")) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }

        // file uploading function is called from the FileUploadHelperClass

        boolean fileupload_status = fileUploadHelper.uploadFile(file);
        try {
            if (fileupload_status) {

                System.out.println("file is successfully uploaded");
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/")
                        .path(file.getOriginalFilename()).toUriString());
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File is not uploaded");
            }

        } catch (Exception e) {

        }

        return ResponseEntity.ok("working fine");
    }
}
