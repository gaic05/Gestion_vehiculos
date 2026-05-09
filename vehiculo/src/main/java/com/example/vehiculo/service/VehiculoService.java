package com.example.vehiculo.service;

import com.example.vehiculo.dto.VehiculoRequest;
import com.example.vehiculo.dto.VehiculoResponse;
import com.example.vehiculo.exception.PatenteDuplicadoException;
import com.example.vehiculo.exception.VehiculoNotFoundException;
import com.example.vehiculo.mapper.VehiculoMapper;
import com.example.vehiculo.model.Vehiculo;
import com.example.vehiculo.repository.MarcaVehiculoRepository;
import com.example.vehiculo.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;
    private final MarcaVehiculoRepository marcaVehiculoRepository;
    private final VehiculoMapper vehiculoMapper;

    public List<VehiculoResponse> findAll() {
        return vehiculoMapper.toResponseList(vehiculoRepository.findAll());
    }
    public VehiculoResponse findByPatente(String patente) {
        Vehiculo vehiculo = vehiculoRepository.findByPatente(patente)
                .orElseThrow(() -> new VehiculoNotFoundException(patente));
        return vehiculoMapper.toResponse(vehiculo);
    }
    public VehiculoResponse create(VehiculoRequest request) {
        if (vehiculoRepository.existsByPatente(request.getPatente())) {
            String vehiculoExistente = vehiculoRepository
                    .findByPatente(request.getPatente())
                    .map(Vehiculo::getPatente)
                    .orElse("Desconocido");
            throw new PatenteDuplicadoException(request.getPatente(), vehiculoExistente);
        }
        Vehiculo vehiculo = vehiculoMapper.toModel(request);
        if (vehiculo == null) {
            throw new IllegalArgumentException(
                    "La solicitud de vehiculo no pudo ser procesada"
            );
        }
        Vehiculo guardado = vehiculoRepository.save(vehiculo);
        return vehiculoMapper.toResponse(guardado);
    }
    public VehiculoResponse update(String patente, VehiculoRequest request) {
        Vehiculo existente = vehiculoRepository.findByPatente(patente)
                .orElseThrow(() -> new VehiculoNotFoundException(patente));

        if (!existente.getPatente().equals(request.getPatente())) {
            if (vehiculoRepository.existsByPatente(request.getPatente())) {
                vehiculoRepository.findByPatente(request.getPatente())
                        .ifPresent(vehiculo -> {
                            throw new PatenteDuplicadoException(request.getPatente(), vehiculo.getPatente());
                        });
            }
        }
        existente.setPatente(request.getPatente());
        existente.setModelo(request.getModelo());
        existente.setColor(request.getColor());
        existente.setVin(request.getVin());
        existente.setAnnio(request.getAnnio());
        existente.setMarcaVehiculo(request.getMarcaVehiculo());
        Vehiculo guardado = vehiculoRepository.save(existente);
        return vehiculoMapper.toResponse(guardado);
    }
    public void deleteByPatente(String patente) {
        vehiculoRepository.findByPatente(patente)
                .orElseThrow(() -> new VehiculoNotFoundException(patente));
        vehiculoRepository.deleteByPatente(patente);
    }
}