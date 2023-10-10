package com.simonecampisi.spotifyFormazione.dto.request.abstraction;


import lombok.Data;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
public abstract class AbstractUtenteRequest implements IRequest {
    @NotBlank(message = "Nome utente obbligatorio.")
    private String nomeUtente;

    @Email
    private String email;

    @NotBlank(message = "Immagine del profilo obbligatoria.")
    private String imgProfilo;
}
