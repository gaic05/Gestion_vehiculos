package com.example.metodoPago.controller;

import com.example.metodoPago.dto.MetodoPagoRequest;
import com.example.metodoPago.dto.MetodoPagoResponse;
import com.example.metodoPago.service.MetodoPagoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pagos")
public class MetodoPagoController {
    private final MetodoPagoService metodoPagoService;
    @GetMapping
    public ResponseEntity<List<MetodoPagoResponse>> findAll() {
        return ResponseEntity.ok(metodoPagoService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<MetodoPagoResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(metodoPagoService.findById(id));
    }
    @PostMapping
    public ResponseEntity<MetodoPagoResponse> create(
            @Valid @RequestBody MetodoPagoRequest request) {
        MetodoPagoResponse creado = metodoPagoService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MetodoPagoResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody MetodoPagoRequest request) {
        return ResponseEntity.ok(metodoPagoService.update(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        metodoPagoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
