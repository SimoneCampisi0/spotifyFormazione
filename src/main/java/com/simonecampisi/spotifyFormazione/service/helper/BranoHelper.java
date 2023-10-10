package com.simonecampisi.spotifyFormazione.service.helper;


import com.simonecampisi.spotifyFormazione.dto.request.abstraction.AbstractBranoRequest;
import com.simonecampisi.spotifyFormazione.dto.response.brano.BranoResponse;
import com.simonecampisi.spotifyFormazione.model.Brano;
import com.simonecampisi.spotifyFormazione.service.helper.abstraction.IHelper;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class BranoHelper implements IHelper<Brano, AbstractBranoRequest> {

    @Override
    public Brano buildEntityFromRequest(AbstractBranoRequest request) {
        Duration duration = Duration.ofMinutes(request.getMinuti()).plusSeconds(request.getSecondi());
        return Brano.builder()
                .nome(request.getNome())
                .durata(duration)
                .build();
    }

    public BranoResponse buildResponse(Brano brano) {
        String durataString = brano.getDurata().toMinutes() + ":" + brano.getDurata().getSeconds() % 60;
        return BranoResponse.builder()
                .idBrano(brano.getIdBrano())
                .durata(durataString)
                .nome(brano.getNome())
                .build();
    }
}
