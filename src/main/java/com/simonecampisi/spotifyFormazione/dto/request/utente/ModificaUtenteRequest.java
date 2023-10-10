package com.simonecampisi.spotifyFormazione.dto.request.utente;

import com.simonecampisi.spotifyFormazione.dto.request.abstraction.AbstractUtenteRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ModificaUtenteRequest extends AbstractUtenteRequest {
    @NotNull(message = "ID utente obbligatorio.")
    private Long idUtente;
}
