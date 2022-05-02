package com.coopeuch.pruebatecnicaback.controller;

import com.coopeuch.pruebatecnicaback.domain.Tarea;
import com.coopeuch.pruebatecnicaback.dto.EditTareaRequest;
import com.coopeuch.pruebatecnicaback.dto.NewTareaRequest;
import com.coopeuch.pruebatecnicaback.service.TareasService;
import com.coopeuch.pruebatecnicaback.controller.util.TareasControllerTestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
class TareasControllerTest {

    @InjectMocks
    private TareasController tareasController;

    @Mock
    private TareasService tareasService;

    @Test
    @DisplayName("Listar devuelve ok")
    void shouldReturnListWhenListarOk() {
        List<Tarea> tareasResponse = new ArrayList<>();
        tareasResponse.add(new Tarea());
        tareasResponse.add(new Tarea());

        Mockito.when(tareasService.findAll()).thenReturn(tareasResponse);
        List<Tarea> response = tareasController.getAll().getBody();

        assert response != null;
        Assertions.assertEquals(2, response.size());
        Mockito.verify(tareasService).findAll();

    }

    @Test
    @DisplayName("Crear tarea retorna Ok")
    void shouldReturnNewTareaWhenCreateOk() {

        NewTareaRequest request = TareasControllerTestUtils.getMockNewTareaRequest("descripcion", true);

        Tarea tareaResponse = new Tarea();
        tareaResponse.setDescripcion(request.getDescripcion());
        tareaResponse.setVigente(request.getVigente());
        tareaResponse.setIdentificador(1L);
        tareaResponse.setFechaCreacion(LocalDateTime.now());

        Mockito.when(tareasService.saveTarea(any(Tarea.class))).thenReturn(tareaResponse);
        Tarea response = tareasController.createTarea(request).getBody();
        Assertions.assertEquals(tareaResponse, response);
        Mockito.verify(tareasService).saveTarea(any(Tarea.class));
    }

    @Test
    @DisplayName("Actualizar tarea retorna tarea actualizada cuando ok")
    void shouldRetunTareaUpdatedWhenUpdateOk() {

        EditTareaRequest request = TareasControllerTestUtils.getMockEditTareaRequest("descripcion", true, 1L);

        Tarea tareaResponse = new Tarea(request);
        tareaResponse.setIdentificador(1L);
        tareaResponse.setFechaCreacion(LocalDateTime.now());

        Mockito.when(tareasService.updateTarea(any(Tarea.class))).thenReturn(tareaResponse);
        ResponseEntity<Object> response = tareasController.updateTarea(request);
        Assertions.assertEquals(tareaResponse, response.getBody());
        Mockito.verify(tareasService).updateTarea(any(Tarea.class));
    }

    @Test
    @DisplayName("Actualizar tarea retorna error")
    void shouldRetunErrorWhenUpdateIsResponseIsNull() {

        EditTareaRequest request = TareasControllerTestUtils.getMockEditTareaRequest("descripcion", true, -1L);
        Mockito.when(tareasService.updateTarea(any(Tarea.class))).thenReturn(null);

        ResponseEntity<Object> response = tareasController.updateTarea(request);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Mockito.verify(tareasService).updateTarea(any(Tarea.class));
    }

    @Test
    @DisplayName("Eliminar tarea retorna ok")
    void shouldRetunOkWhenTareaWasDeleted() {

        Mockito.when(tareasService.deleteById(any(Long.class))).thenReturn(true);

        ResponseEntity<String> response = tareasController.deleteById(1L);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Mockito.verify(tareasService).deleteById(any(Long.class));
    }

}
