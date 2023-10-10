package com.simonecampisi.spotifyFormazione.service.helper;

import com.simonecampisi.spotifyFormazione.dto.request.abstraction.AbstractPlaylistRequest;
import com.simonecampisi.spotifyFormazione.model.Playlist;
import com.simonecampisi.spotifyFormazione.service.helper.abstraction.IHelper;
import org.springframework.stereotype.Component;

@Component
public class PlaylistHelper implements IHelper<Playlist, AbstractPlaylistRequest> {

    @Override
    public Playlist buildEntityFromRequest(AbstractPlaylistRequest request) {
        return null;
    }
}
