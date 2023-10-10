package com.simonecampisi.spotifyFormazione.repository;

import com.simonecampisi.spotifyFormazione.model.Playlist;
import com.simonecampisi.spotifyFormazione.repository.abstraction.GenericRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlaylistRepository extends GenericRepository<Playlist, Long> {
}
