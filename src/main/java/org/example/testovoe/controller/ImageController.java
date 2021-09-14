package org.example.testovoe.controller;

import org.example.testovoe.service.FileService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/images")
public class ImageController {
    private final FileService fileService;

    public ImageController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public ResponseEntity<String> postImage(@RequestParam("file") MultipartFile excel) throws IOException {
        System.out.println(excel.getOriginalFilename());
        System.out.println(excel.getName());
        System.out.println(excel.getContentType());
        System.out.println(excel);
        Thread.yield();
        return new ResponseEntity<>(fileService.uploadImage(excel), new HttpHeaders(), HttpStatus.OK);
    }
}
