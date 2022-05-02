package com.coopeuch.pruebatecnicaback.service.util;

import com.coopeuch.pruebatecnicaback.domain.Tarea;

public class TareasServiceTestUtils {
    public static Tarea getMockNewTarea(String descripcion, Boolean vigente) {
        Tarea request = new Tarea();
        request.setDescripcion(descripcion);
        request.setVigente(vigente);
        return request;
    }

    public static Tarea getMockEditTarea(String descripcion, Boolean vigente, Long identificador) {
        Tarea edit = new Tarea();
        edit.setDescripcion(descripcion);
        edit.setVigente(vigente);
        edit.setIdentificador(identificador);
        return edit;
    }

}
