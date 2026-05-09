package com.example.reparaciones.service;

import com.example.reparaciones.dto.ReparacionesRequest;
import com.example.reparaciones.dto.ReparacionesResponse;
import com.example.reparaciones.exceptions.ReparacionesNotFoundException;
import com.example.reparaciones.mapper.ReparacionesMapper;
import com.example.reparaciones.model.Reparaciones;
import com.example.reparaciones.repository.ReparacionesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReparacionesService {

    private final ReparacionesRepository reparacionesRepository;
    private final ReparacionesMapper reparacionesMapper;
    public List<ReparacionesResponse> findAll() {
        return reparacionesMapper.toResponseList(reparacionesRepository.findAll());
    }
    public ReparacionesResponse findById(Long id) {
        Reparaciones reparaciones = reparacionesRepository.findById(id)
                .orElseThrow(() -> new ReparacionesNotFoundException(id));
        return reparacionesMapper.toResponse(reparaciones);
    }
    public ReparacionesResponse create(ReparacionesRequest request) {
        Reparaciones reparaciones = reparacionesMapper.toModel(request);
        Reparaciones guardado = reparacionesRepository.save(reparaciones);
        return reparacionesMapper.toResponse(guardado);
    }
    public ReparacionesResponse update(Long id, ReparacionesRequest request) {

        Reparaciones existente = reparacionesRepository.findById(id)
                .orElseThrow(() -> new ReparacionesNotFoundException(id));
        existente.setTecnicoId(request.getTecnicoId());
        existente.setSolicitudId(request.getSolicitudId());
        existente.setDescripcion(request.getDescripcion());
        existente.setCosto(request.getCosto());
        existente.setFechaReparacion(request.getFechaReparacion());

        Reparaciones guardado = reparacionesRepository.save(existente);
        return reparacionesMapper.toResponse(guardado);
    }
    public void deleteById(Long id) {
        Reparaciones reparaciones = reparacionesRepository.findById(id)
                .orElseThrow(() -> new ReparacionesNotFoundException(id));
        reparacionesRepository.delete(reparaciones);
    }
}
