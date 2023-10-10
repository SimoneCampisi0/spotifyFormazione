package com.simonecampisi.spotifyFormazione.dto.response.abstraction;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.Duration;

@Data
@SuperBuilder
public abstract class AbstractBranoResponse{
    private Long idBrano;

    private String nome;

    private Duration durata;
}
