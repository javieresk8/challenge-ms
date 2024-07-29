package com.javier.users_service.application.dto.requests;

import com.javier.users_service.domain.enums.ClientStatus;
import com.javier.users_service.domain.enums.Gender;
import lombok.Data;

@Data
public class UpdateClienteRequestDto {
    public Long id;
    public String nombre;
    public Gender genero;
    public Integer edad;
    public String identificacion;
    public String direccion;
    public String telefono;
    public Long clienteId;
    public String contrasena;
    public ClientStatus estado;
}
