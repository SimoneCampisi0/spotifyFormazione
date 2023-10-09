package com.simonecampisi.spotifyFormazione.service;

import com.simonecampisi.spotifyFormazione.dto.request.CreateArtistaRequest;
import com.simonecampisi.spotifyFormazione.dto.request.abstraction.AbstractArtistaRequest;
import com.simonecampisi.spotifyFormazione.dto.response.ArtistaResponse;
import com.simonecampisi.spotifyFormazione.model.Artista;
import com.simonecampisi.spotifyFormazione.service.abstraction.GenericService;
import com.simonecampisi.spotifyFormazione.service.helper.ArtistaHelper;
import com.simonecampisi.spotifyFormazione.service.helper.abstraction.IHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistaService extends GenericService<Artista, Long> {

    @Autowired
    private ArtistaHelper helper;

    public ArtistaResponse createArtista(CreateArtistaRequest request) {
        Artista a = helper.buildEntityFromRequest(request);
        return helper.buildResponse(super.create(a));
    }
}
