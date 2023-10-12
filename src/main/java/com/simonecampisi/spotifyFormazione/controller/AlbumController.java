package com.simonecampisi.spotifyFormazione.controller;

import com.simonecampisi.spotifyFormazione.controller.abstraction.AbstractController;
import com.simonecampisi.spotifyFormazione.dto.request.album.CreateAlbumRequest;
import com.simonecampisi.spotifyFormazione.dto.request.album.ModificaAlbumRequest;
import com.simonecampisi.spotifyFormazione.dto.response.ErrorsResponse;
import com.simonecampisi.spotifyFormazione.model.Album;
import com.simonecampisi.spotifyFormazione.model.enums.SortingOrder;
import com.simonecampisi.spotifyFormazione.service.AlbumService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("albums")
//@CrossOrigin("http://localhost:4200/")
public class AlbumController extends AbstractController<Album, Long> {

    @PostMapping("/new")
    @Operation(summary = "Aggiungi album.")
    public ResponseEntity<?> aggiungiAlbum (@Valid @RequestBody CreateAlbumRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((AlbumService)service).addAlbum(request));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @PutMapping()
    @Operation(summary = "Modifica album.")
    public ResponseEntity<?> aggiungiAlbum (@Valid @RequestBody ModificaAlbumRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((AlbumService)service).modificaAlbum(request));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Dettaglio di un album.")
    public ResponseEntity<?> dettaglioAlbum (@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((AlbumService)service).readAlbum(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @GetMapping()
    @Operation(summary = "Lista di tutti gli album.")
    public ResponseEntity<?> listAlbum (@RequestParam(defaultValue = "0") Integer pageNumber,
                                        @RequestParam(defaultValue = "10") Integer pageSize,
                                        @RequestParam(defaultValue = "titolo") String sortBy,
                                        @RequestParam(defaultValue = "ASC") SortingOrder sortingOrder,
                                        @RequestParam(required = false) String sortingFilter) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((AlbumService)service).listAlbum(pageNumber, pageSize, sortBy, sortingOrder, sortingFilter));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @GetMapping("/lista-album-da-artista")
    @Operation(summary = "Lista di tutti gli album da idArtista.")
    public ResponseEntity<?> listAlbum (@RequestParam(defaultValue = "0") Integer pageNumber,
                                        @RequestParam(defaultValue = "10") Integer pageSize,
                                        @RequestParam(defaultValue = "titolo") String sortBy,
                                        @RequestParam(defaultValue = "ASC") SortingOrder sortingOrder,
                                        @RequestParam Long idArtista) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((AlbumService)service).listAlbumPerArtista(pageNumber, pageSize, sortBy, sortingOrder, idArtista));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @DeleteMapping("/elimina-album/{id}")
    @Operation(summary = "Eliminazione di un album.")
    public ResponseEntity<?> eliminaAlbum (@PathVariable Long id) {
        try {
            return ((AlbumService)service).deleteAlbum(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

}
