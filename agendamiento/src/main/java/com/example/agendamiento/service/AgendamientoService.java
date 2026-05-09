package com.example.agendamiento.service;

import com.example.agendamiento.dto.AgendamientoRequest;
import com.example.agendamiento.dto.AgendamientoResponse;
import com.example.agendamiento.exception.AgendamientoNotFoundException;
import com.example.agendamiento.mapper.AgendamientoMapper;
import com.example.agendamiento.model.Agendamiento;
import com.example.agendamiento.repository.AgendamientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendamientoService {
    private final AgendamientoRepository agendamientoRepository;
    private final AgendamientoMapper agendamientoMapper;
    public List<AgendamientoResponse> findAll() {
        return agendamientoMapper.toResponseList(agendamientoRepository.findAll());
    }
    public AgendamientoResponse findById(Long id) {
        Agendamiento agendamiento = agendamientoRepository.findById(id)
                .orElseThrow(() -> new AgendamientoNotFoundException(id));
        return agendamientoMapper.toResponse(agendamiento);
    }
    public AgendamientoResponse create(AgendamientoRequest request) {
        Agendamiento agendamiento = agendamientoMapper.toModel(request);
        Agendamiento guardado = agendamientoRepository.save(agendamiento);
        return agendamientoMapper.toResponse(guardado);
    }
    public AgendamientoResponse update(Long id, AgendamientoRequest request) {
        Agendamiento existente = agendamientoRepository.findById(id)
                .orElseThrow(() -> new AgendamientoNotFoundException(id));
        existente.setId(request.getId());
        existente.setVehiculoId(request.getVehiculoId());
        existente.setUsuarioId(request.getUsuarioId());
        existente.setFechaHora(request.getFechaHora());
        existente.setDescripcion(request.getDescripcion());

        Agendamiento guardado = agendamientoRepository.save(existente);
        return agendamientoMapper.toResponse(guardado);
    }
    public void deleteById(Long id) {
        Agendamiento agendamiento= agendamientoRepository.findById(id)
                .orElseThrow(() -> new AgendamientoNotFoundException(id));
        agendamientoRepository.delete(agendamiento);
    }
}
