package org.example.testovoe.services;

import org.example.testovoe.Exception.FileIncorrectFormatException;
import org.example.testovoe.Exception.ValueEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {
    @Autowired
    MultipartProperties multipartProperties;
    @Value("${IMAGE_PATH}")
    private String imagePath;
    public String saveUploadImage(MultipartFile file) {
        if (file.isEmpty())
            throw new ValueEmptyException("пустой файл");
        if (!file.getContentType().contains("image"))
            throw new FileIncorrectFormatException("некорректный формат");


        Path path = Paths.get(multipartProperties.getLocation() + file.getOriginalFilename());
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Произошла ошибка при загрузке файла");
        }


        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(imagePath)
                .path(file.getOriginalFilename())
                .toUriString();
        return fileDownloadUri;
    }

    public boolean exists(URI fileName) {
        File file = new File(multipartProperties.getLocation() + fileName);
        return file.exists();
    }
}
