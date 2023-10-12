package com.simonecampisi.spotifyFormazione.controller;

import com.simonecampisi.spotifyFormazione.controller.abstraction.AbstractController;
import com.simonecampisi.spotifyFormazione.dto.request.playlist.ManageBranoPlaylistRequest;
import com.simonecampisi.spotifyFormazione.dto.request.playlist.CreatePlaylistRequest;
import com.simonecampisi.spotifyFormazione.dto.request.playlist.ModificaPlaylistRequest;
import com.simonecampisi.spotifyFormazione.dto.response.ErrorsResponse;
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
    @Operation(summary = "Crea una nuova playlist.")
    public ResponseEntity<?> pubblicaPlaylist(@Valid @RequestBody CreatePlaylistRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((PlaylistService)service).createPlaylist(request));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @PutMapping()
    @Operation(summary = "Modifica una playlist.")
    public ResponseEntity<?> modificaPlaylist(@Valid @RequestBody ModificaPlaylistRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((PlaylistService)service).editPlaylist(request));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @PostMapping("/aggiungi-brano-playlist")
    @Operation(summary = "Aggiungi un brano in una playlist.")
    public ResponseEntity<?> aggiungiBranoPlaylist(@Valid @RequestBody ManageBranoPlaylistRequest request) {
        try {
            return ((PlaylistService)service).addBranoToPlaylist(request);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @PostMapping("/rimuovi-brano-playlist")
    @Operation(summary = "Rimuovi un brano da una playlist.")
    public ResponseEntity<?> rimuoviBranoPlaylist(@Valid @RequestBody ManageBranoPlaylistRequest request) {
        try {
            return ((PlaylistService)service).deleteBranoFromPlaylist(request);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @GetMapping("/lista-playlist-utente/{idUtente}")
    @Operation(summary = "Lista delle playlist create da un utente.")
    public ResponseEntity<?> listaPlaylist(@PathVariable Long idUtente) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((PlaylistService)service).listaPlaylist(idUtente));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Dettaglio di una playlist.")
    public ResponseEntity<?> dettaglioPlaylist(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((PlaylistService)service).readPlaylist(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminazione di una playlist.")
    public ResponseEntity<?> deletePlaylist(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((PlaylistService)service).deletePlaylist(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }
}
