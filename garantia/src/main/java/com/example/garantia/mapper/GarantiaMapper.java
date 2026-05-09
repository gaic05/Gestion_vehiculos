package com.example.garantia.mapper;

import com.example.garantia.dto.GarantiaRequest;
import com.example.garantia.dto.GarantiaResponse;
import com.example.garantia.model.Garantia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface GarantiaMapper {

    @Mapping(target = "id", ignore = true)
    Garantia toEntity(GarantiaRequest request);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "fechaInicio", source = "fechaInicio")
    @Mapping(target = "fechaFin", source = "fechaFin")
    @Mapping(target = "estado", source = "estado")
    @Mapping(target = "tipoGarantia", source = "tipoGarantia")
    GarantiaResponse toResponse(Garantia garantia);

    List<GarantiaResponse> toResponseList(List<Garantia> garantias);
}
