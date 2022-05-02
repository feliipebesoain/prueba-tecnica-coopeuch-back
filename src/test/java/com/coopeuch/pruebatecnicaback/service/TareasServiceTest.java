package com.coopeuch.pruebatecnicaback.service;

import com.coopeuch.pruebatecnicaback.controller.util.TareasControllerTestUtils;
import com.coopeuch.pruebatecnicaback.domain.Tarea;
import com.coopeuch.pruebatecnicaback.dto.NewTareaRequest;
import com.coopeuch.pruebatecnicaback.repository.TareasRepository;
import com.coopeuch.pruebatecnicaback.service.impl.TareasServiceImpl;
import com.coopeuch.pruebatecnicaback.service.util.TareasServiceTestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
class TareasServiceTest {

    @InjectMocks
    private TareasServiceImpl tareasService;

    @Mock
    private TareasRepository tareasRepository;

    @Test
    @DisplayName("shouldThrowIncorrectExeptionWhenTareaIsNull")
    void shouldThrowIncorrectExeptionWhenTareaIsNull() {
        List<Tarea> tareasResponse = new ArrayList<>();
        tareasResponse.add(new Tarea());
        tareasResponse.add(new Tarea());
        tareasResponse.add(new Tarea());

        Mockito.when(tareasRepository.findAll()).thenReturn(tareasResponse);
        List<Tarea> response = tareasService.findAll();

        assert response != null;

        Assertions.assertEquals(3, response.size());
        Mockito.verify(tareasRepository).findAll();
    }


    @Test
    @DisplayName("Crear tarea retorna Ok")
    void shouldReturnNewTareaWhenCreateOk() {

        Tarea tareaRequest = TareasServiceTestUtils.getMockNewTarea("Descripcion", true);

        Tarea tareaResponse = new Tarea();
        tareaResponse.setDescripcion(tareaRequest.getDescripcion());
        tareaResponse.setVigente(tareaRequest.getVigente());
        tareaResponse.setIdentificador(1L);
        tareaResponse.setFechaCreacion(LocalDateTime.now());

        Mockito.when(tareasRepository.save(any(Tarea.class))).thenReturn(tareaResponse);

        Tarea response = tareasService.saveTarea(tareaResponse);
        Assertions.assertEquals(tareaResponse, response);
        Mockito.verify(tareasRepository).save(any(Tarea.class));
    }

    @Test
    @DisplayName("Editar tarea retorna Ok")
    void shouldReturnNewTareaWhenEditOk() {

        Tarea tareaRequest = TareasServiceTestUtils.getMockEditTarea("Descripcion", true, 1L);

        Tarea tareaResponse = new Tarea();
        tareaResponse.setDescripcion(tareaRequest.getDescripcion());
        tareaResponse.setVigente(tareaRequest.getVigente());
        tareaResponse.setIdentificador(1L);
        tareaResponse.setFechaCreacion(LocalDateTime.now());

        Optional<Tarea> findByIdResponse = Optional.of(new Tarea());

        Mockito.when(tareasRepository.findById(any(Long.class))).thenReturn(findByIdResponse);
        Mockito.when(tareasRepository.save(any(Tarea.class))).thenReturn(tareaResponse);

        Tarea response = tareasService.updateTarea(tareaResponse);
        Assertions.assertEquals(tareaResponse, response);
        Mockito.verify(tareasRepository).save(any(Tarea.class));
        Mockito.verify(tareasRepository).findById(any(Long.class));
    }


}
