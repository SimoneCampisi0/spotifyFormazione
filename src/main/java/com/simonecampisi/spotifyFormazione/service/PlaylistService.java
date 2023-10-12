package com.simonecampisi.spotifyFormazione.service;

import com.simonecampisi.spotifyFormazione.dto.request.playlist.ManageBranoPlaylistRequest;
import com.simonecampisi.spotifyFormazione.dto.request.playlist.CreatePlaylistRequest;
import com.simonecampisi.spotifyFormazione.dto.request.playlist.ModificaPlaylistRequest;
import com.simonecampisi.spotifyFormazione.dto.response.playlist.PlaylistResponse;
import com.simonecampisi.spotifyFormazione.model.Brano;
import com.simonecampisi.spotifyFormazione.model.Playlist;
import com.simonecampisi.spotifyFormazione.model.Utente;
import com.simonecampisi.spotifyFormazione.repository.PlaylistRepository;
import com.simonecampisi.spotifyFormazione.service.abstraction.GenericService;
import com.simonecampisi.spotifyFormazione.service.helper.PlaylistHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PlaylistService extends GenericService<Playlist, Long> {
    @Autowired
    private PlaylistHelper helper;

    @Autowired
    private BranoService branoService;

    public PlaylistResponse createPlaylist(CreatePlaylistRequest request) {
        return helper.buildResponse(super.create(helper.buildEntityFromRequest(request)));
    }

    public PlaylistResponse readPlaylist(Long idPlaylist) {
        return helper.buildResponse(super.read(idPlaylist));
    }

    public PlaylistResponse editPlaylist(ModificaPlaylistRequest request) {
        Playlist playlist = helper.buildEntityForUpdate(request, super.read(request.getIdPlaylist()));
        return helper.buildResponse(super.update(playlist));
    }

    public ResponseEntity<?> addBranoToPlaylist(ManageBranoPlaylistRequest request) {
        Brano brano = branoService.read(request.getIdBrano());
        Playlist playlist = super.read(request.getIdPlaylist());

        if(!playlist.getElencoBrani().contains(brano)) {
            brano.getElencoPlaylist().add(playlist);
            playlist.getElencoBrani().add(brano);
            super.update(playlist);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<?> deleteBranoFromPlaylist(ManageBranoPlaylistRequest request) {
        Brano brano = branoService.read(request.getIdBrano());
        Playlist playlist = super.read(request.getIdPlaylist());

        if(playlist.getElencoBrani().contains(brano)) {
            brano.getElencoPlaylist().remove(playlist);
            playlist.getElencoBrani().remove(brano);
            super.update(playlist);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @Transactional
    public void deletePlaylistByUtente(Utente utente) {
        ((PlaylistRepository)repository).deleteAllByUtente(utente);
    }

    public ResponseEntity<?> deletePlaylist(Long idPlaylist) {
        Playlist playlist = super.read(idPlaylist);
        if(playlist == null) {
            return ResponseEntity.notFound().build();
        }

        super.deleteById(idPlaylist);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public List<PlaylistResponse> listaPlaylist(Long idUtente) {
        return ((PlaylistRepository)repository).findAllByUtenteIdUtente(idUtente)
                .stream()
                .map(playlist -> helper.buildResponse(playlist))
                .collect(Collectors.toList());
    }
}
