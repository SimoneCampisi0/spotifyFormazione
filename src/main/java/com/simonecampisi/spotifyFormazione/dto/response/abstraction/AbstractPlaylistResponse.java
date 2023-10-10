package com.simonecampisi.spotifyFormazione.dto.response.abstraction;

import lombok.Data;
import lombok.experimental.SuperBuilder;
@Data
@SuperBuilder
public abstract class AbstractPlaylistResponse {
    private Long idPlaylist;

    private String nome;
}
