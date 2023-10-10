package com.simonecampisi.spotifyFormazione.service.helper;


import com.simonecampisi.spotifyFormazione.dto.request.abstraction.AbstractBranoRequest;
import com.simonecampisi.spotifyFormazione.model.Brano;
import com.simonecampisi.spotifyFormazione.service.helper.abstraction.IHelper;
import org.springframework.stereotype.Component;

@Component
public class BranoHelper implements IHelper<Brano, AbstractBranoRequest> {

    @Override
    public Brano buildEntityFromRequest(AbstractBranoRequest request) {
        return null;
    }
}
