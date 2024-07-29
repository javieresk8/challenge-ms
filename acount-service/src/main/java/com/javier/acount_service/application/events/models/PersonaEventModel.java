package com.javier.acount_service.application.events.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonaEventModel implements Serializable {
    public Long id;
    public String nombre;
    public String identificacion;
}
