package com.example.usuario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.example.usuario.dto.UsuarioRequest;
import com.example.usuario.dto.UsuarioResponse;
import com.example.usuario.model.Usuario;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tipoUsuario", ignore = true)
    Usuario toModel(UsuarioRequest request);

    @Mapping(target = "tipo", source = "tipoUsuario.nombre")

    UsuarioResponse toResponse(Usuario usuario);


    List<UsuarioResponse> toResponseList(List<Usuario> usuarios);
}
