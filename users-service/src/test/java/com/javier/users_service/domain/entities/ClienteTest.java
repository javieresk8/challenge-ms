package com.javier.users_service.domain.entities;

import com.javier.users_service.domain.enums.ClientStatus;
import com.javier.users_service.domain.enums.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {
    private Cliente cliente;
    private String password;
    @BeforeEach
    public void setUp() {
        password = "123456";
        cliente = new Cliente();
        cliente.setNombre("Javier Erazo");
        cliente.setDireccion("Calle 123");
        cliente.setClienteId(1000L);
        cliente.setContrasena(password);
        cliente.setEstado(ClientStatus.ACTIVE);
        cliente.setEdad(25);
        cliente.setGenero(Gender.M);
        cliente.setIdentificacion("123456789");
        cliente.setTelefono("0998566982");
    }

    @Test
    public void testGetContrasena() {
        assertEquals(password, cliente.getContrasena());
    }

}
