package com.simonecampisi.spotifyFormazione.service;

import com.simonecampisi.spotifyFormazione.dto.request.playlist.CreatePlaylistRequest;
import com.simonecampisi.spotifyFormazione.dto.request.playlist.ModificaPlaylistRequest;
import com.simonecampisi.spotifyFormazione.dto.response.playlist.PlaylistResponse;
import com.simonecampisi.spotifyFormazione.model.Playlist;
import com.simonecampisi.spotifyFormazione.service.abstraction.GenericService;
import com.simonecampisi.spotifyFormazione.service.helper.PlaylistHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService extends GenericService<Playlist, Long> {
    @Autowired
    private PlaylistHelper helper;

    public PlaylistResponse createPlaylist(CreatePlaylistRequest request) {
        return helper.buildResponse(super.create(helper.buildEntityFromRequest(request)));
    }

    public PlaylistResponse editPlaylist(ModificaPlaylistRequest request) {
        Playlist playlist = helper.buildEntityForUpdate(request, super.read(request.getIdPlaylist()));
        return helper.buildResponse(super.update(playlist));
    }
}
