package com.simonecampisi.spotifyFormazione.dto.request.artista;

import com.simonecampisi.spotifyFormazione.dto.request.abstraction.AbstractArtistaRequest;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
public class ModificaArtistaRequest extends AbstractArtistaRequest {
    private Long idArtista;
}
