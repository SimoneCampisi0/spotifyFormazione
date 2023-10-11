package com.simonecampisi.spotifyFormazione.dto.request.abstraction;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
public abstract class AbstractPlaylistRequest implements IRequest {

    @NotEmpty(message = "Nome obbligatorio.")
    private String nome;

    @NotNull(message = "Utente obbligatorio.")
    private Long idUtente;

    @NotNull(message = "Data creazione obbligatorio.")
    private LocalDate dataCreazione;
}
