package com.simonecampisi.spotifyFormazione.controller;

import com.simonecampisi.spotifyFormazione.controller.abstraction.AbstractController;
import com.simonecampisi.spotifyFormazione.dto.request.brano.CreateBranoRequest;
import com.simonecampisi.spotifyFormazione.dto.request.brano.ModificaBranoRequest;
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
    @Operation(summary = "Aggiungi brano")
    public ResponseEntity<?> aggiungiBrano (@Valid @RequestBody CreateBranoRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(((BranoService)service).addBrano(request));
    }

    @GetMapping("/lista-brani-album")
    @Operation(summary = "Lista di tutti i brani per album")
    public ResponseEntity<?> listaBrani (@RequestParam Long idAlbum) {
        return ResponseEntity.status(HttpStatus.OK).body(((BranoService)service).listaBrani(idAlbum));
    }

    @GetMapping("/lista-brani-playlist")
    @Operation(summary = "Lista di tutti i brani per playlist")
    public ResponseEntity<?> listaBraniPerPlaylist (@RequestParam Long idPlaylist) {
        return ResponseEntity.status(HttpStatus.OK).body(((BranoService)service).listaBraniPerPlaylist(idPlaylist));
    }

    @GetMapping("/lista-selezione-brani")
    @Operation(summary = "Lista di tutti i brani l'inserimento in playlist.")
    public ResponseEntity<?> listaBraniPerPlaylist () {
        return ResponseEntity.status(HttpStatus.OK).body(((BranoService)service).listaBraniPerInserimento());
    }

    @PutMapping
    @Operation(summary = "Modifica brano")
    public ResponseEntity<?> modificaBrano (@Valid @RequestBody ModificaBranoRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(((BranoService)service).modificaBrano(request));
    }

    @DeleteMapping
    @Operation(summary = "Elimina brano da un album")
    public ResponseEntity<?> eliminaBrano (@RequestParam Long idBrano) {
        return ResponseEntity.status(HttpStatus.OK).body(((BranoService)service).eliminaBrano(idBrano));
    }


}
