package com.javier.acount_service.api.controllers;
import com.javier.acount_service.application.dto.movimiento.CreateMovimientoRequestDto;
import com.javier.acount_service.application.dto.movimiento.UpdateMovimientoRequestDto;
import com.javier.acount_service.application.services.MovimientoService;
import com.javier.acount_service.domain.entities.Movimiento;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    private final MovimientoService movimientoService;

    @Autowired
    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movimiento>> getMovimiento(@PathVariable Long id) {
        return ResponseEntity.ok(this.movimientoService.getMovimiento(id));
    }

    @PostMapping
    public ResponseEntity<Void> createMovimiento(@RequestBody @Valid CreateMovimientoRequestDto cuenta) {
        this.movimientoService.createMovimiento(cuenta);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimiento(@PathVariable Long id) {
        this.movimientoService.deleteMovimiento(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Movimiento>> updateMovimiento(@PathVariable Long id, @RequestBody @Valid UpdateMovimientoRequestDto movimiento) {
        return ResponseEntity.ok(this.movimientoService.updateMovimiento(id, movimiento));
    }
}
