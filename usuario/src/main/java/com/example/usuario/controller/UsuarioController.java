package com.example.usuario.controller;

import com.example.usuario.dto.UsuarioRequest;
import com.example.usuario.dto.UsuarioResponse;
import com.example.usuario.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> findAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }
    @GetMapping("/{rut}")
    public ResponseEntity<UsuarioResponse> findByRut(@PathVariable Long rut) {
        return ResponseEntity.ok(usuarioService.findByRut(rut));
    }
    @PostMapping
    public ResponseEntity<UsuarioResponse> create(@Valid @RequestBody UsuarioRequest request) {
        UsuarioResponse creado = usuarioService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
    @PutMapping("/{rut}")
    public ResponseEntity<UsuarioResponse> update(@PathVariable Long rut, @Valid @RequestBody UsuarioRequest request) {
        return ResponseEntity.ok(usuarioService.update(rut, request));
    }
    @DeleteMapping("/{rut}")
    public ResponseEntity<Void> delete(@PathVariable Long rut) {
        usuarioService.deleteByRut(rut);
        return ResponseEntity.noContent().build();
    }
}
