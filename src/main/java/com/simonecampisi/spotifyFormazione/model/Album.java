package com.simonecampisi.spotifyFormazione.model;

import com.simonecampisi.spotifyFormazione.model.enums.GenereMusicale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlbum;

    private String titolo;

    private GenereMusicale genereMusicale;

    private LocalDate dataUscita;

    @Lob
    @Column(name = "cover", columnDefinition = "BLOB")
    private byte [] cover;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    @OneToMany(mappedBy = "album")
    private Set<Brano> elencoBrani;
}
