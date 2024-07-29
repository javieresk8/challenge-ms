package com.javier.users_service.application.services;

import com.javier.users_service.application.dto.requests.CreateClienteRequestDto;
import com.javier.users_service.application.dto.requests.UpdateClienteRequestDto;
import com.javier.users_service.domain.entities.Cliente;

import java.util.Optional;

public interface ClienteService {
    void createCliente(CreateClienteRequestDto cliente);
    Optional<Cliente> getCliente(Long id);
    Cliente updateCliente(Long id, UpdateClienteRequestDto cliente);
    void deleteCliente(Long id);
}
