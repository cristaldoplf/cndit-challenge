package com.example.testcandoit.utils;

import com.example.testcandoit.model.entity.Rol;
import com.example.testcandoit.model.entity.User;
import com.example.testcandoit.model.enums.RolName;
import com.example.testcandoit.repository.RolRepository;
import com.example.testcandoit.repository.UserRepository;
import com.example.testcandoit.service.Impl.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationRunner {


    private UserRepository userRepository;
    private RolRepository repository;
    private RolService rolService;

    @Autowired
    public DataLoader(UserRepository userRepository, RolRepository rolRepository, RolService rolService){
        this.userRepository =userRepository;
        this.repository = rolRepository;
        this.rolService = rolService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Rol rolAdmin = new Rol();
        rolAdmin.setRolName(RolName.ROLE_ADMIN);
        Rol rolUser = new Rol();
        rolUser.setRolName(RolName.ROLE_USER);
        rolService.save(rolAdmin);
        rolService.save(rolUser);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("123456");

        User userAdmin =new User();
        userAdmin.setName("Administrador");
        userAdmin.setPassword(password);
        userAdmin.setEmail("admin@admin.com");
        userAdmin.setRol(repository.findByRolName(RolName.ROLE_ADMIN));


        userRepository.save(userAdmin);
    }


}
