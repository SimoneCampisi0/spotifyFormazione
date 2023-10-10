package com.simonecampisi.spotifyFormazione.dto.request.brano;

import com.simonecampisi.spotifyFormazione.dto.request.abstraction.AbstractBranoRequest;
import lombok.Data;

@Data
public class CreateBranoRequest extends AbstractBranoRequest {

    private Long idAlbum;
}
