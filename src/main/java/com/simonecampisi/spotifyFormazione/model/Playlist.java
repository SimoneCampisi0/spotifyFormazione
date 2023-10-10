package com.simonecampisi.spotifyFormazione.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Playlist {
    @Id
    private Long idPlaylist;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToMany(mappedBy = "elencoPlaylist")
    private Set<Brano> elencoBrani;
}
