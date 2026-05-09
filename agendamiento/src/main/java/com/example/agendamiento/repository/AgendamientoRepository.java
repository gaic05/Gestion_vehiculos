package com.example.agendamiento.repository;

import com.example.agendamiento.model.Agendamiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgendamientoRepository extends JpaRepository<Agendamiento, Long> {
    Optional<Agendamiento> findById(Long id);
    void deleteById(Long id);
    boolean existsById(Long id);
}
