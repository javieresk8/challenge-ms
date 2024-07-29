package com.javier.acount_service.application.services;

import com.javier.acount_service.application.dto.cuenta.CreateCuentaRequestDto;
import com.javier.acount_service.application.dto.cuenta.UpdateCuentaRequestDto;
import com.javier.acount_service.domain.entities.Cuenta;

import java.util.Optional;

public interface CuentaService {
    void createCuenta(CreateCuentaRequestDto cuenta);
    Cuenta getCuenta(Long id);
    Optional<Cuenta> updateCuenta(Long id, UpdateCuentaRequestDto cuenta);
    void deleteCuenta(Long id);
    void setSaldo(Long id, Double saldo);
}
