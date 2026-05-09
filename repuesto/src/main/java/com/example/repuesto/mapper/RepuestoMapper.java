package com.example.repuesto.mapper;

import com.example.repuesto.dto.RepuestoRequest;
import com.example.repuesto.dto.RepuestoResponse;
import com.example.repuesto.model.Repuesto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RepuestoMapper {

    Repuesto toEntity(RepuestoRequest request);
    RepuestoResponse toResponse(Repuesto repuesto);
    List<RepuestoResponse> toResponseList(List<Repuesto> repuestos);
}
