package com.simonecampisi.spotifyFormazione.dto.response.album;

import com.simonecampisi.spotifyFormazione.dto.response.abstraction.AbstractAlbumResponse;
import lombok.Data;
import lombok.experimental.SuperBuilder;
@Data
@SuperBuilder
public class AlbumResponse extends AbstractAlbumResponse {
    private Integer numTracks;

    private String totalDuration;
}
