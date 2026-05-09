package com.example.tecnico.controller;

import com.example.tecnico.dto.TecnicoRequest;
import com.example.tecnico.dto.TecnicoResponse;
import com.example.tecnico.service.TecnicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tecnicos")
public class TecnicoController {

    private final TecnicoService tecnicoService;
    @GetMapping
    public ResponseEntity<List<TecnicoResponse>> findAll() {
        return ResponseEntity.ok(tecnicoService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TecnicoResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(tecnicoService.findById(id));
    }
    @PostMapping
    public ResponseEntity<TecnicoResponse> create(
            @Valid @RequestBody TecnicoRequest request) {
        TecnicoResponse creado = tecnicoService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TecnicoResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody TecnicoRequest request) {
        return ResponseEntity.ok(tecnicoService.update(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        tecnicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
