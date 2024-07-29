package com.javier.users_service.application.events.producer.impl;

import com.javier.users_service.application.events.models.PersonaEventModel;
import com.javier.users_service.application.events.producer.PersonaProducerService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PersonaProducerServiceImpl implements PersonaProducerService {
    private final KafkaTemplate<String, PersonaEventModel> kafkaTemplate;

    public PersonaProducerServiceImpl(KafkaTemplate<String, PersonaEventModel> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPersonaEvent(PersonaEventModel personaEventModel) {
        kafkaTemplate.send("persona-created", personaEventModel);
    }
}
