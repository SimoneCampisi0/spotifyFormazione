package com.simonecampisi.spotifyFormazione.dto.request.playlist;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ManageBranoPlaylistRequest {
    @NotNull(message = "ID playlist obbligatorio")
    private Long idPlaylist;

    @NotNull(message = "ID brano da aggiungere obbligatorio")
    private Long idBrano;
}
