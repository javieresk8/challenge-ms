package com.javier.acount_service.application.services.impl;

import com.javier.acount_service.application.dto.report.MovimientoStatusAccountReportDto;
import com.javier.acount_service.application.dto.report.StatusAccountReportRequestDto;
import com.javier.acount_service.application.dto.report.StatusAccountReportResponseDto;
import com.javier.acount_service.application.services.CuentaService;
import com.javier.acount_service.application.services.MovimientoService;
import com.javier.acount_service.application.services.ReporteService;
import com.javier.acount_service.domain.entities.Cuenta;
import com.javier.acount_service.domain.entities.Movimiento;
import com.javier.acount_service.domain.entities.Persona;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReporteServiceImpl implements ReporteService {
    private final MovimientoService movimientoService;

    public ReporteServiceImpl(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    public StatusAccountReportResponseDto getAccountStatusReport(StatusAccountReportRequestDto requestDto, LocalDate from, LocalDate to) {

        List<Movimiento> movimientosList = movimientoService.getMovimientosByCuentaIdAndFechaBetween(
                requestDto.getAccountId(), LocalDateTime.parse(from.atStartOfDay().toString()), LocalDateTime.parse(to.atStartOfDay().toString()));

        Cuenta account = movimientosList.get(0).getCuenta();
        Persona persona = account.getPersona();

        List<MovimientoStatusAccountReportDto> movimientos = movimientosList.stream()
                .map(movimiento -> MovimientoStatusAccountReportDto.builder()
                        .fecha(movimiento.getFecha())
                        .id(movimiento.getId())
                        .valor(movimiento.getValor())
                        .saldo(movimiento.getSaldo())
                        .build())
                .collect(Collectors.toList());

        return StatusAccountReportResponseDto.builder()
                .identification(persona.getIdentificacion())
                .name(persona.getNombre())
                .numeroCuenta(account.getNumeroCuenta())
                .saldo(account.getSaldoInicial())
                .movimientos(movimientos)
                .build();

    }
}
