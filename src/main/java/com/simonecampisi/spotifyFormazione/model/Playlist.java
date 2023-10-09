package com.simonecampisi.spotifyFormazione.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Playlist {
    @Id
    private Long idPlaylist;

    private String nome;

    @ManyToMany
    @JoinTable(
            name = "brani_playlist")
    private Set<Brano> elencoBrani;
}
