package com.simonecampisi.spotifyFormazione.controller;

import com.simonecampisi.spotifyFormazione.controller.abstraction.AbstractController;
import com.simonecampisi.spotifyFormazione.dto.request.artista.CreateArtistaRequest;
import com.simonecampisi.spotifyFormazione.dto.request.artista.ModificaArtistaRequest;
import com.simonecampisi.spotifyFormazione.dto.response.ErrorsResponse;
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
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((ArtistaService)service).createArtista(request));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @PutMapping()
    @Operation(summary  = "Modifica un artista.")
    public ResponseEntity<?> modificaArtista(@Valid @RequestBody ModificaArtistaRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((ArtistaService)service).modificaArtista(request));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Dettaglio artista.")
    public ResponseEntity<?> dettaglioArtista(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((ArtistaService)service).readArtista(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @GetMapping()
    @Operation(summary = "Lista artista.")
    public ResponseEntity<?> listaArtisti(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "nome") String sortBy,
            @RequestParam(defaultValue = "ASC") SortingOrder sortingOrder
    ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((ArtistaService)service).findAllPage(pageNumber, pageSize, sortBy, sortingOrder));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un artista.")
    public ResponseEntity<?> eliminaArtista(@PathVariable Long id) throws Exception {
        try {
            return ((ArtistaService)service).deleteArtista(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }
}
