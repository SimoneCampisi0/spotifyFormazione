package com.simonecampisi.spotifyFormazione.dto.response.utente;

import com.simonecampisi.spotifyFormazione.dto.response.abstraction.AbstractUtenteResponse;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ViewUtenteResponse extends AbstractUtenteResponse {
    private Integer numPlaylist;

    private Long numBraniPlaylist;

    private String totaleDurataPlayList;
}
