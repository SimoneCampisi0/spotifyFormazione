package com.simonecampisi.spotifyFormazione.controller;

import com.simonecampisi.spotifyFormazione.controller.abstraction.AbstractController;
import com.simonecampisi.spotifyFormazione.dto.request.CreateArtistaRequest;
import com.simonecampisi.spotifyFormazione.model.Artista;
import com.simonecampisi.spotifyFormazione.service.ArtistaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gestione-artisti")
//@CrossOrigin("http://localhost:4200/")
public class ArtistaController extends AbstractController<Artista, Long> {

    @PostMapping()
    @Operation(summary  = "Crea un artista.")
    public ResponseEntity<?> createArtista(@RequestBody CreateArtistaRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(((ArtistaService)service).createArtista(request));
    }
}
