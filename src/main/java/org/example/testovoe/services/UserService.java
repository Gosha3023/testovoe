package org.example.testovoe.services;

import org.example.testovoe.DTO.StatusResponse;
import org.example.testovoe.DTO.UserDto;
import org.example.testovoe.Exception.NotSuchUserException;
import org.example.testovoe.Specifications.UserSpecification;
import org.example.testovoe.models.UserModel;
import org.example.testovoe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Long saveUser(UserDto user) {
        user.setStatus(false);
        UserModel userModel = DtoToEntity(user);
        userModel.setTimestamp(new Timestamp(new Date().getTime()));
        userRepository.save(userModel);
        return userModel.getId();
    }
    public StatusResponse changeStatus(Long id, Boolean status){
        Optional<UserModel> userModel = userRepository.findById(id);
        if (userModel.isPresent()) {
            StatusResponse statusResponse = new StatusResponse(id, userModel.get().getStatus(), status);
            userModel.get().setStatus(status);
            userRepository.save(userModel.get());
            return statusResponse;
        }
        throw new NotSuchUserException("Пользователь с указаным id не найден");

    }
    public UserDto getUser(Long id) throws InterruptedException {
            Thread.sleep(10_000);
        if (!userRepository.existsById(id))
            throw new NotSuchUserException("Пользователь с указаным id не найден");
        return entityToDTO(userRepository.findById(id).get());
    }

    public List<UserModel> getStatistics(Boolean status, Timestamp timestamp){
        Specification<UserModel> specification = Specification.where(UserSpecification.equalStatus(status))
                .and(UserSpecification.greaterThanTimestamp(timestamp));
        return userRepository.findAll(specification);
    }

    public UserDto entityToDTO(UserModel user) {
        return new UserDto(user);
    }

    public UserModel DtoToEntity(UserDto userDto) {
        return new UserModel(userDto);
    }
}