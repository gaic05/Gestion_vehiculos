package com.example.agendamiento.controller;

import com.example.agendamiento.dto.AgendamientoRequest;
import com.example.agendamiento.dto.AgendamientoResponse;
import com.example.agendamiento.service.AgendamientoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/agendamientos")
public class AgendamientoController {
    private final AgendamientoService agendamientoService;
    @GetMapping
    public ResponseEntity<List<AgendamientoResponse>> findAll() {
        return ResponseEntity.ok(agendamientoService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<AgendamientoResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(agendamientoService.findById(id));
    }
    @PostMapping
    public ResponseEntity<AgendamientoResponse> create(
            @Valid @RequestBody AgendamientoRequest request) {
        AgendamientoResponse creado = agendamientoService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AgendamientoResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody AgendamientoRequest request) {
        return ResponseEntity.ok(agendamientoService.update(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        agendamientoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
