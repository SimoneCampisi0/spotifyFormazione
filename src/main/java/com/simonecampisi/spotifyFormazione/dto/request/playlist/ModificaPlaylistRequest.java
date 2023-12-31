package com.simonecampisi.spotifyFormazione.dto.request.playlist;

import com.simonecampisi.spotifyFormazione.dto.request.abstraction.AbstractPlaylistRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ModificaPlaylistRequest extends AbstractPlaylistRequest {
    @NotNull(message = "ID playlist obbligatorio")
    private Long idPlaylist;
}
