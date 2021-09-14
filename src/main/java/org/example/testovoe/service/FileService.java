package org.example.testovoe.service;

import org.example.testovoe.exception.FileEmptyException;
import org.example.testovoe.exception.FileIncorrectFormatException;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {
    private final MultipartProperties multipartProperties;

    public FileService(MultipartProperties multipartProperties) {
        this.multipartProperties = multipartProperties;
    }

    public String uploadImage(MultipartFile file) {
        if (file == null) {
            throw new NullPointerException("файл отсутствует");
        }
        if (file.isEmpty()) {
            throw new FileEmptyException();
        }
        String fileType = file.getContentType();
        String fileName = file.getOriginalFilename();
        if (fileName == null || fileType == null || !fileType.contains("image")) {
            throw new FileIncorrectFormatException();
        }

        Path path = Paths.get(multipartProperties.getLocation() + fileName);
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Произошла ошибка при загрузке файла");
        }


        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/")
                .path(fileName)
                .toUriString();
    }
}
