package com.example.tecnico.service;

import com.example.tecnico.dto.TecnicoRequest;
import com.example.tecnico.dto.TecnicoResponse;
import com.example.tecnico.exception.TecnicoNotFoundException;
import com.example.tecnico.mapper.TecnicoMapper;
import com.example.tecnico.model.Tecnico;
import com.example.tecnico.repository.TecnicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TecnicoService {
    private final TecnicoRepository tecnicoRepository;
    private final TecnicoMapper tecnicoMapper;

    public List<TecnicoResponse> findAll() {
        return tecnicoMapper.toResponseList(tecnicoRepository.findAll());
    }
    public TecnicoResponse findById(Long id) {
        Tecnico tecnico = tecnicoRepository.findById(id)
                .orElseThrow(() -> new TecnicoNotFoundException(id));
        return tecnicoMapper.toResponse(tecnico);
    }
    public TecnicoResponse create(TecnicoRequest request){
        Tecnico tecnico = tecnicoMapper.toModel(request);
        Tecnico guardado = tecnicoRepository.save(tecnico);
        return tecnicoMapper.toResponse(guardado);
    }
    public TecnicoResponse update(Long id, TecnicoRequest request) {

        Tecnico existente = tecnicoRepository.findById(id)
                .orElseThrow(() -> new TecnicoNotFoundException(id));
        existente.setNombre(request.getNombre());
        existente.setEspecialidad(request.getEspecialidad());
        existente.setTelefono(request.getTelefono());
        existente.setEmail(request.getEmail());
        Tecnico guardado = tecnicoRepository.save(existente);
        return tecnicoMapper.toResponse(guardado);
    }
    public void deleteById(Long id) {
        Tecnico tecnico = tecnicoRepository.findById(id)
                .orElseThrow(() -> new TecnicoNotFoundException(id));

        tecnicoRepository.delete(tecnico);
    }
}
