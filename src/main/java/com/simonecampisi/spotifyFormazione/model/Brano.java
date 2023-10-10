package com.simonecampisi.spotifyFormazione.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Brano {
    @Id
    private Long idBrano;

    private String nome;

    private Duration durata;

    @ManyToMany
    private Set<Playlist> elencoPlaylist;

    @ManyToOne
    @JoinColumn(name = "idAlbum", nullable = false)
    private Album album;
}
