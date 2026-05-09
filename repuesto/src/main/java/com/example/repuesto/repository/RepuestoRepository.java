package com.example.repuesto.repository;
import com.example.repuesto.model.Repuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepuestoRepository extends JpaRepository<Repuesto, Long> {
    Optional<Repuesto> findById(Long id);
    boolean existsById(Long id);
}
