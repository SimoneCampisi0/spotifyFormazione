package com.simonecampisi.spotifyFormazione.repository;

import com.simonecampisi.spotifyFormazione.model.Utente;
import com.simonecampisi.spotifyFormazione.repository.abstraction.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends GenericRepository<Utente, Long> {
}
