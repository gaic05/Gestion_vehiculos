package com.example.reparaciones.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.example.reparaciones.dto.ReparacionesRequest;
import com.example.reparaciones.dto.ReparacionesResponse;
import com.example.reparaciones.model.Reparaciones;

import java.util.List;

@Mapper
public interface ReparacionesMapper {
    @Mapping(target = "id", ignore = true)
    Reparaciones toModel(ReparacionesRequest request);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "tecnicoId", source = "tecnicoId")
    @Mapping(target = "solicitudId", source = "solicitudId")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "costo", source = "costo")
    ReparacionesResponse toResponse(Reparaciones reparaciones);

    List<ReparacionesResponse> toResponseList(List<Reparaciones> Reparaciones);
}
