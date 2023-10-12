package com.simonecampisi.spotifyFormazione.controller;

import com.simonecampisi.spotifyFormazione.controller.abstraction.AbstractController;
import com.simonecampisi.spotifyFormazione.dto.request.artista.CreateArtistaRequest;
import com.simonecampisi.spotifyFormazione.dto.request.artista.ModificaArtistaRequest;
import com.simonecampisi.spotifyFormazione.model.Artista;
import com.simonecampisi.spotifyFormazione.model.enums.SortingOrder;
import com.simonecampisi.spotifyFormazione.service.ArtistaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("artists")
//@CrossOrigin("http://localhost:4200/")
public class ArtistaController extends AbstractController<Artista, Long> {

    @PostMapping("/new")
    @Operation(summary  = "Crea un artista.")
    public ResponseEntity<?> createArtista(@Valid @RequestBody CreateArtistaRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(((ArtistaService)service).createArtista(request));
    }

    @PutMapping()
    @Operation(summary  = "Modifica un artista.")
    public ResponseEntity<?> modificaArtista(@Valid @RequestBody ModificaArtistaRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(((ArtistaService)service).modificaArtista(request));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Dettaglio artista.")
    public ResponseEntity<?> dettaglioArtista(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(((ArtistaService)service).readArtista(id));
    }

    @GetMapping()
    @Operation(summary = "Lista artista.")
    public ResponseEntity<?> listaArtisti(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "nome") String sortBy,
            @RequestParam(defaultValue = "ASC") SortingOrder sortingOrder
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(((ArtistaService)service).findAllPage(pageNumber, pageSize, sortBy, sortingOrder));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un artista.")
    public ResponseEntity<?> eliminaArtista(@PathVariable Long id) throws Exception {
        ((ArtistaService)service).deleteArtista(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
