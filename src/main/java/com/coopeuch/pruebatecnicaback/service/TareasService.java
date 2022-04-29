package com.coopeuch.pruebatecnicaback.service;

import com.coopeuch.pruebatecnicaback.domain.Tarea;

import java.util.List;

public interface TareasService {

    List<Tarea> findAll();

    Tarea saveTarea(Tarea tarea);

    Tarea updateTarea(Tarea tarea);

    boolean deleteById(Long id);
}
