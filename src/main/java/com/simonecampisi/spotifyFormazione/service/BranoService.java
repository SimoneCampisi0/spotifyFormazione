package com.simonecampisi.spotifyFormazione.service;

import com.simonecampisi.spotifyFormazione.dto.request.brano.CreateBranoRequest;
import com.simonecampisi.spotifyFormazione.dto.request.brano.ModificaBranoRequest;
import com.simonecampisi.spotifyFormazione.dto.response.brano.BranoResponse;
import com.simonecampisi.spotifyFormazione.model.Brano;
import com.simonecampisi.spotifyFormazione.model.Playlist;
import com.simonecampisi.spotifyFormazione.repository.BranoRepository;
import com.simonecampisi.spotifyFormazione.repository.PlaylistRepository;
import com.simonecampisi.spotifyFormazione.service.abstraction.GenericService;
import com.simonecampisi.spotifyFormazione.service.helper.BranoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranoService extends GenericService<Brano, Long> {
    @Autowired
    private BranoHelper helper;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private PlaylistRepository playlistRepository;


    public BranoResponse addBrano(CreateBranoRequest request) {
        return helper.buildResponse(super.create(helper.buildBranoCreate(request, albumService.read(request.getIdAlbum()))));
    }

    public List<BranoResponse> listaBrani(Long idAlbum) {
        return ((BranoRepository)repository).findAllByAlbum_IdAlbum(idAlbum)
                .stream()
                .map(brano -> helper.buildResponse(brano))
                .collect(Collectors.toList());
    }

    public List<BranoResponse> listaBraniPerPlaylist(Long idPlaylist) {
        Playlist playlist = playlistRepository.findById(idPlaylist).orElseThrow(() -> new RuntimeException("Elemento con ID "+idPlaylist+ " non trovato."));
        return ((BranoRepository)repository).findAllByElencoPlaylistContains(playlist)
                .stream()
                .map(brano -> helper.buildResponse(brano))
                .collect(Collectors.toList());
    }

    public List<BranoResponse> listaBraniPerInserimento() {
        return super.findAll().stream()
                .map(brano -> helper.buildResponse(brano))
                .collect(Collectors.toList());
    }



    public BranoResponse modificaBrano(ModificaBranoRequest request) {
        return helper.buildResponse(super.update(helper.buildBranoUpdate(request, albumService.read(request.getIdAlbum()))));
    }

}
