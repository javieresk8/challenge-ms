package com.javier.acount_service.application.dto.cuenta;

import com.javier.acount_service.domain.enums.EstadoCuenta;
import com.javier.acount_service.domain.enums.TipoCuenta;
import lombok.Data;

@Data
public class CreateCuentaRequestDto {
    private String numeroCuenta;
    private TipoCuenta tipoCuenta;
    private Double saldoInicial;
    private EstadoCuenta estadoCuenta;
    private Long personaId;

}
