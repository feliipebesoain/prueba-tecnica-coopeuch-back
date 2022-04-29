package com.coopeuch.pruebatecnicaback.service.impl;

import com.coopeuch.pruebatecnicaback.domain.Tarea;
import com.coopeuch.pruebatecnicaback.repository.TareasRepository;
import com.coopeuch.pruebatecnicaback.service.TareasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareasServiceImpl implements TareasService {

    @Autowired
    private TareasRepository tareaRepository;

    @Override
    public List<Tarea> findAll() {
        return tareaRepository.findAll();
    }
}
