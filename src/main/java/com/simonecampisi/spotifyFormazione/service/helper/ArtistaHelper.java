package com.simonecampisi.spotifyFormazione.service.helper;

import com.simonecampisi.spotifyFormazione.dto.request.CreateArtistaRequest;
import com.simonecampisi.spotifyFormazione.dto.request.abstraction.AbstractArtistaRequest;
import com.simonecampisi.spotifyFormazione.dto.request.abstraction.IRequest;
import com.simonecampisi.spotifyFormazione.dto.response.ArtistaResponse;
import com.simonecampisi.spotifyFormazione.dto.response.abstraction.AbstractResponse;
import com.simonecampisi.spotifyFormazione.model.Artista;
import com.simonecampisi.spotifyFormazione.service.helper.abstraction.IHelper;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Objects;

@Component
public class ArtistaHelper implements IHelper<Artista, AbstractArtistaRequest>{

    public byte [] base64ToImg(String base64) {
        byte [] img = null;
        try {
            img = Base64.getDecoder().decode(base64);
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return img;
    }

    @Override
    public Artista buildEntityFromRequest(AbstractArtistaRequest request) {
        Artista a = new Artista();
        a.setNome(request.getNome());
        a.setImgProfilo(base64ToImg(request.getImgProfilo())); //Builder non accetta imgProfilo
        return a;
    }

    public ArtistaResponse buildResponse(Artista entity) {
        return ArtistaResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .imgProfilo(entity.getImgProfilo())
                .build();
    }


}
