package com.example.garantia.controller;

import com.example.garantia.dto.GarantiaRequest;
import com.example.garantia.dto.GarantiaResponse;
import com.example.garantia.service.GarantiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/garantias")
public class GarantiaController {
    private final GarantiaService garantiaService;
    @GetMapping("/{id}")
    public ResponseEntity<List<GarantiaResponse>> findAll(){return ResponseEntity.ok(garantiaService.findAll());}
    @PostMapping
    public ResponseEntity<GarantiaResponse> create(@RequestBody GarantiaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(garantiaService.create(request));
    }
    @PutMapping("/{id}")
    public ResponseEntity<GarantiaResponse> update(@PathVariable Long id, @RequestBody GarantiaRequest request){
        return ResponseEntity.ok(garantiaService.update(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        garantiaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
