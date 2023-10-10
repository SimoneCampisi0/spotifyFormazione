package com.simonecampisi.spotifyFormazione.dto.request.brano;

import com.simonecampisi.spotifyFormazione.dto.request.abstraction.AbstractBranoRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ModificaBranoRequest extends AbstractBranoRequest {
    @NotNull(message = "ID brano obbligatorio")
    private Long idBrano;

    @NotNull(message = "Album obbligatorio.")
    private Long idAlbum;
}
