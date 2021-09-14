package org.example.testovoe.controller;

import org.example.testovoe.dto.StatusRequestDto;
import org.example.testovoe.dto.StatusResponseDto;
import org.example.testovoe.dto.UserDto;
import org.example.testovoe.model.UserModel;
import org.example.testovoe.repositorie.UserRepository;
import org.example.testovoe.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<Long> postUser(@RequestBody @Valid UserDto user) {
        Thread.yield();
        return new ResponseEntity<>(userService.saveUser(user), new HttpHeaders(), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StatusResponseDto> patchUserStatus(@RequestBody @Valid StatusRequestDto status, @PathVariable Long id) {
        Thread.yield();
        return new ResponseEntity<>(userService.changeStatus(id, status.getStatus()), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) throws InterruptedException {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        return new ResponseEntity<>(userService.getUser(id), new HttpHeaders(), HttpStatus.OK);
        //{}//
    }

    @GetMapping("/statistics")
    public ResponseEntity<List<UserModel>> getStatistics(@RequestParam(value = "timestamp", required = false) LocalDateTime timestamp,
                                                         @RequestParam(value = "status", required = false) Boolean status){
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        return new ResponseEntity<>(userService.getStatistics(status, timestamp), new HttpHeaders(), HttpStatus.OK);
    }
    @PutMapping("/test")
    public HttpStatus putUserModel(@RequestBody List<UserDto> userModelList){
        for (UserDto userDto: userModelList) {
            userRepository.save(new UserModel(userDto));

        }
        return HttpStatus.OK;
    }


}