package com.example.garantia.service;

import com.example.garantia.dto.GarantiaRequest;
import com.example.garantia.dto.GarantiaResponse;
import com.example.garantia.exception.GarantiaNotFoundException;
import com.example.garantia.mapper.GarantiaMapper;
import com.example.garantia.model.Garantia;
import com.example.garantia.repository.GarantiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GarantiaService {
    private final GarantiaRepository garantiaRepository;
    private final GarantiaMapper garantiaMapper;
    public List<GarantiaResponse> findAll() {
        return garantiaMapper.toResponseList(garantiaRepository.findAll());
    }
    public GarantiaResponse findById(Long id) {
        Garantia garantia = garantiaRepository.findById(id)
                .orElseThrow(() -> new GarantiaNotFoundException(id));
        return garantiaMapper.toResponse(garantia);
    }
    public GarantiaResponse create(GarantiaRequest request) {
        Garantia garantia = garantiaMapper.toEntity(request);
        Garantia saved = garantiaRepository.save(garantia);
        return garantiaMapper.toResponse(saved);
    }
    public GarantiaResponse update(Long id, GarantiaRequest request) {
        Garantia garantia = garantiaRepository.findById(id)
                .orElseThrow(() -> new GarantiaNotFoundException(id));
        garantia.setFechaInicio(request.getFechaInicio());
        garantia.setFechaFin(request.getFechaFin());
        garantia.setTipoGarantia(request.getTipoGarantia());
        garantia.setEstado(request.getEstado());

        Garantia updated = garantiaRepository.save(garantia);
        return garantiaMapper.toResponse(updated);
    }
    public void delete(Long id) {
        if (!garantiaRepository.existsById(id)) {
            throw new GarantiaNotFoundException(id);
        }
        garantiaRepository.deleteById(id);
    }
}
