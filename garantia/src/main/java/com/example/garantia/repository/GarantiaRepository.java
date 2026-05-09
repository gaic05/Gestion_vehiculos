package com.example.garantia.repository;

import com.example.garantia.model.Garantia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GarantiaRepository extends JpaRepository<Garantia, Long> {
}
