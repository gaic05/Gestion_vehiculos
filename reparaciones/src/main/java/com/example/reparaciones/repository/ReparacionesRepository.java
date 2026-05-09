package com.example.reparaciones.repository;

import com.example.reparaciones.model.Reparaciones;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReparacionesRepository extends JpaRepository<Reparaciones, Long> {
    Optional<Reparaciones> findById(Long id);
    void deleteById(Long id);
    boolean existsById(Long id);
}
