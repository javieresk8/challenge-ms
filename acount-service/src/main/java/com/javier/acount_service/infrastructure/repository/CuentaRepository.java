package com.javier.acount_service.infrastructure.repository;

import com.javier.acount_service.domain.entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    
}
