package com.example.reparaciones.controller;

import com.example.reparaciones.dto.ReparacionesRequest;
import com.example.reparaciones.dto.ReparacionesResponse;
import com.example.reparaciones.service.ReparacionesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reparaciones")
public class ReparacionesController {

    private final ReparacionesService reparacionesService;
    @GetMapping
    public ResponseEntity<List<ReparacionesResponse>> findAll() {
        return ResponseEntity.ok(reparacionesService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ReparacionesResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(reparacionesService.findById(id));
    }
    @PostMapping
    public ResponseEntity<ReparacionesResponse> create(
            @Valid @RequestBody ReparacionesRequest request) {

        ReparacionesResponse creado = reparacionesService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ReparacionesResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody ReparacionesRequest request) {

        return ResponseEntity.ok(reparacionesService.update(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        reparacionesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
