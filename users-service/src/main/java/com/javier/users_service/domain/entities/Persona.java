package com.javier.users_service.domain.entities;

import com.javier.users_service.domain.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_persona", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Persona")
@Data
@NoArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nombre;
    public Gender genero;
    public Integer edad;
    public String identificacion;
    public String direccion;
    public String telefono;
}
