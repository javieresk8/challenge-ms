package com.javier.acount_service.application.services.impl;

import com.javier.acount_service.application.services.PersonaService;
import com.javier.acount_service.domain.entities.Persona;
import com.javier.acount_service.infrastructure.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public void createPersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public Optional<Persona> getPersona(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public Optional<Persona> updatePersona(Long id, Persona persona) {
        return personaRepository.findById(id)
                .map(personaEntity -> {
                    if (persona.getIdentificacion() != null) {
                        personaEntity.setIdentificacion(persona.getIdentificacion());
                    }
                    if (persona.getNombre() != null) {
                        personaEntity.setNombre(persona.getNombre());
                    }

                    return personaRepository.save(personaEntity);
                });
    }

    @Override
    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }
}
