package com.simonecampisi.spotifyFormazione.controller;

import com.simonecampisi.spotifyFormazione.controller.abstraction.AbstractController;
import com.simonecampisi.spotifyFormazione.dto.request.CreateArtistaRequest;
import com.simonecampisi.spotifyFormazione.dto.request.ModificaArtistaRequest;
import com.simonecampisi.spotifyFormazione.model.Artista;
import com.simonecampisi.spotifyFormazione.service.ArtistaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("gestione-artisti")
//@CrossOrigin("http://localhost:4200/")
public class ArtistaController extends AbstractController<Artista, Long> {

    @PostMapping()
    @Operation(summary  = "Crea un artista.")
    public ResponseEntity<?> createArtista(@Valid @RequestBody CreateArtistaRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(((ArtistaService)service).createArtista(request));
    }

    @PutMapping()
    @Operation(summary  = "Modifica un artista.")
    public ResponseEntity<?> modificaArtista(@Valid @RequestBody ModificaArtistaRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(((ArtistaService)service).modificaArtista(request));
    }
}
