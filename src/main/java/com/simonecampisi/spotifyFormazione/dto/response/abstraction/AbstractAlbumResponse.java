package com.simonecampisi.spotifyFormazione.dto.response.abstraction;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class AbstractAlbumResponse {
    private Long id;

    private String nome;

    private byte [] imgProfilo;
}
