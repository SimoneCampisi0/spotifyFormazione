package com.simonecampisi.spotifyFormazione.repository;

import com.simonecampisi.spotifyFormazione.model.Artista;
import com.simonecampisi.spotifyFormazione.repository.abstraction.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository

public interface ArtistaRepository extends GenericRepository<Artista, Long> {
    Page<Artista> findAll(Pageable pageable);
}
