package com.javier.acount_service.application.services.impl;

import com.javier.acount_service.application.dto.movimiento.CreateMovimientoRequestDto;
import com.javier.acount_service.application.dto.movimiento.UpdateMovimientoRequestDto;
import com.javier.acount_service.application.services.CuentaService;
import com.javier.acount_service.application.services.MovimientoService;
import com.javier.acount_service.domain.entities.Movimiento;
import com.javier.acount_service.domain.exceptions.NotEnoughSaldoException;
import com.javier.acount_service.infrastructure.repository.MovimientoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MovimientoServiceImpl implements MovimientoService {
    private final MovimientoRepository movimientoRepository;
    private final CuentaService cuentaService;

    public MovimientoServiceImpl(MovimientoRepository movimientoRepository, CuentaService cuentaService) {
        this.movimientoRepository = movimientoRepository;
        this.cuentaService = cuentaService;
    }

    @Transactional
    @Override
    public void createMovimiento(CreateMovimientoRequestDto movimiento) {
        log.info("Creating movimiento: {}", movimiento);

        var cuenta = cuentaService.getCuenta(movimiento.cuentaId);

        boolean hasEnoughSaldo = cuenta.getSaldoInicial() + movimiento.valor >= 0;
        if (!hasEnoughSaldo) {
            log.error("Not enough saldo in cuenta: {}", cuenta.getNumeroCuenta());
            throw new NotEnoughSaldoException("Not enough saldo");
        }
        Double newSaldo = cuenta.getSaldoInicial() + movimiento.valor;

        log.info("Updating saldo for cuenta: {}", cuenta.getNumeroCuenta());
        cuentaService.setSaldo(movimiento.cuentaId, newSaldo);

        Movimiento movimientoEntity = Movimiento.builder()
                .fecha(movimiento.fecha)
                .valor(movimiento.valor)
                .saldo(newSaldo)
                .cuenta(cuenta)
                .build();

        movimientoRepository.save(movimientoEntity);
        log.info("Movimiento created");
    }

    @Override
    public Optional<Movimiento> getMovimiento(Long id) {
        return movimientoRepository.findById(id);
    }

    @Transactional
    @Override
    public Optional<Movimiento> updateMovimiento(Long id, UpdateMovimientoRequestDto cuenta) {
        return movimientoRepository.findById(id)
                .map(movimiento -> {
                    if (cuenta.fecha != null) {
                        movimiento.setFecha(cuenta.fecha);
                    }
                    if (cuenta.valor != null) {
                        movimiento.setValor(cuenta.valor);
                    }

                    return movimientoRepository.save(movimiento);
                });
    }

    @Override
    public void deleteMovimiento(Long id) {
        movimientoRepository.deleteById(id);
    }

    @Override
    public List<Movimiento> getMovimientosByCuentaIdAndFechaBetween(Long cuentaId, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return movimientoRepository.findByCuentaIdAndFechaBetween(cuentaId, fechaInicio, fechaFin);
    }
}
