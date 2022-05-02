package com.coopeuch.pruebatecnicaback.controller;

import com.coopeuch.pruebatecnicaback.domain.Tarea;
import com.coopeuch.pruebatecnicaback.dto.EditTareaRequest;
import com.coopeuch.pruebatecnicaback.dto.NewTareaRequest;
import com.coopeuch.pruebatecnicaback.service.TareasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path = "tareas", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class TareasController {

    private final TareasService tareasService;

    public TareasController(TareasService tareasService) {
        this.tareasService = tareasService;
    }

    @GetMapping(path = "")
    public ResponseEntity<List<Tarea>> getAll() {
        return new ResponseEntity<>(tareasService.findAll(), HttpStatus.ACCEPTED);
    }

    @PostMapping()
    public ResponseEntity<Tarea> createTarea(@Valid @RequestBody NewTareaRequest request) {
        Tarea tarea = new Tarea(request);
        return new ResponseEntity<>(this.tareasService.saveTarea(tarea), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Object> updateTarea(@RequestBody EditTareaRequest request) {
        Tarea tarea = new Tarea(request);
        Tarea response = this.tareasService.updateTarea(tarea);
        if (response != null) {
            return new ResponseEntity<>(this.tareasService.saveTarea(response), HttpStatus.OK);
        }
        return new ResponseEntity<>("No se encontró la tarea", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(path = "")
    public ResponseEntity<String> deleteById(@RequestParam Long id) {
        tareasService.deleteById(id);
        return new ResponseEntity<>("Tarea eliminada con éxito", HttpStatus.OK);
    }


}
