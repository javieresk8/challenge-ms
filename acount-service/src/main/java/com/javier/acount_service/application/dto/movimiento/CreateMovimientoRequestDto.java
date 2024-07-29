package com.javier.acount_service.application.dto.movimiento;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.javier.acount_service.application.annotations.NonZero;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateMovimientoRequestDto {
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    public LocalDateTime fecha;

    @NonZero
    public Double valor;
    public Long cuentaId;
}
