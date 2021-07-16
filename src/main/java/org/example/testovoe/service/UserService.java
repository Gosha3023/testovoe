package org.example.testovoe.service;

import org.example.testovoe.dto.StatusResponseDto;
import org.example.testovoe.dto.UserDto;
import org.example.testovoe.exception.NotSuchUserException;
import org.example.testovoe.model.UserModel;
import org.example.testovoe.repositorie.UserRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long saveUser(UserDto user) {
        user.setStatus(false);
        UserModel userModel = dtoToEntity(user);
        userModel.setTimestamp(LocalDateTime.now());
        userRepository.save(userModel);
        return userModel.getId();
    }

    public StatusResponseDto changeStatus(Long id, Boolean status) {
        UserModel userModel = userRepository.findById(id).orElseThrow(NotSuchUserException::new);
        StatusResponseDto statusResponse = new StatusResponseDto(id, userModel.getStatus(), status);
        userModel.setStatus(status);
        userRepository.save(userModel);
        return statusResponse;
    }

    public UserDto getUser(Long id) throws InterruptedException {
        Thread.sleep(10_000);
        Optional<UserModel> userModel = userRepository.findById(id);
        return entityToDto(userModel.orElseThrow(NotSuchUserException::new));
    }

    public List<UserModel> getStatistics(Boolean status, LocalDateTime timestamp) {
        if (timestamp == null) {
            if (status == null) {
                return userRepository.findAll();
            }
            return userRepository.findAllByStatusEquals(status);
        }
        if (status == null) {
            return userRepository.findAllByTimestampAfter(timestamp);
        }
        return userRepository.findAllByStatusEqualsAndTimestampAfter(status, timestamp);
    }

    public UserDto entityToDto(UserModel user) {
        return new UserDto(user);
    }

    public UserModel dtoToEntity(UserDto userDto) {
        return new UserModel(userDto);
    }
}