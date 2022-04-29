package com.coopeuch.pruebatecnicaback.controller;

import com.coopeuch.pruebatecnicaback.domain.Tarea;
import com.coopeuch.pruebatecnicaback.service.TareasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "tareas", produces = MediaType.APPLICATION_JSON_VALUE)
public class TareasController {

    @Autowired
    private TareasService tareasService;

    @GetMapping(path = "")
    public List<Tarea> getAll() {
        return tareasService.findAll();
    }
}
