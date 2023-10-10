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
public class Utente {
    @Id
    private Long idUtente;

    private String nomeUtente;

    private String email;

    @Lob
    @Column(name = "imgProfilo", columnDefinition = "BLOB")
    private byte [] imgProfilo;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Playlist> elencoPlaylist;
}
