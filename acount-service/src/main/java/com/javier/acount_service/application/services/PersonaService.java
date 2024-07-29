package com.javier.acount_service.application.services;


import com.javier.acount_service.domain.entities.Persona;

import java.util.Optional;

public interface PersonaService {
    void createPersona(Persona persona);
    Optional<Persona> getPersona(Long id);
    Optional<Persona> updatePersona(Long id, Persona persona);
    void deletePersona(Long id);
}
