package com.example.vehiculo.controller;

import com.example.vehiculo.dto.VehiculoRequest;
import com.example.vehiculo.dto.VehiculoResponse;
import com.example.vehiculo.service.VehiculoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    @GetMapping
    public ResponseEntity<List<VehiculoResponse>> findAll() {
        return ResponseEntity.ok(vehiculoService.findAll());
    }

    @GetMapping("/{patente}")
    public ResponseEntity<VehiculoResponse> findByRut(@PathVariable String patente) {
        return ResponseEntity.ok(vehiculoService.findByPatente(patente));
    }

    @PostMapping
    public ResponseEntity<VehiculoResponse> create(@Valid @RequestBody VehiculoRequest request) {
        VehiculoResponse creado = vehiculoService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{patente}")
    public ResponseEntity<VehiculoResponse> update(@PathVariable String patente, @Valid @RequestBody VehiculoRequest request) {
        return ResponseEntity.ok(vehiculoService.update(patente, request));
    }

    @DeleteMapping("/{patente}")
    public ResponseEntity<Void> deleteByPatente(@PathVariable String patente) {
        vehiculoService.deleteByPatente(patente);
        return ResponseEntity.noContent().build();
    }
}
