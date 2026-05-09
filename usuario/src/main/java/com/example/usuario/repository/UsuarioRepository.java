package com.example.usuario.repository;

import com.example.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByRut(Long rut);
    void deleteByRut(Long rut);

    boolean existsByRut(Long rut);
}