package com.simonecampisi.spotifyFormazione.service.helper;

import com.simonecampisi.spotifyFormazione.dto.request.abstraction.AbstractPlaylistRequest;
import com.simonecampisi.spotifyFormazione.dto.request.playlist.ModificaPlaylistRequest;
import com.simonecampisi.spotifyFormazione.dto.response.playlist.PlaylistResponse;
import com.simonecampisi.spotifyFormazione.model.Playlist;
import com.simonecampisi.spotifyFormazione.repository.UtenteRepository;
import com.simonecampisi.spotifyFormazione.service.helper.abstraction.IHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlaylistHelper implements IHelper<Playlist, AbstractPlaylistRequest> {

    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public Playlist buildEntityFromRequest(AbstractPlaylistRequest request) {
        return Playlist.builder()
                .nome(request.getNome())
                .utente(utenteRepository.findById(request.getIdUtente()).orElseThrow(
                        () -> new RuntimeException("Elemento con ID "+request.getIdUtente()+ " non trovato."))
                )
                .build();
    }

    public Playlist buildEntityForUpdate(ModificaPlaylistRequest request, Playlist playlist) {
        playlist.setNome(request.getNome());
        playlist.setUtente(utenteRepository.findById(request.getIdUtente()).orElseThrow(
                () -> new RuntimeException("Elemento con ID "+request.getIdUtente()+ " non trovato."))
        );
        return playlist;
    }

    public PlaylistResponse buildResponse(Playlist playlist) {
        return PlaylistResponse.builder()
                .idPlaylist(playlist.getIdPlaylist())
                .nome(playlist.getNome())
                .build();
    }
}
