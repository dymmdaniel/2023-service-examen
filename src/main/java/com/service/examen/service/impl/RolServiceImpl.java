package com.service.examen.service.impl;

import com.service.examen.model.Rol;
import com.service.examen.repository.RolRepository;
import com.service.examen.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;


    @Override
    public Rol buscarRol(Long id) {
        return rolRepository.findById(id).orElse(null);
    }
}
