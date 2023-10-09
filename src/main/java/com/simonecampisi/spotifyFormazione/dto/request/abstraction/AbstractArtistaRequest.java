package com.simonecampisi.spotifyFormazione.dto.request.abstraction;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Lob;

@Data
public abstract class AbstractArtistaRequest implements IRequest {
    private String nome;

    private byte [] imgProfilo;
}
