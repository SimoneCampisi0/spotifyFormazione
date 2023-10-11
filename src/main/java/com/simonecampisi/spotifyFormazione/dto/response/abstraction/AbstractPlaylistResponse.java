package com.simonecampisi.spotifyFormazione.dto.response.abstraction;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
public abstract class AbstractPlaylistResponse {
    private Long idPlaylist;

    private String nome;

    private LocalDate dataCreazione;
}
