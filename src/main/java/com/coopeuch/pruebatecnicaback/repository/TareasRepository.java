package com.coopeuch.pruebatecnicaback.repository;

import com.coopeuch.pruebatecnicaback.domain.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareasRepository extends JpaRepository<Tarea, Long> {
}
