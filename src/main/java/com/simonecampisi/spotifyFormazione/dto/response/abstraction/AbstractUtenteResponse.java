package com.simonecampisi.spotifyFormazione.dto.response.abstraction;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class AbstractUtenteResponse {
    private Long idUtente;

    private String nomeUtente;

    private String email;

    private byte [] imgProfilo;
}
