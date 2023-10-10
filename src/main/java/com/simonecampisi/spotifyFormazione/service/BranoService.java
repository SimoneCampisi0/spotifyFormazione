package com.simonecampisi.spotifyFormazione.service;

import com.simonecampisi.spotifyFormazione.dto.request.brano.CreateBranoRequest;
import com.simonecampisi.spotifyFormazione.dto.request.brano.ModificaBranoRequest;
import com.simonecampisi.spotifyFormazione.dto.response.brano.BranoResponse;
import com.simonecampisi.spotifyFormazione.model.Album;
import com.simonecampisi.spotifyFormazione.model.Brano;
import com.simonecampisi.spotifyFormazione.service.abstraction.GenericService;
import com.simonecampisi.spotifyFormazione.service.helper.BranoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranoService extends GenericService<Brano, Long> {
    @Autowired
    private BranoHelper helper;

    @Autowired
    private AlbumService albumService;


    public BranoResponse addBrano(CreateBranoRequest request) {
        return helper.buildResponse(super.create(helper.buildBranoCreate(request, albumService.read(request.getIdAlbum()))));
    }

    public BranoResponse modificaBrano(ModificaBranoRequest request) {
//        Brano brano = ; //Non riesce a eseguire l'update. Problema dipendenza ciclica
        return helper.buildResponse(super.update(helper.buildBranoUpdate(request, albumService.read(request.getIdAlbum()))));
    }

}
