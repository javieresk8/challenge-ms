package com.javier.acount_service.api.controllers;

import com.javier.acount_service.application.dto.cuenta.CreateCuentaRequestDto;
import com.javier.acount_service.application.dto.cuenta.UpdateCuentaRequestDto;
import com.javier.acount_service.application.services.CuentaService;
import com.javier.acount_service.domain.entities.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
    private final CuentaService cuentaService;

    @Autowired
    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> getCuenta(@PathVariable Long id) {
        return ResponseEntity.ok(this.cuentaService.getCuenta(id));
    }

    @PostMapping
    public ResponseEntity<Void> createCuenta(@RequestBody CreateCuentaRequestDto cuenta) {
        this.cuentaService.createCuenta(cuenta);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable Long id) {
        this.cuentaService.deleteCuenta(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Cuenta>> updateCuenta(@PathVariable Long id, @RequestBody UpdateCuentaRequestDto cuenta) {
        return ResponseEntity.ok(this.cuentaService.updateCuenta(id, cuenta));
    }
}
