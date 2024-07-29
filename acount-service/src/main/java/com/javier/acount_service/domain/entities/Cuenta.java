package com.javier.acount_service.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.javier.acount_service.domain.enums.EstadoCuenta;
import com.javier.acount_service.domain.enums.TipoCuenta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroCuenta;
    private TipoCuenta tipoCuenta;
    private Double saldoInicial;
    private EstadoCuenta estadoCuenta;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Movimiento> movimientos;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    @JsonBackReference
    public Persona persona;

}
