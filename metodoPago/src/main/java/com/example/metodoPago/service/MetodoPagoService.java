package com.example.metodoPago.service;

import com.example.metodoPago.dto.MetodoPagoRequest;
import com.example.metodoPago.dto.MetodoPagoResponse;
import com.example.metodoPago.exception.MetodoPagoNotFoundException;
import com.example.metodoPago.mapper.MetodoPagoMapper;
import com.example.metodoPago.model.MetodoPago;
import com.example.metodoPago.repository.MetodoPagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MetodoPagoService {
    private final MetodoPagoRepository metodoPagoRepository;
    private final MetodoPagoMapper metodoPagoMapper;
    public List<MetodoPagoResponse> findAll() {
        return metodoPagoMapper.toResponseList(
                metodoPagoRepository.findAll()
        );
    }
    public MetodoPagoResponse findById(Long id) {
        MetodoPago metodoPago = metodoPagoRepository.findById(id)
                .orElseThrow(() -> new MetodoPagoNotFoundException(id));
        return metodoPagoMapper.toResponse(metodoPago);
    }
    public MetodoPagoResponse create(MetodoPagoRequest request) {
        MetodoPago metodoPago = metodoPagoMapper.toModel(request);
        MetodoPago guardado = metodoPagoRepository.save(metodoPago);
        return metodoPagoMapper.toResponse(guardado);
    }
    public MetodoPagoResponse update(Long id, MetodoPagoRequest request) {
        MetodoPago existente = metodoPagoRepository.findById(id)
                .orElseThrow(() -> new MetodoPagoNotFoundException(id));
        existente.setValorRepuesto(request.getValorRepuesto());
        existente.setManoObra(request.getManoObra());
        existente.setFechaEmision(request.getFechaEmision());
        existente.setModoPago(request.getModoPago());
        MetodoPago guardado = metodoPagoRepository.save(existente);
        return metodoPagoMapper.toResponse(guardado);
    }
    public void deleteById(Long id) {
        MetodoPago metodoPago = metodoPagoRepository.findById(id)
                .orElseThrow(() -> new MetodoPagoNotFoundException(id));
        metodoPagoRepository.delete(metodoPago);
    }
}
