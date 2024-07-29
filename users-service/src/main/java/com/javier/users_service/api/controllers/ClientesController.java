package com.javier.users_service.api.controllers;

import com.javier.users_service.application.dto.requests.CreateClienteRequestDto;
import com.javier.users_service.application.dto.requests.UpdateClienteRequestDto;
import com.javier.users_service.domain.entities.Cliente;
import com.javier.users_service.application.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    private final ClienteService clienteService;

    @Autowired
    public ClientesController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{id}")

    public ResponseEntity<Optional<Cliente>> getPersona(@PathVariable Long id) {
        return ResponseEntity.ok(this.clienteService.getCliente(id));
    }

    @PostMapping
    public ResponseEntity<Void> createCliente(@RequestBody CreateClienteRequestDto cliente) {
        this.clienteService.createCliente(cliente);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        this.clienteService.deleteCliente(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody UpdateClienteRequestDto cliente) {
        return ResponseEntity.ok(this.clienteService.updateCliente(id, cliente));
    }

}
