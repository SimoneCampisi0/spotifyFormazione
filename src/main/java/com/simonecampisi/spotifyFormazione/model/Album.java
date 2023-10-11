package com.simonecampisi.spotifyFormazione.model;

import com.simonecampisi.spotifyFormazione.model.enums.GenereMusicale;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(exclude = "elencoBrani")
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
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Artista artista;

    @OneToMany(mappedBy = "album")
    private Set<Brano> elencoBrani = new HashSet<>();
}
