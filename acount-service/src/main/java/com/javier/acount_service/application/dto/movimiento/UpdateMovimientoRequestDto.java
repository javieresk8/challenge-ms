package com.javier.acount_service.application.dto.movimiento;

import com.javier.acount_service.application.annotations.NonZero;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateMovimientoRequestDto {
    public LocalDateTime fecha;
    @NonZero
    public Double valor;
}
