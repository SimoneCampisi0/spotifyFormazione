package com.simonecampisi.spotifyFormazione.controller;

import com.simonecampisi.spotifyFormazione.controller.abstraction.AbstractController;
import com.simonecampisi.spotifyFormazione.dto.request.utente.CreateUtenteRequest;
import com.simonecampisi.spotifyFormazione.dto.request.utente.ModificaUtenteRequest;
import com.simonecampisi.spotifyFormazione.dto.response.ErrorsResponse;
import com.simonecampisi.spotifyFormazione.model.Utente;
import com.simonecampisi.spotifyFormazione.model.enums.SortingOrder;
import com.simonecampisi.spotifyFormazione.service.UtenteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("users")
//@CrossOrigin("http://localhost:4200/")
public class UtenteController extends AbstractController<Utente, Long> {
    @PostMapping("/new")
    @Operation(summary = "Aggiungi un utente.")
    public ResponseEntity<?> aggiungiUtente(@Valid @RequestBody CreateUtenteRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((UtenteService)service).createUtente(request));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @PutMapping
    @Operation(summary = "Modifica un utente.")
    public ResponseEntity<?> modificaUtente(@Valid @RequestBody ModificaUtenteRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((UtenteService)service).modificaUtente(request));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Dettaglio di un utente.")
    public ResponseEntity<?> dettaglioUtente(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((UtenteService)service).readUtente(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @GetMapping("/lista-utenti")
    @Operation(summary = "Lista utenti.")
    public ResponseEntity<?> listaUtenti(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "idUtente") String sortBy,
            @RequestParam(defaultValue = "ASC") SortingOrder sortingOrder
    ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((UtenteService)service).findAllUtenti(pageNumber, pageSize, sortBy, sortingOrder));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un utente.")
    public ResponseEntity<?> eliminaUtente(@PathVariable Long id) {
        try {
            ((UtenteService)service).deleteUtente(id);
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }


}
