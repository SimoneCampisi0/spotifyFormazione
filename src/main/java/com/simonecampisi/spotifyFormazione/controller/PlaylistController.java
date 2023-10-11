package com.simonecampisi.spotifyFormazione.controller;

import com.simonecampisi.spotifyFormazione.controller.abstraction.AbstractController;
import com.simonecampisi.spotifyFormazione.dto.request.playlist.AddBranoPlaylistRequest;
import com.simonecampisi.spotifyFormazione.dto.request.playlist.CreatePlaylistRequest;
import com.simonecampisi.spotifyFormazione.dto.request.playlist.ModificaPlaylistRequest;
import com.simonecampisi.spotifyFormazione.model.Playlist;
import com.simonecampisi.spotifyFormazione.service.PlaylistService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("playlists")
//@CrossOrigin("http://localhost:4200/")
public class PlaylistController extends AbstractController<Playlist, Long> {
    @PostMapping("/new")
    @Operation(summary = "Crea una nuova playlist")
    public ResponseEntity<?> pubblicaPlaylist(@Valid @RequestBody CreatePlaylistRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(((PlaylistService)service).createPlaylist(request));
    }

    @PutMapping()
    @Operation(summary = "Modifica una playlist")
    public ResponseEntity<?> modificaPlaylist(@Valid @RequestBody ModificaPlaylistRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(((PlaylistService)service).editPlaylist(request));
    }

    @PostMapping("/aggiungi-brano-playlist")
    @Operation(summary = "Aggiungi un brano in una playlist")
    public ResponseEntity<?> aggiungiBrano(@Valid @RequestBody AddBranoPlaylistRequest request) {
        return ((PlaylistService)service).addBranoToPlaylist(request);
    }

    @GetMapping
    @Operation(summary = "Lista delle playlist create da un utente")
    public ResponseEntity<?> listaPlaylist(@RequestParam Long idUtente) {
        return ResponseEntity.status(HttpStatus.OK).body(((PlaylistService)service).listaPlaylist(idUtente));
    }

}
