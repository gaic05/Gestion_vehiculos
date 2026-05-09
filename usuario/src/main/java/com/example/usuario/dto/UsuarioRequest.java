package com.example.usuario.dto;

import com.example.usuario.model.TipoUsuario;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {

    @NotBlank(message = "Introducir una contraseña")
    private String contrasenia;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido paterno es obligatorio")
    private String apPaterno;

    @NotBlank(message = "El apellido materno es obligatorio")
    private String apMaterno;

    @NotNull(message = "Debe ingresar un rut")
    @Range(min = 1000000, max = 35000000)
    private Long rut;

    @NotBlank(message = "Debe ingresar el digito verificador 0-9, k")
    @Pattern(regexp = "^[0-9kK]{1}$")
    private String dv;

    @NotBlank(message = "Debe ingresar un numero telefonico")
    @Pattern(regexp = "^\\+[0-9]{9,12}$", message = "El teléfono debe ser formato valido +56912345678")
    private String telefono;

    @Email
    private String email;

    @NotNull(message = "Debe ingresar el tipo de usuario")
    private TipoUsuario tipoUsuario;
}
