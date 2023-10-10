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

    @PutMapping
    @Operation(summary = "Modifica brano")
    public ResponseEntity<?> modificaBrano (@Valid @RequestBody ModificaBranoRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(((BranoService)service).modificaBrano(request));
    }
}