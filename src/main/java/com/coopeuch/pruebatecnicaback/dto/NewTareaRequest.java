package com.coopeuch.pruebatecnicaback.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
public class NewTareaRequest {

    @NotNull(message = "La descripción es obligatoria")
    @NotEmpty
    private String descripcion;

    @NotNull(message = "La vigencia es obligatoria")
    private Boolean vigente;


}
