package com.javier.acount_service.application.dto.report;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatusAccountReportResponseDto {
    public String identification;
    public String name;
    public String numeroCuenta;
    public Double saldo;
    public List<MovimientoStatusAccountReportDto> movimientos;
}
