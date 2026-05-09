package com.example.repuesto.controller;

import com.example.repuesto.dto.RepuestoRequest;
import com.example.repuesto.dto.RepuestoResponse;
import com.example.repuesto.service.RepuestoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/repuestos")
public class RepuestoController {

    private final RepuestoService repuestoService;
    @GetMapping
    public ResponseEntity<List<RepuestoResponse>> findAll() {
        return ResponseEntity.ok(repuestoService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<RepuestoResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(repuestoService.findById(id));
    }
    @PostMapping
    public ResponseEntity<RepuestoResponse> create(
            @Valid @RequestBody RepuestoRequest request) {

        RepuestoResponse creado = repuestoService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
    @PutMapping("/{id}")
        public ResponseEntity<RepuestoResponse> update(
                @PathVariable Long id,
                @Valid @RequestBody RepuestoRequest request) {
            return ResponseEntity.ok(repuestoService.update(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        repuestoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
