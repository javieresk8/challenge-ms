package com.javier.users_service.application.mappers;

import com.javier.users_service.application.dto.requests.CreateClienteRequestDto;
import com.javier.users_service.application.events.models.PersonaEventModel;
import com.javier.users_service.domain.entities.Cliente;

public class ClienteMapper {
    public static Cliente mapToCliente(CreateClienteRequestDto cliente) {
        Cliente clienteEntity = new Cliente();
        clienteEntity.setNombre(cliente.getNombre());
        clienteEntity.setGenero(cliente.getGenero());
        clienteEntity.setEdad(cliente.getEdad());
        clienteEntity.setIdentificacion(cliente.getIdentificacion());
        clienteEntity.setDireccion(cliente.getDireccion());
        clienteEntity.setTelefono(cliente.getTelefono());
        clienteEntity.setClienteId(cliente.getClienteId());
        clienteEntity.setContrasena(cliente.getContrasena());
        clienteEntity.setEstado(cliente.getEstado());
        return clienteEntity;
    }

    public static PersonaEventModel mapToClienteEventModel(Cliente clienteEntity) {
        PersonaEventModel personaEventModel = new PersonaEventModel();
        personaEventModel.id = clienteEntity.getId();
        personaEventModel.nombre = clienteEntity.getNombre();
        personaEventModel.identificacion = clienteEntity.getIdentificacion();
        return personaEventModel;
    }
}
