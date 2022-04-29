package com.coopeuch.pruebatecnicaback.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TareaDTO {
    private Long identificador;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private boolean vigente;
}
