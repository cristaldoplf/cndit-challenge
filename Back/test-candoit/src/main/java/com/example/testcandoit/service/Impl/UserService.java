package com.example.testcandoit.service.Impl;

import com.example.testcandoit.Security.jwt.JwtUtil;
import com.example.testcandoit.model.dto.AuthenticationRequestDto;
import com.example.testcandoit.model.dto.UserDto;
import com.example.testcandoit.model.entity.Rol;
import com.example.testcandoit.model.entity.User;
import com.example.testcandoit.model.enums.RolName;
import com.example.testcandoit.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;

    private final RolService rolService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    private final CustomeUserDetailsService userDetailsService;

    private final ObjectMapper objectMapper;

    @Autowired
    public UserService(UserRepository userRepository, RolService rolService, BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationManager authenticationManager, JwtUtil jwtUtil, CustomeUserDetailsService userDetailsService, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.rolService = rolService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        this.objectMapper = objectMapper;
    }

    private Authentication authentication(AuthenticationRequestDto userDto){
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword()));
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Incorrect password and/or email. Please try again.");
        }
        return authentication;
    }

//    private void checkMailIsAvailable(String email){
//        if (userRepository.existsByEmail(email))
//            throw new EmailAlreadyInUseException(email + " this mail is already in use by other user");
//    }

    public void saveUser(UserDto userToSave) {

//        checkMailIsAvailable(userToSave.getEmail());

        User user = new User();
        user.setName(userToSave.getName());
        user.setEmail(userToSave.getEmail());
        user.setAdress(userToSave.getAdress());
        Rol rolAsignado= rolService.findByRolName(RolName.ROLE_USER);
        user.setRol(rolAsignado);
        user.setPassword(bCryptPasswordEncoder.encode(userToSave.getPassword()));

        userRepository.save(user);

    }

    public String logInUser(AuthenticationRequestDto user) {

        Authentication authentication = authentication(user);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());

        return jwtUtil.generateToken(userDetails);

    }

    public UserDto findUserById(Integer id){
        return objectMapper.convertValue(userRepository.findById(id), UserDto.class);
    }

    public void updateUser(UserDto userDto){
        User user = userRepository.findById(userDto.getId()).get();
        if (userDto.getAdress() != null){
            user.setAdress(userDto.getAdress());
        }
        userRepository.save(user);
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
