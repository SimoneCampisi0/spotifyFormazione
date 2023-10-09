package com.simonecampisi.spotifyFormazione.service;

import com.simonecampisi.spotifyFormazione.dto.request.CreateArtistaRequest;
import com.simonecampisi.spotifyFormazione.dto.request.ModificaArtistaRequest;
import com.simonecampisi.spotifyFormazione.dto.request.abstraction.AbstractArtistaRequest;
import com.simonecampisi.spotifyFormazione.dto.response.ArtistaResponse;
import com.simonecampisi.spotifyFormazione.model.Artista;
import com.simonecampisi.spotifyFormazione.model.enums.SortingOrder;
import com.simonecampisi.spotifyFormazione.repository.ArtistaRepository;
import com.simonecampisi.spotifyFormazione.service.abstraction.GenericService;
import com.simonecampisi.spotifyFormazione.service.helper.ArtistaHelper;
import com.simonecampisi.spotifyFormazione.service.helper.abstraction.IHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public ArtistaResponse modificaArtista(ModificaArtistaRequest request) {
        return helper.buildResponse(super.update(helper.updateArtistaFromRequest(super.read(request.getIdArtista()), request)));
    }

    public List<ArtistaResponse> findAllPage(Integer pageNumber, Integer pageSize, String sortBy, SortingOrder sortingOrder) {
        Pageable pageable;
        if (sortingOrder.equals(SortingOrder.ASC)) {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
        } else {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending());
        }
        return ((ArtistaRepository)repository).findAll(pageable).getContent()
                .stream()
                .map(a -> helper.buildResponse(a))
                .collect(Collectors.toList());
    }
}
