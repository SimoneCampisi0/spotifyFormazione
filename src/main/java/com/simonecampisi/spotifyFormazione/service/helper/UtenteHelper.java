package com.simonecampisi.spotifyFormazione.service.helper;

import com.simonecampisi.spotifyFormazione.dto.request.abstraction.AbstractUtenteRequest;
import com.simonecampisi.spotifyFormazione.model.Utente;
import com.simonecampisi.spotifyFormazione.service.helper.abstraction.IHelper;
import org.springframework.stereotype.Component;

@Component
public class UtenteHelper implements IHelper<Utente, AbstractUtenteRequest> {

    @Override
    public Utente buildEntityFromRequest(AbstractUtenteRequest request) {
        return null;
    }
}
