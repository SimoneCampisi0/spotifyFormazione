package com.simonecampisi.spotifyFormazione.service;

import com.simonecampisi.spotifyFormazione.dto.request.album.CreateAlbumRequest;
import com.simonecampisi.spotifyFormazione.dto.response.album.AlbumResponse;
import com.simonecampisi.spotifyFormazione.model.Album;
import com.simonecampisi.spotifyFormazione.model.enums.SortingOrder;
import com.simonecampisi.spotifyFormazione.repository.AlbumRepository;
import com.simonecampisi.spotifyFormazione.service.abstraction.GenericService;
import com.simonecampisi.spotifyFormazione.service.helper.AlbumHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumService extends GenericService<Album, Long> {
    @Autowired
    private AlbumHelper helper;

    public AlbumResponse addAlbum(CreateAlbumRequest request) {
        Album album = super.create(helper.buildEntityFromRequest(request));
        return helper.buildResponse(album);
    }

    public Page<AlbumResponse> listAlbum(Integer pageNumber, Integer pageSize, String sortBy, SortingOrder sortingOrder) {
        Pageable pageable;
        if (sortingOrder.equals(SortingOrder.ASC)) {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
        } else {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending());
        }

        List<AlbumResponse> listAlbumResponse = ((AlbumRepository)repository).findAll(pageable)
                .stream()
                .map(album -> helper.buildResponse(album))
                .collect(Collectors.toList());

        return new PageImpl<AlbumResponse>(listAlbumResponse, pageable,  ((AlbumRepository)repository).findAll().size());
    }

    public Page<AlbumResponse> listAlbumPerArtista(Integer pageNumber, Integer pageSize, String sortBy, SortingOrder sortingOrder, Long idArtista) {
        Pageable pageable;
        if (sortingOrder.equals(SortingOrder.ASC)) {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
        } else {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending());
        }

        List<AlbumResponse> albumResponseList = ((AlbumRepository)repository).findAllByArtista_Id(pageable, idArtista)
                .stream()
                .map(album -> helper.buildResponse(album))
                .collect(Collectors.toList());

        return new PageImpl<AlbumResponse>(albumResponseList, pageable,  ((AlbumRepository)repository).findAllByArtista_Id(idArtista).size());

    }

}
