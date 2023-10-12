package com.simonecampisi.spotifyFormazione.controller;

import com.simonecampisi.spotifyFormazione.controller.abstraction.AbstractController;
import com.simonecampisi.spotifyFormazione.dto.request.brano.CreateBranoRequest;
import com.simonecampisi.spotifyFormazione.dto.request.brano.ModificaBranoRequest;
import com.simonecampisi.spotifyFormazione.dto.response.ErrorsResponse;
import com.simonecampisi.spotifyFormazione.model.Brano;
import com.simonecampisi.spotifyFormazione.service.BranoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("gestione-brano")
//@CrossOrigin("http://localhost:4200/")
public class BranoController extends AbstractController<Brano, Long> {
    @PostMapping
    @Operation(summary = "Aggiungi un brano a un album.")
    public ResponseEntity<?> aggiungiBrano (@Valid @RequestBody CreateBranoRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((BranoService)service).addBrano(request));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @GetMapping("/lista-brani-album/{idAlbum}")
    @Operation(summary = "Lista di tutti i brani per album.")
    public ResponseEntity<?> listaBrani (@PathVariable Long idAlbum) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((BranoService)service).listaBrani(idAlbum));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @GetMapping("/lista-brani-playlist/{idPlaylist}")
    @Operation(summary = "Lista di tutti i brani per playlist.")
    public ResponseEntity<?> listaBraniPerPlaylist (@PathVariable Long idPlaylist) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((BranoService)service).listaBraniPerPlaylist(idPlaylist));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @GetMapping("/lista-selezione-brani")
    @Operation(summary = "Lista di tutti i brani l'inserimento in playlist.")
    public ResponseEntity<?> listaBraniPerPlaylist () {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((BranoService)service).listaBraniPerInserimento());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @PutMapping
    @Operation(summary = "Modifica un brano.")
    public ResponseEntity<?> modificaBrano (@Valid @RequestBody ModificaBranoRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((BranoService)service).modificaBrano(request));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un brano da un album.")
    public ResponseEntity<?> eliminaBrano (@PathVariable Long id) {
        try {
            return ((BranoService)service).eliminaBrano(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

}
