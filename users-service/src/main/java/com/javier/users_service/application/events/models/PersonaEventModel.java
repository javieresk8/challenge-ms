package com.javier.users_service.application.events.models;

import lombok.Data;

@Data
public class PersonaEventModel {
    public Long id;
    public String nombre;
    public String identificacion;
}
