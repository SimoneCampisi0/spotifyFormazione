package com.simonecampisi.spotifyFormazione.service;

import com.simonecampisi.spotifyFormazione.dto.request.artista.CreateArtistaRequest;
import com.simonecampisi.spotifyFormazione.dto.request.artista.ModificaArtistaRequest;
import com.simonecampisi.spotifyFormazione.dto.response.artista.ArtistaResponse;
import com.simonecampisi.spotifyFormazione.model.Artista;
import com.simonecampisi.spotifyFormazione.model.enums.SortingOrder;
import com.simonecampisi.spotifyFormazione.repository.ArtistaRepository;
import com.simonecampisi.spotifyFormazione.service.abstraction.GenericService;
import com.simonecampisi.spotifyFormazione.service.helper.ArtistaHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistaService extends GenericService<Artista, Long> {

    @Autowired
    private ArtistaHelper helper;


    public ArtistaResponse createArtista(CreateArtistaRequest request) {
        return helper.buildResponse(super.create(helper.buildEntityFromRequest(request)));
    }

    public ArtistaResponse readArtista(Long idArtista) {
        return helper.buildResponse(super.read(idArtista));
    }

    public ArtistaResponse modificaArtista(ModificaArtistaRequest request) {
        return helper.buildResponse(super.update(helper.updateArtistaFromRequest(super.read(request.getIdArtista()), request)));
    }

    public Page<ArtistaResponse> findAllPage(Integer pageNumber, Integer pageSize, String sortBy, SortingOrder sortingOrder) {
        Pageable pageable;
        if (sortingOrder.equals(SortingOrder.ASC)) {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
        } else {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending());
        }

        List<ArtistaResponse> artistaResponseList = ((ArtistaRepository)repository).findAll(pageable)
                .stream()
                .map(a -> helper.buildResponse(a))
                .collect(Collectors.toList());

        return new PageImpl<ArtistaResponse>(artistaResponseList, pageable,  repository.findAll().size());
    }

    public ResponseEntity<?> deleteArtista(Long idArtista) throws Exception {
        Artista artista = super.read(idArtista);

        if(artista == null) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(idArtista);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
