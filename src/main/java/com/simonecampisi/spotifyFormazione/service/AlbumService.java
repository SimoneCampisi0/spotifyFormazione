package com.simonecampisi.spotifyFormazione.service;

import com.simonecampisi.spotifyFormazione.dto.request.album.CreateAlbumRequest;
import com.simonecampisi.spotifyFormazione.dto.request.album.ModificaAlbumRequest;
import com.simonecampisi.spotifyFormazione.dto.response.album.AlbumResponse;
import com.simonecampisi.spotifyFormazione.model.Album;
import com.simonecampisi.spotifyFormazione.model.Brano;
import com.simonecampisi.spotifyFormazione.model.enums.SortingOrder;
import com.simonecampisi.spotifyFormazione.repository.AlbumRepository;
import com.simonecampisi.spotifyFormazione.service.abstraction.GenericService;
import com.simonecampisi.spotifyFormazione.service.helper.AlbumHelper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumService extends GenericService<Album, Long> {
    @Autowired
    private AlbumHelper helper;

    public AlbumResponse addAlbum(CreateAlbumRequest request) {
        return helper.buildResponse(super.create(helper.buildEntityFromRequest(request)));
    }

    public AlbumResponse modificaAlbum(ModificaAlbumRequest request) {
        return helper.buildResponse(super.update(helper.editAlbum(request,super.read(request.getIdAlbum()))));
    }

    public AlbumResponse readAlbum(Long idAlbum) {
        return helper.buildResponse(super.read(idAlbum));
    }

    public Page<AlbumResponse> listAlbum(Integer pageNumber, Integer pageSize, String sortBy, SortingOrder sortingOrder, String sortingFilter) {
        Pageable pageable;
        if (sortingOrder.equals(SortingOrder.ASC)) {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
        } else {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending());
        }

        List<AlbumResponse> listAlbumResponse = ((AlbumRepository)repository).findAll(pageable)
                .stream()
                .filter(album -> Strings.isEmpty(sortingFilter) || album.getTitolo().toLowerCase().contains(sortingFilter.toLowerCase()))
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

    public ResponseEntity<?> deleteAlbum(Long idAlbum) {
        Album album = super.read(idAlbum);

        if (album == null) {
            return ResponseEntity.notFound().build();
        }

        if (album.getElencoBrani().size() < 1) {
            super.deleteById(idAlbum);
            return ResponseEntity.ok(HttpStatus.OK);
        }

        boolean flag = false;
        for(Brano brano : album.getElencoBrani()) {
            if(brano.getElencoPlaylist().size() >= 1) {
                flag = true;
                break;
            }
        }

        if(flag) {
            return ResponseEntity.badRequest().build();
        }

        super.deleteById(idAlbum);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
