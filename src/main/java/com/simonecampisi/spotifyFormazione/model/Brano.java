package com.simonecampisi.spotifyFormazione.model;

import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.util.HashSet;
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
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Album album;

    @ManyToMany(mappedBy = "elencoBrani")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Playlist> elencoPlaylist = new HashSet<>();
}
