package com.javier.users_service.application.services.impl;

import com.javier.users_service.application.dto.requests.CreateClienteRequestDto;
import com.javier.users_service.application.dto.requests.UpdateClienteRequestDto;
import com.javier.users_service.application.events.producer.PersonaProducerService;
import com.javier.users_service.application.mappers.ClienteMapper;
import com.javier.users_service.domain.entities.Cliente;
import com.javier.users_service.application.services.ClienteService;
import com.javier.users_service.infrastructure.repository.ClienteRepository;
import com.javier.users_service.infrastructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{
    private final PersonaRepository personaRepository;
    private final ClienteRepository clienteRepository;
    private final PersonaProducerService personaProducerService;

    @Autowired
    public ClienteServiceImpl(PersonaRepository personaRepository, ClienteRepository clienteRepository,
                              PersonaProducerService personaProducerService) {
        this.personaRepository = personaRepository;
        this.clienteRepository = clienteRepository;
        this.personaProducerService = personaProducerService;
    }

    public void createCliente(CreateClienteRequestDto cliente) {
        if(clienteRepository.findByClienteId(cliente.getClienteId()).isPresent()){
            throw new RuntimeException("Cliente with id " + cliente.getClienteId() + " already exists");
        }

        Cliente clienteEntity = ClienteMapper.mapToCliente(cliente);

        this.personaRepository.save(clienteEntity);

        personaProducerService.sendPersonaEvent(ClienteMapper.mapToClienteEventModel(clienteEntity));
    }

    public Optional<Cliente> getCliente(Long id) {
        return this.personaRepository.findById(id)
                .filter(persona -> persona instanceof Cliente)
                .map(persona -> (Cliente) persona);

    }

    public Cliente updateCliente(Long id, UpdateClienteRequestDto clienteDto) {

        return (Cliente) personaRepository.findById(id)
                .filter(persona -> persona instanceof Cliente)
                .map(existingCliente -> {
                    if (clienteDto.getClienteId() != null) {
                        if (clienteRepository.findByClienteId(clienteDto.getClienteId()).isPresent()){
                            throw new RuntimeException("Cliente with id " + clienteDto.getClienteId() + " already exists");
                        }
                        ((Cliente)existingCliente).setClienteId(clienteDto.getClienteId());
                    }
                    if (clienteDto.getContrasena() != null) {
                        ((Cliente)existingCliente).setContrasena(clienteDto.getContrasena());
                    }
                    if (clienteDto.getEstado() != null) {
                        ((Cliente)existingCliente).setEstado(clienteDto.getEstado());
                    }
                    if (clienteDto.getDireccion() != null) {
                        existingCliente.setDireccion(clienteDto.getDireccion());
                    }
                    if (clienteDto.getEdad() != null) {
                        existingCliente.setEdad(clienteDto.getEdad());
                    }
                    if (clienteDto.getGenero() != null) {
                        existingCliente.setGenero(clienteDto.getGenero());
                    }
                    if (clienteDto.getIdentificacion() != null) {
                        existingCliente.setIdentificacion(clienteDto.getIdentificacion());
                    }
                    if (clienteDto.getNombre() != null) {
                        existingCliente.setNombre(clienteDto.getNombre());
                    }
                    if (clienteDto.getTelefono() != null) {
                        existingCliente.setTelefono(clienteDto.getTelefono());
                    }
                    return personaRepository.save(existingCliente);
                })
                .orElseThrow(() -> new RuntimeException("Cliente not found with id " + id));
    }

    public void deleteCliente(Long id) {
        this.personaRepository.deleteById(id);
    }
}
