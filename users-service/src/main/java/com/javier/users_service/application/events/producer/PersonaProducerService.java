package com.javier.users_service.application.events.producer;

import com.javier.users_service.application.events.models.PersonaEventModel;

public interface PersonaProducerService {
    void sendPersonaEvent(PersonaEventModel personaEventModel);
}
