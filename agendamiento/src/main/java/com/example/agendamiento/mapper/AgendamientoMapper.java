package com.example.agendamiento.mapper;
import com.example.agendamiento.dto.AgendamientoRequest;
import com.example.agendamiento.dto.AgendamientoResponse;
import com.example.agendamiento.model.Agendamiento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgendamientoMapper {
    @Mapping(target = "id", ignore = true)
    Agendamiento toModel(AgendamientoRequest request);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "vehiculoId", source = "vehiculoId")
    @Mapping(target = "usuarioId", source = "usuarioId")
    @Mapping(target = "fechaHora", source = "fechaHora")
    @Mapping(target = "descripcion", source = "descripcion")
    AgendamientoResponse toResponse(Agendamiento agendamiento);

    List<AgendamientoResponse> toResponseList(List<Agendamiento> agendamientos);
}
