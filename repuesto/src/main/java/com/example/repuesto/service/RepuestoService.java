package com.example.repuesto.service;

import com.example.repuesto.dto.RepuestoRequest;
import com.example.repuesto.dto.RepuestoResponse;
import com.example.repuesto.exception.RepuestoNotFoundException;
import com.example.repuesto.mapper.RepuestoMapper;
import com.example.repuesto.model.Repuesto;
import com.example.repuesto.repository.RepuestoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RepuestoService {

    private final RepuestoRepository repuestoRepository;
    private final RepuestoMapper repuestoMapper;

    public List<RepuestoResponse> findAll() {
        return repuestoMapper.toResponseList(repuestoRepository.findAll());
    }
    public RepuestoResponse findById(Long id) {
        Repuesto repuesto = repuestoRepository.findById(id)
                .orElseThrow(() -> new RepuestoNotFoundException(id));
        return repuestoMapper.toResponse(repuesto);
    }
    public RepuestoResponse create(RepuestoRequest request) {
        if (repuestoRepository.existsById(request.getCodRepuesto())) {
            throw new IllegalArgumentException(
                    "Ya existe un repuesto con ID: " + request.getCodRepuesto()
            );
        }
        Repuesto repuesto = repuestoMapper.toEntity(request);
        Repuesto saved = repuestoRepository.save(repuesto);
        return repuestoMapper.toResponse(saved);
    }
    public void deleteById(Long id) {
        if (!repuestoRepository.existsById(id)) {
            throw new RepuestoNotFoundException(id);
        }
        repuestoRepository.deleteById(id);
    }
    public RepuestoResponse update(Long id, RepuestoRequest request) {
        Repuesto repuesto = repuestoRepository.findById(id)
                .orElseThrow(() -> new RepuestoNotFoundException(id));
        repuesto.setCodRepuesto(request.getCodRepuesto());
        repuesto.setNombre(request.getNombre());
        repuesto.setValor(request.getValor());
        Repuesto updated = repuestoRepository.save(repuesto);
        return repuestoMapper.toResponse(updated);
    }
}
