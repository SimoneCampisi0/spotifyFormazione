package com.simonecampisi.spotifyFormazione.dto.request.abstraction;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public abstract class AbstractArtistaRequest implements IRequest {

    @NotEmpty(message = "Nome obbligatorio.")
    private String nome;

    @NotEmpty(message = "Immagine obbligatoria.")
    private String imgProfilo;
}
