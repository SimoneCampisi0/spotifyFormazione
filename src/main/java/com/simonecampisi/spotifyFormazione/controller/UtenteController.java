package com.simonecampisi.spotifyFormazione.controller;

import com.simonecampisi.spotifyFormazione.controller.abstraction.AbstractController;
import com.simonecampisi.spotifyFormazione.dto.request.utente.CreateUtenteRequest;
import com.simonecampisi.spotifyFormazione.dto.request.utente.ModificaUtenteRequest;
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

    @PutMapping
    @Operation(summary = "Modifica un utente")
    public ResponseEntity<?> modificaUtente(@Valid @RequestBody ModificaUtenteRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(((UtenteService)service).modificaUtente(request));
    }

    @GetMapping
    @Operation(summary = "Dettaglio di un utente")
    public ResponseEntity<?> dettaglioUtente(@RequestParam Long idUtente) {
        return ResponseEntity.status(HttpStatus.OK).body(((UtenteService)service).readUtente(idUtente));
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

    @DeleteMapping
    @Operation(summary = "Elimina un utente.")
    public ResponseEntity<?> eliminaUtente(@RequestParam Long idUtente) {
        service.deleteById(idUtente);
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }


}
