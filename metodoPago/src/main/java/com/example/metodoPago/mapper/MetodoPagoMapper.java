package com.example.metodoPago.mapper;

import com.example.metodoPago.dto.MetodoPagoRequest;
import com.example.metodoPago.dto.MetodoPagoResponse;
import com.example.metodoPago.model.MetodoPago;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MetodoPagoMapper {
    MetodoPago toModel(MetodoPagoRequest request);
    MetodoPagoResponse toResponse(MetodoPago metodoPago);
    List<MetodoPagoResponse> toResponseList(List<MetodoPago> metodoPagos);
}
