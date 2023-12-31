package com.simonecampisi.spotifyFormazione.repository;

import com.simonecampisi.spotifyFormazione.model.Utente;
import com.simonecampisi.spotifyFormazione.repository.abstraction.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends GenericRepository<Utente, Long> {
    Page<Utente> findAll(Pageable pageable);

}
