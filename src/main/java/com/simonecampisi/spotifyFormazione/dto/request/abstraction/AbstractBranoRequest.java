package com.simonecampisi.spotifyFormazione.dto.request.abstraction;

import lombok.Data;

import java.time.Duration;

@Data
public class AbstractBranoRequest implements IRequest {
    private Long idBrano;

    private String nome;

    private Duration durata;
}
