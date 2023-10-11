package com.simonecampisi.spotifyFormazione.repository;

import com.simonecampisi.spotifyFormazione.model.Playlist;
import com.simonecampisi.spotifyFormazione.model.Utente;
import com.simonecampisi.spotifyFormazione.repository.abstraction.GenericRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PlaylistRepository extends GenericRepository<Playlist, Long> {
    void deleteAllByUtente(Utente utente);

    List<Playlist> findAllByUtenteIdUtente(Long idUtente);
}
