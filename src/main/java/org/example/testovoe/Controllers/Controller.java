package org.example.testovoe.Controllers;

import org.example.testovoe.DTO.StatisticsRequestDTO;
import org.example.testovoe.DTO.StatusDto;
import org.example.testovoe.DTO.StatusResponse;
import org.example.testovoe.DTO.UserDto;
import org.example.testovoe.models.UserModel;
import org.example.testovoe.services.FileService;
import org.example.testovoe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/api/")
public class Controller {

    @Autowired
    UserService userService;
    @Autowired
    FileService fileService;
    @PostMapping("users")
    public ResponseEntity<Long> createUser(@RequestBody @Valid UserDto user) {
        return new ResponseEntity<>(userService.saveUser(user), new HttpHeaders(), HttpStatus.CREATED);
    }
    @PostMapping("loader")
    public ResponseEntity<String> loadImage(@RequestBody MultipartFile file) {
        return new ResponseEntity<>(fileService.saveUploadImage(file),new HttpHeaders(), HttpStatus.OK);
    }

    @PatchMapping("users/{id}")
    public ResponseEntity<StatusResponse> changeStatus(@RequestBody @Valid StatusDto status, @PathVariable Long id){
        return new ResponseEntity<>(userService.changeStatus(id, status.getStatus()), new HttpHeaders(), HttpStatus.OK);
    }

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @GetMapping("users/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) throws InterruptedException {
        return new ResponseEntity<>(userService.getUser(id), new HttpHeaders(), HttpStatus.OK);
    }

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @GetMapping("users/statistics")
    public ResponseEntity<List<UserModel>> getStatistics(@RequestBody StatisticsRequestDTO requestDTO) {
        return new ResponseEntity<>(userService.getStatistics(requestDTO.getStatus(), requestDTO.getTimestamp()), new HttpHeaders(), HttpStatus.OK);
    }
}
