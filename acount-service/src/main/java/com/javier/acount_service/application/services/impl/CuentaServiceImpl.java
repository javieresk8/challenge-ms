package com.javier.acount_service.application.services.impl;

import com.javier.acount_service.application.dto.cuenta.CreateCuentaRequestDto;
import com.javier.acount_service.application.dto.cuenta.UpdateCuentaRequestDto;
import com.javier.acount_service.application.services.CuentaService;
import com.javier.acount_service.application.services.PersonaService;
import com.javier.acount_service.domain.entities.Cuenta;
import com.javier.acount_service.domain.entities.Persona;
import com.javier.acount_service.infrastructure.repository.CuentaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CuentaServiceImpl implements CuentaService {
    private final CuentaRepository cuentaRepository;
    private final PersonaService personaService;
    public CuentaServiceImpl(CuentaRepository cuentaRepository, PersonaService personaService) {
        this.cuentaRepository = cuentaRepository;
        this.personaService = personaService;
    }

    @Override
    public void createCuenta(CreateCuentaRequestDto cuenta) {
        Persona persona = personaService.getPersona(cuenta.getPersonaId())
                .orElseThrow(() -> new RuntimeException("Persona with id " + cuenta.getPersonaId() + " does not exist"));

        Cuenta cuentaEntity = Cuenta.builder()
                .numeroCuenta(cuenta.getNumeroCuenta())
                .estadoCuenta(cuenta.getEstadoCuenta())
                .tipoCuenta(cuenta.getTipoCuenta())
                .saldoInicial(cuenta.getSaldoInicial())
                .persona(persona)
                .build();

        cuentaRepository.save(cuentaEntity);

    }

    @Override
    public Cuenta getCuenta(Long id) {
        return cuentaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta with id " + id + " does not exist"));

    }

    @Override
    public Optional<Cuenta> updateCuenta(Long id, UpdateCuentaRequestDto cuenta) {

        Cuenta cuentaEntity = this.getCuenta(id);

        return cuentaRepository.findById(id)
                .map(cuentaToUpdate -> {
                    if (cuenta.getNumeroCuenta() != null) {
                        cuentaToUpdate.setNumeroCuenta(cuenta.getNumeroCuenta());
                    }
                    if (cuenta.getEstadoCuenta() != null) {
                        cuentaToUpdate.setEstadoCuenta(cuenta.getEstadoCuenta());
                    }
                    if (cuenta.getTipoCuenta() != null) {
                        cuentaToUpdate.setTipoCuenta(cuenta.getTipoCuenta());
                    }
                    if (cuenta.getSaldoInicial() != null) {
                        cuentaToUpdate.setSaldoInicial(cuenta.getSaldoInicial());
                    }
                    return cuentaRepository.save(cuentaToUpdate);
                });
    }

    @Override
    public void deleteCuenta(Long id) {
        cuentaRepository.deleteById(id);
    }

    @Override
    public void setSaldo(Long id, Double saldo) {
        cuentaRepository.findById(id)
                .map(cuenta -> {
                    cuenta.setSaldoInicial(saldo);
                    return cuentaRepository.save(cuenta);
                });
    }
}
