package com.simonecampisi.spotifyFormazione.model;
import lombok.*;

import javax.persistence.*;
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

    @ManyToMany(mappedBy = "elencoPlaylist")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Brano> elencoBrani;
}
