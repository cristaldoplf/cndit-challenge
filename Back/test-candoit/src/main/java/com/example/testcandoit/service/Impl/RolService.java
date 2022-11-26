package com.example.testcandoit.service.Impl;

import com.example.testcandoit.model.entity.Rol;
import com.example.testcandoit.model.enums.RolName;
import com.example.testcandoit.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Rol findByRolName(RolName rolName){
        return  rolRepository.findByRolName(rolName);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
