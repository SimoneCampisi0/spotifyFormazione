package com.simonecampisi.spotifyFormazione.repository;

import com.simonecampisi.spotifyFormazione.model.Album;
import com.simonecampisi.spotifyFormazione.repository.abstraction.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AlbumRepository extends GenericRepository<Album, Long> {
    Page<Album> findAll(Pageable pageable);

    Page<Album> findAllByArtista_Id(Pageable pageable, Long artistaId);

    List<Album> findAllByArtista_Id(Long idArtista);

    void deleteAlbumsByArtista_Id(Long idArtista);

}
