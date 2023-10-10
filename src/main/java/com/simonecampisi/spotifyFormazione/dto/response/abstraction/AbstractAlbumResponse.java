package com.simonecampisi.spotifyFormazione.dto.response.abstraction;

import com.simonecampisi.spotifyFormazione.dto.response.artista.ArtistaResponse;
import com.simonecampisi.spotifyFormazione.model.enums.GenereMusicale;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.Lob;
import java.time.LocalDate;

@Data
@SuperBuilder
public abstract class AbstractAlbumResponse {
    private Long idAlbum;

    private String titolo;

    private GenereMusicale genereMusicale;

    private LocalDate dataUscita;

    private byte [] cover;

    private ArtistaResponse artistaResponse;
}
