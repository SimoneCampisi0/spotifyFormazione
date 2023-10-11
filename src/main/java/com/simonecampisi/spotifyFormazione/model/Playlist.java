package com.simonecampisi.spotifyFormazione.model;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlaylist;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Utente utente;

//    @ManyToMany(mappedBy = "elencoPlaylist")
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    private Set<Brano> elencoBrani;

    @ManyToMany
    @JoinTable(
            name = "playlist_brani",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "brano_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Brano> elencoBrani = new HashSet<>();
}
