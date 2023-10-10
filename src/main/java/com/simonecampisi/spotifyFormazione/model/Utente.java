package com.simonecampisi.spotifyFormazione.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "elencoPlaylist")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtente;

    private String nomeUtente;

    private String email;

    @Lob
    @Column(name = "imgProfilo", columnDefinition = "BLOB")
    private byte [] imgProfilo;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Playlist> elencoPlaylist;
}
