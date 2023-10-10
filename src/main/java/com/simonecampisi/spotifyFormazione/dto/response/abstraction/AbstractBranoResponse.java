package com.simonecampisi.spotifyFormazione.dto.response.abstraction;

import lombok.Data;
import lombok.experimental.SuperBuilder;
@Data
@SuperBuilder
public abstract class AbstractBranoResponse{
    private Long idBrano;

    private String nome;

    private String durata;
}
