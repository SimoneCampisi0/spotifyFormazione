package com.simonecampisi.spotifyFormazione.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.util.Set;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Brano {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idBrano;

    private String nome;

    private Duration durata;

    @ManyToOne
    @JoinColumn(name = "idAlbum", nullable = false)
    private Album album;

    @ManyToMany
    @JoinTable(
            name = "brani_playlist",
            joinColumns = @JoinColumn(name = "brano_id"),
            inverseJoinColumns = @JoinColumn(name = "playlist_id"))
    private Set<Playlist> elencoPlaylist;
}
