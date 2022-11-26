package com.example.testcandoit.controller;

import com.example.testcandoit.model.dto.UserDto;
import com.example.testcandoit.service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    ResponseEntity<?> getUser(@PathVariable Integer id){
        UserDto userDto = userService.findUserById(id);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PutMapping("/update")
    ResponseEntity<?> updateUser(@RequestBody UserDto userDto){
        userService.updateUser(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
