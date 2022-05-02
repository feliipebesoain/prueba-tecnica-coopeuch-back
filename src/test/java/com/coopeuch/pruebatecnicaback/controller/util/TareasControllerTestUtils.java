package com.coopeuch.pruebatecnicaback.controller.util;

import com.coopeuch.pruebatecnicaback.dto.EditTareaRequest;
import com.coopeuch.pruebatecnicaback.dto.NewTareaRequest;

public class TareasControllerTestUtils {

    public static NewTareaRequest getMockNewTareaRequest(String descripcion, Boolean vigente) {
        NewTareaRequest request = new NewTareaRequest();
        request.setDescripcion(descripcion);
        request.setVigente(vigente);
        return request;
    }

    public static EditTareaRequest getMockEditTareaRequest(String descripcion, Boolean vigente, Long identificador) {
        EditTareaRequest request = new EditTareaRequest();
        request.setDescripcion(descripcion);
        request.setVigente(vigente);
        request.setIdentificador(identificador);
        return request;
    }
}
