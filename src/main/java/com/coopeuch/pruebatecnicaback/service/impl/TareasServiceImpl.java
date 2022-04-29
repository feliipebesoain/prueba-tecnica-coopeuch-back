package com.coopeuch.pruebatecnicaback.service.impl;

import com.coopeuch.pruebatecnicaback.domain.Tarea;
import com.coopeuch.pruebatecnicaback.repository.TareasRepository;
import com.coopeuch.pruebatecnicaback.service.TareasService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareasServiceImpl implements TareasService {

    private final TareasRepository tareaRepository;

    public TareasServiceImpl(TareasRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    @Override
    public List<Tarea> findAll() {
        return tareaRepository.findAll();
    }

    @Override
    public Tarea saveTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public Tarea updateTarea(Tarea tarea) {
        Optional<Tarea> tareaToUpdate = tareaRepository.findById(tarea.getIdentificador());

        /* Valida que la tarea a actualizar exista */
        if (tareaToUpdate.isPresent()) {
            /* Evitar que se actualice la fecha de creacion */
            tarea.setFechaCreacion(tareaToUpdate.get().getFechaCreacion());
            return tareaRepository.save(tarea);
        }

        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        tareaRepository.deleteById(id);
        return true;
    }

}
