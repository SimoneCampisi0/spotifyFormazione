package com.simonecampisi.spotifyFormazione.repository;

import com.simonecampisi.spotifyFormazione.model.Brano;
import com.simonecampisi.spotifyFormazione.repository.abstraction.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranoRepository extends GenericRepository<Brano, Long> {

}
