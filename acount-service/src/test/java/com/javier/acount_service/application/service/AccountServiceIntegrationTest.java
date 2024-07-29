package com.javier.acount_service.application.service;

import com.javier.acount_service.application.dto.movimiento.CreateMovimientoRequestDto;
import com.javier.acount_service.application.services.MovimientoService;
import com.javier.acount_service.config.TestContainersConfig;
import com.javier.acount_service.domain.entities.Cuenta;
import com.javier.acount_service.domain.entities.Movimiento;
import com.javier.acount_service.domain.entities.Persona;
import com.javier.acount_service.infrastructure.repository.CuentaRepository;
import com.javier.acount_service.infrastructure.repository.MovimientoRepository;
import com.javier.acount_service.infrastructure.repository.PersonaRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(initializers = TestContainersConfig.class)
@Transactional
public class AccountServiceIntegrationTest {
    @Autowired
    private MovimientoService movimientoService;

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    private CreateMovimientoRequestDto movimiento;
    private Cuenta cuenta;
    private Persona persona;
    private Long cuentaId = 1L;
    private Long personaId = 1L;
    private Double valorMovimiento = 100.0;
    @BeforeEach
    public void setUp() {
        movimientoRepository.deleteAll();
        cuentaRepository.deleteAll();
        personaRepository.deleteAll();

        persona = Persona.builder()
                .id(personaId)
                .nombre("Javier")
                .identificacion("123")
                .build();

        cuenta = Cuenta.builder()
                .id(cuentaId)
                .numeroCuenta("123")
                .saldoInicial(0.0)
                .build();

        personaRepository.save(persona);
        cuenta.setPersona(persona);
        cuentaRepository.save(cuenta);

        movimiento = new CreateMovimientoRequestDto();
        movimiento.setCuentaId(1L);
        movimiento.setFecha(LocalDateTime.now());
        movimiento.setValor(valorMovimiento);
    }

    @Test
    public void createMovimiento() {
        movimientoService.createMovimiento(movimiento);
        Movimiento movimientoCreated = movimientoRepository.findAll().get(0);
        Double valor = movimientoCreated.getValor();
        assertEquals(valorMovimiento, valor);

    }
}
