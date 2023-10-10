package com.simonecampisi.spotifyFormazione.service;

import com.simonecampisi.spotifyFormazione.dto.request.utente.CreateUtenteRequest;
import com.simonecampisi.spotifyFormazione.dto.response.utente.UtenteResponse;
import com.simonecampisi.spotifyFormazione.dto.response.utente.ViewUtenteResponse;
import com.simonecampisi.spotifyFormazione.model.Utente;
import com.simonecampisi.spotifyFormazione.model.enums.SortingOrder;
import com.simonecampisi.spotifyFormazione.repository.UtenteRepository;
import com.simonecampisi.spotifyFormazione.service.abstraction.GenericService;
import com.simonecampisi.spotifyFormazione.service.helper.UtenteHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtenteService extends GenericService<Utente, Long> {

    @Autowired
    private UtenteHelper helper;

    public UtenteResponse createUtente(CreateUtenteRequest request) {
        return helper.buildResponse(super.create(helper.buildEntityFromRequest(request)));
    }

    public Page<ViewUtenteResponse> findAllUtenti(Integer pageNumber, Integer pageSize, String sortBy, SortingOrder sortingOrder) {
        Pageable pageable;
        if (sortingOrder.equals(SortingOrder.ASC)) {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
        } else {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending());
        }

        List<ViewUtenteResponse> utenteList = ((UtenteRepository)repository).findAll(pageable)
                .stream()
                .map(utente -> helper.buildUtenteForList(utente))
                .collect(Collectors.toList());


        return new PageImpl<ViewUtenteResponse>(utenteList, pageable,  repository.findAll().size());
    }
}
