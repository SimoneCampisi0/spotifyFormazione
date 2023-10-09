package com.simonecampisi.spotifyFormazione.dto.request;

import com.simonecampisi.spotifyFormazione.dto.request.abstraction.AbstractArtistaRequest;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
public class ModificaArtistaRequest extends AbstractArtistaRequest {
    private Long idArtista;
}
