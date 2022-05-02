package com.coopeuch.pruebatecnicaback.domain;

import com.coopeuch.pruebatecnicaback.dto.TareaDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarea implements Serializable {

    private static final long serialVersionUID = 2662470354995853049L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "id_generator", sequenceName = "id_sequence")
    @NotNull
    private Long identificador;

    private String descripcion;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @CreatedDate
    private LocalDateTime fechaCreacion;

    private Boolean vigente;

    public Tarea(TareaDTO tareaDTO) {
        this.identificador = tareaDTO.getIdentificador();
        this.descripcion = tareaDTO.getDescripcion();
        this.fechaCreacion = tareaDTO.getFechaCreacion();
        this.vigente = tareaDTO.isVigente();
    }
}
