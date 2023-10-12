package com.simonecampisi.spotifyFormazione.service.helper;

import com.simonecampisi.spotifyFormazione.dto.request.artista.ModificaArtistaRequest;
import com.simonecampisi.spotifyFormazione.dto.request.abstraction.AbstractArtistaRequest;
import com.simonecampisi.spotifyFormazione.dto.response.artista.ArtistaResponse;
import com.simonecampisi.spotifyFormazione.model.Artista;
import com.simonecampisi.spotifyFormazione.service.helper.abstraction.IHelper;
import com.simonecampisi.spotifyFormazione.utils.ImageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArtistaHelper implements IHelper<Artista, AbstractArtistaRequest>{

    @Autowired
    private ImageManager imageManager;

    @Override
    public Artista buildEntityFromRequest(AbstractArtistaRequest request) {
        return Artista.builder()
                .nome(request.getNome())
                .imgProfilo(request.getImgProfilo().isEmpty() ? null : imageManager.base64ToImg(request.getImgProfilo()))
                .build();
    }

    public ArtistaResponse buildResponse(Artista entity) {
        return ArtistaResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .imgProfilo(entity.getImgProfilo())
                .build();
    }

    public Artista updateArtistaFromRequest(Artista artista, ModificaArtistaRequest request) {
        artista.setNome(request.getNome());
        if(request.getNome().isEmpty()) {
            artista.setImgProfilo(null);
        } else {
            artista.setImgProfilo(imageManager.base64ToImg(request.getImgProfilo()));
        }

        return artista;
    }

}
