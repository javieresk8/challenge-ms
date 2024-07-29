package com.javier.users_service.domain.entities;

import com.javier.users_service.domain.enums.ClientStatus;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Cliente")
@Data
@NoArgsConstructor
public class Cliente extends Persona {

    @Column(name = "cliente_id", unique = true, nullable = false)
    public Long clienteId;
    public String contrasena;
    public ClientStatus estado;
}
