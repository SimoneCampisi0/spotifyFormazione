package com.simonecampisi.spotifyFormazione.dto.request.abstraction;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public abstract class AbstractBranoRequest implements IRequest {
    @NotBlank(message = "Nome brano obbligatorio.")
    private String nome;

    @NotNull(message = "Minuti obbligatorio.")
    private Long minuti;

    @NotNull(message = "Secondi obbligatorio.")
    private Long secondi;

}
