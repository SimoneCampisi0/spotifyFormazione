package com.simonecampisi.spotifyFormazione.service;

import com.simonecampisi.spotifyFormazione.dto.request.brano.CreateBranoRequest;
import com.simonecampisi.spotifyFormazione.dto.response.brano.BranoResponse;
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

    public Brano buildBrano(CreateBranoRequest request) {
        Brano brano = helper.buildEntityFromRequest(request);
        brano.setAlbum(albumService.read(request.getIdAlbum()));
        return brano;
    }

    public BranoResponse addBrano(CreateBranoRequest request) {
        return helper.buildResponse(super.create(buildBrano(request)));
    }
}
