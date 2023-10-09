package com.simonecampisi.spotifyFormazione.controller;

import com.simonecampisi.spotifyFormazione.controller.abstraction.AbstractController;
import com.simonecampisi.spotifyFormazione.dto.request.album.CreateAlbumRequest;
import com.simonecampisi.spotifyFormazione.dto.response.album.AlbumResponse;
import com.simonecampisi.spotifyFormazione.model.Album;
import com.simonecampisi.spotifyFormazione.model.enums.SortingOrder;
import com.simonecampisi.spotifyFormazione.service.AlbumService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("gestione-album")
//@CrossOrigin("http://localhost:4200/")
public class AlbumController extends AbstractController<Album, Long> {

    @PostMapping
    @Operation(summary = "Aggiungi album")
    public ResponseEntity<?> aggiungiAlbum (@Valid @RequestBody CreateAlbumRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(((AlbumService)service).addAlbum(request));
    }

    @GetMapping
    @Operation(summary = "Lista di tutti gli album")
    public ResponseEntity<?> listAlbum (@RequestParam(defaultValue = "0") Integer pageNumber,
                                        @RequestParam(defaultValue = "10") Integer pageSize,
                                        @RequestParam(defaultValue = "nome") String sortBy,
                                        @RequestParam(defaultValue = "ASC") SortingOrder sortingOrder) {
        return ResponseEntity.status(HttpStatus.OK).body(((AlbumService)service).listAlbum(pageNumber, pageSize, sortBy, sortingOrder));
    }
}
