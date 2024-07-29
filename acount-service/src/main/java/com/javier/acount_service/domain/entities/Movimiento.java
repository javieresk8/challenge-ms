package com.javier.acount_service.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movimiento {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    public Long id;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    public LocalDateTime fecha;
    public Double valor;
    public Double saldo;

    @ManyToOne
    @JoinColumn(name = "cuenta_id", nullable = false)
    @JsonBackReference
    public Cuenta cuenta;

    public void setValor(Double valor) {
        if (valor == 0) {
            throw new IllegalArgumentException("El valor no puede ser negativo");
        }
        this.valor = valor;
    }


}
