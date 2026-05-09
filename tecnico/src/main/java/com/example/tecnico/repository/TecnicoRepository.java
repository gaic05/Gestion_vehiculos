package com.example.tecnico.repository;

import com.example.tecnico.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long>  {
    Optional<Tecnico> findById(Long id);
    void deleteById(Long id);

    boolean existsById(Long id);
}
