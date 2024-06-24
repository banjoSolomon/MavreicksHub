package com.solo.mavreickshub.services;

import com.solo.mavreickshub.dtos.request.CreateUserRequest;
import com.solo.mavreickshub.dtos.response.CreateUserResponse;
import com.solo.mavreickshub.exception.UserNotFoundException;
import com.solo.mavreickshub.models.User;
import com.solo.mavreickshub.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MavericksHubUserService implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public MavericksHubUserService(UserRepository userRepository,ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public CreateUserResponse register(CreateUserRequest request) {
      User user =  modelMapper.map(request, User.class);
      user= userRepository.save(user);
      var response = modelMapper.map(request, CreateUserResponse.class);
      response.setMessage("user registered successfully");
      return response;
    }

    @Override
    public User getById(long id) {
        return userRepository.findById(id).
                orElseThrow(()-> new UserNotFoundException(
                        String.format("user with id %d not found", id)));

    }

    @Override
    public User getUserByUsername(String username) {
       User user =  userRepository.findByEmail(username).orElseThrow(()-> new UserNotFoundException("user not found"));
        return user;
    }
}
