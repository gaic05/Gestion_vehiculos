package com.example.tecnico.mapper;

import com.example.tecnico.dto.TecnicoRequest;
import com.example.tecnico.dto.TecnicoResponse;
import com.example.tecnico.model.Tecnico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TecnicoMapper {

    @Mapping(target = "id", ignore = true)
    Tecnico toModel(TecnicoRequest request);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "especialidad", source = "especialidad")
    @Mapping(target = "telefono", source = "telefono")
    @Mapping(target = "email", source = "email")
    TecnicoResponse toResponse(Tecnico tecnico);

    List<TecnicoResponse> toResponseList(List<Tecnico> tecnicos);
}