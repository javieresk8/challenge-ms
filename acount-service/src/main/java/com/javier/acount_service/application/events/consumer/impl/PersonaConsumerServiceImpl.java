package com.javier.acount_service.application.events.consumer.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javier.acount_service.application.events.models.PersonaEventModel;
import com.javier.acount_service.domain.entities.Persona;
import com.javier.acount_service.infrastructure.repository.PersonaRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PersonaConsumerServiceImpl {
    private final PersonaRepository personaRepository;

    public PersonaConsumerServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @KafkaListener(topics = "persona-created", groupId = "account-service-group")
    public void consume(String personaEventModel) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            PersonaEventModel personaEvent = objectMapper.readValue(personaEventModel, PersonaEventModel.class);

            Persona persona = Persona.builder()
                .id(personaEvent.getId())
                .nombre(personaEvent.getNombre())
                .identificacion(personaEvent.getIdentificacion())
                .build();
        personaRepository.save(persona);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
