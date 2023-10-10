package com.simonecampisi.spotifyFormazione.controller;

import com.simonecampisi.spotifyFormazione.controller.abstraction.AbstractController;
import com.simonecampisi.spotifyFormazione.dto.request.utente.CreateUtenteRequest;
import com.simonecampisi.spotifyFormazione.model.Utente;
import com.simonecampisi.spotifyFormazione.model.enums.SortingOrder;
import com.simonecampisi.spotifyFormazione.service.UtenteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("utenti")
//@CrossOrigin("http://localhost:4200/")
public class UtenteController extends AbstractController<Utente, Long> {
    @PostMapping
    @Operation(summary = "Aggiungi un utente")
    public ResponseEntity<?> aggiungiUtente(@Valid @RequestBody CreateUtenteRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(((UtenteService)service).createUtente(request));
    }

    @GetMapping("/lista-utenti")
    @Operation(summary = "Lista utenti.")
    public ResponseEntity<?> listaUtenti(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "idUtente") String sortBy,
            @RequestParam(defaultValue = "ASC") SortingOrder sortingOrder
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(((UtenteService)service).findAllUtenti(pageNumber, pageSize, sortBy, sortingOrder));
    }


}
