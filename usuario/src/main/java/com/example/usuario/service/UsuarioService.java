package com.example.usuario.service;

import com.example.usuario.dto.UsuarioRequest;
import com.example.usuario.dto.UsuarioResponse;
import com.example.usuario.exception.RutDuplicadoException;
import com.example.usuario.exception.UsuarioNotFoundException;
import com.example.usuario.mapper.UsuarioMapper;
import com.example.usuario.model.Usuario;
import com.example.usuario.repository.TipoUsuarioRepository;
import com.example.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final TipoUsuarioRepository tipoUsuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public List<UsuarioResponse> findAll() {
        return usuarioMapper.toResponseList(usuarioRepository.findAll());
    }

    public UsuarioResponse findByRut(Long rut) {
        Usuario usuario = usuarioRepository.findByRut(rut)
                .orElseThrow(() -> new UsuarioNotFoundException(rut));
        return usuarioMapper.toResponse(usuario);
    }

    public UsuarioResponse create(UsuarioRequest request) {
        if (usuarioRepository.existsByRut(request.getRut())) {
            String usuarioExistente = usuarioRepository.findByRut(request.getRut())
                    .map(Usuario::getNombre)
                    .orElse("Desconocido");
            throw new RutDuplicadoException(request.getRut(), usuarioExistente);
        }
        Usuario usuario = usuarioMapper.toModel(request);
        if (usuario == null) {
            throw new IllegalArgumentException("La solicitud de usuario no pudo ser procesada.");
        }
        Usuario guardado = usuarioRepository.save(usuario);
        return usuarioMapper.toResponse(guardado);
    }

    public UsuarioResponse update(Long rut, UsuarioRequest request) {

        Usuario existente = usuarioRepository.findByRut(rut)
                .orElseThrow(() -> new UsuarioNotFoundException(rut));

        if (!existente.getRut().equals(request.getRut())) {
            if (usuarioRepository.existsByRut(request.getRut())) {
                usuarioRepository.findByRut(request.getRut()).ifPresent(usuario -> {
                    throw new RutDuplicadoException(request.getRut(), usuario.getNombre());
                });
            }
        }
        existente.setContrasenia(request.getContrasenia());
        existente.setNombre(request.getNombre());
        existente.setApPaterno(request.getApPaterno());
        existente.setApMaterno(request.getApMaterno());
        existente.setRut(request.getRut());
        existente.setDv(request.getDv());
        existente.setTelefono(request.getTelefono());
        existente.setEmail(request.getEmail());
        existente.setTipoUsuario(request.getTipoUsuario());

        Usuario guardado = usuarioRepository.save(existente);
        return usuarioMapper.toResponse(guardado);
    }

    public void deleteByRut(Long rut) {

        usuarioRepository.findByRut(rut).orElseThrow(() -> new UsuarioNotFoundException(rut));

        usuarioRepository.deleteByRut(rut);
    }
}
