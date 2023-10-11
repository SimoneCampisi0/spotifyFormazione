package com.simonecampisi.spotifyFormazione.dto.request.album;

import com.simonecampisi.spotifyFormazione.dto.request.abstraction.AbstractAlbumRequest;
import lombok.Data;

@Data
public class ModificaAlbumRequest extends AbstractAlbumRequest {
    private Long idAlbum;
}
