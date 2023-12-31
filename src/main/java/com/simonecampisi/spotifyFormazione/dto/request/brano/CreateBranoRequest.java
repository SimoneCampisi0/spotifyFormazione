package com.simonecampisi.spotifyFormazione.dto.request.brano;

import com.simonecampisi.spotifyFormazione.dto.request.abstraction.AbstractBranoRequest;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreateBranoRequest extends AbstractBranoRequest {
    @NotNull(message = "Album obbligatorio.")
    private Long idAlbum;
}
