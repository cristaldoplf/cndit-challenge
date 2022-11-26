package com.example.testcandoit.controller;

import com.example.testcandoit.repository.UserRepository;
import com.example.testcandoit.service.Impl.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.testcandoit.model.dto.AuthenticationRequestDto;
import com.example.testcandoit.model.dto.UserDto;
import com.example.testcandoit.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    ObjectMapper objectMapper;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
        User existingUser = objectMapper.convertValue(userService.findByEmail(userDto.getEmail()), User.class);

        if (existingUser != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists.");
        } else {
            try {
                userService.saveUser(userDto);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (Exception e) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("error: " + e.getMessage());
            }

        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody AuthenticationRequestDto userDto){
        Optional<User> user = userService.findByEmail(userDto.getEmail());
        if (user.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        UserDto userDtoResponse = objectMapper.convertValue(user, UserDto.class);
        UserDto userResponse = new UserDto();
        userResponse.setId(userDtoResponse.getId());
        userResponse.setName(userDtoResponse.getName());
        userResponse.setEmail(userDtoResponse.getEmail());
        userResponse.setRol(userDtoResponse.getRol());
        userResponse.setToken(userService.logInUser(userDto));
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }


}
