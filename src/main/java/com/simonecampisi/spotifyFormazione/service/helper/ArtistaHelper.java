package com.simonecampisi.spotifyFormazione.service.helper;

import com.simonecampisi.spotifyFormazione.dto.request.abstraction.AbstractRequest;
import com.simonecampisi.spotifyFormazione.dto.response.abstraction.AbstractResponse;
import com.simonecampisi.spotifyFormazione.model.Artista;
import com.simonecampisi.spotifyFormazione.service.helper.abstraction.IHelper;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Component
public class ArtistaHelper implements IHelper<Artista>{
    @Override
    public Artista buildEntityFromRequest(AbstractRequest request) {
        return null;
    }

    @Override
    public AbstractResponse buildResponse(Artista entity) {
        return null;
    }


}
