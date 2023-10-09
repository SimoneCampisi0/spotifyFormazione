package com.simonecampisi.spotifyFormazione.service.helper;

import com.simonecampisi.spotifyFormazione.dto.request.CreateArtistaRequest;
import com.simonecampisi.spotifyFormazione.dto.request.abstraction.AbstractArtistaRequest;
import com.simonecampisi.spotifyFormazione.dto.request.abstraction.IRequest;
import com.simonecampisi.spotifyFormazione.dto.response.ArtistaResponse;
import com.simonecampisi.spotifyFormazione.dto.response.abstraction.AbstractResponse;
import com.simonecampisi.spotifyFormazione.model.Artista;
import com.simonecampisi.spotifyFormazione.service.helper.abstraction.IHelper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ArtistaHelper implements IHelper<Artista, AbstractArtistaRequest>{

    @Override
    public Artista buildEntityFromRequest(AbstractArtistaRequest request) {
        Artista a = new Artista();

        a.setNome(request.getNome());
        a.setImgProfilo(request.getImgProfilo()); //Builder non accetta imgProfilo

        return a;
    }

    public ArtistaResponse buildResponse(Artista entity) {
        ArtistaResponse response = new ArtistaResponse();
        response.setId(entity.getId());
        response.setNome(entity.getNome());
        response.setImgProfilo(entity.getImgProfilo());

        return response;
    }


}
