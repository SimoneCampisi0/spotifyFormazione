package com.simonecampisi.spotifyFormazione.dto.response.abstraction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Lob;

@Data
public abstract class AbstractArtistaResponse {
    private Long id;

    private String nome;

    private byte [] imgProfilo;
}
