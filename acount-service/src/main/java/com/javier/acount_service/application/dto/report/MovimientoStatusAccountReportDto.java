package com.javier.acount_service.application.dto.report;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MovimientoStatusAccountReportDto {
    public Long id;
    public LocalDateTime fecha;
    public Double saldo;
    public Double valor;
}
