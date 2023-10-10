package com.simonecampisi.spotifyFormazione.dto.request.abstraction;

import lombok.Data;

@Data
public abstract class AbstractBranoRequest implements IRequest {
    private String nome;

    private Long minuti;

    private Long secondi;

}
