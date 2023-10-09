package com.simonecampisi.spotifyFormazione.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "elencoAlbum")

public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Lob
    @Column(name = "imgProfilo", columnDefinition = "BLOB")
    private byte [] imgProfilo;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.REMOVE, orphanRemoval = true)
//    @OneToMany(mappedBy = "album")
    private Set<Album> elencoAlbum;
}
