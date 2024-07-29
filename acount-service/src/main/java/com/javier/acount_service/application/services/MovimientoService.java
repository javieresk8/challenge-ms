package com.javier.acount_service.application.services;

import com.javier.acount_service.application.dto.movimiento.CreateMovimientoRequestDto;
import com.javier.acount_service.application.dto.movimiento.UpdateMovimientoRequestDto;
import com.javier.acount_service.domain.entities.Movimiento;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovimientoService {
    void createMovimiento(CreateMovimientoRequestDto movimiento);
    Optional<Movimiento> getMovimiento(Long id);
    Optional<Movimiento> updateMovimiento(Long id, UpdateMovimientoRequestDto movimiento);
    void deleteMovimiento(Long id);
    List<Movimiento> getMovimientosByCuentaIdAndFechaBetween(Long cuentaId, LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
