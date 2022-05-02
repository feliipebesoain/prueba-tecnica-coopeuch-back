package com.coopeuch.pruebatecnicaback.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
public class EditTareaRequest {

    @NotNull(message = "La descripción es obligatoria")
    @NotEmpty
    private Long identificador;

    @NotNull
    private String descripcion;

    @NotNull
    private Boolean vigente;

}
