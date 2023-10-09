package com.simonecampisi.spotifyFormazione.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Utente {
    @Id
    private Long idUtente;

    @NotBlank(message = "Nome utente obbligatorio.")
    private String nomeUtente;

    @Email
    private String email;

    @Lob
    @Column(name = "imgProfilo", columnDefinition = "BLOB")
    private byte [] imgProfilo;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Playlist> elencoPlaylist;
}