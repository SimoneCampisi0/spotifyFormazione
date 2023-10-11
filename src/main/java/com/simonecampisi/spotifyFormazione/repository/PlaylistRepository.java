package com.simonecampisi.spotifyFormazione.repository;

import com.simonecampisi.spotifyFormazione.model.Playlist;
import com.simonecampisi.spotifyFormazione.model.Utente;
import com.simonecampisi.spotifyFormazione.repository.abstraction.GenericRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface PlaylistRepository extends GenericRepository<Playlist, Long> {
    void deleteAllByUtente(Utente utente);
}
