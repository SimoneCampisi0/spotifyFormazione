package com.simonecampisi.spotifyFormazione.service;

import com.simonecampisi.spotifyFormazione.dto.request.album.CreateAlbumRequest;
import com.simonecampisi.spotifyFormazione.dto.response.album.AlbumResponse;
import com.simonecampisi.spotifyFormazione.model.Album;
import com.simonecampisi.spotifyFormazione.service.abstraction.GenericService;
import com.simonecampisi.spotifyFormazione.service.helper.AlbumHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService extends GenericService<Album, Long> {
    @Autowired
    private AlbumHelper helper;

    public AlbumResponse addAlbum(CreateAlbumRequest request) {
        Album album = super.create(helper.buildEntityFromRequest(request));
        return helper.buildResponse(album);
    }
}
