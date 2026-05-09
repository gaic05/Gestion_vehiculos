package com.example.vehiculo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.example.vehiculo.dto.VehiculoRequest;
import com.example.vehiculo.dto.VehiculoResponse;
import com.example.vehiculo.model.Vehiculo;

import java.util.List;
@Mapper(componentModel = "spring")
public interface VehiculoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "marcaVehiculo", ignore = true)
    Vehiculo toModel(VehiculoRequest request);

    @Mapping(target = "marcaVehiculo", source = "marcaVehiculo.id")
    VehiculoResponse toResponse(Vehiculo vehiculo);

    List<VehiculoResponse> toResponseList(List<Vehiculo> vehiculos);
}
