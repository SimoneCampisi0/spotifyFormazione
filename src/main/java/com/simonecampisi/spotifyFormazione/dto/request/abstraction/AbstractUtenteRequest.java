package com.simonecampisi.spotifyFormazione.dto.request.abstraction;


import lombok.Data;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


@Data
public abstract class AbstractUtenteRequest implements IRequest {
    @NotBlank(message = "Nome utente obbligatorio.")
    private String nomeUtente;

    @Email(message = "Email non valida.", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotEmpty(message = "Email obbligatoria.")
    private String email;

    @NotBlank(message = "Immagine del profilo obbligatoria.")
    private String imgProfilo;
}
