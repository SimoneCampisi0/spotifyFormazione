package com.simonecampisi.spotifyFormazione.service.helper;

import com.simonecampisi.spotifyFormazione.dto.request.abstraction.AbstractAlbumRequest;
import com.simonecampisi.spotifyFormazione.dto.request.album.ModificaAlbumRequest;
import com.simonecampisi.spotifyFormazione.dto.response.album.AlbumResponse;
import com.simonecampisi.spotifyFormazione.model.Album;
import com.simonecampisi.spotifyFormazione.model.Artista;
import com.simonecampisi.spotifyFormazione.model.Brano;
import com.simonecampisi.spotifyFormazione.repository.ArtistaRepository;
import com.simonecampisi.spotifyFormazione.service.helper.abstraction.IHelper;
import com.simonecampisi.spotifyFormazione.utils.ImageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Set;

@Component
public class AlbumHelper implements IHelper<Album, AbstractAlbumRequest> {
    @Autowired
    private ArtistaRepository artistaRepository;

    @Autowired
    private ArtistaHelper artistaHelper;

    @Autowired
    private ImageManager imageManager;

    public Album editAlbum(ModificaAlbumRequest request, Album album) {
        album.setCover(imageManager.base64ToImg(request.getCover()));
        album.setTitolo(request.getTitolo());
        album.setGenereMusicale(request.getGenereMusicale());
        album.setDataUscita(request.getDataUscita());
        album.setArtista(readArtista(request.getIdArtista()));
        return album;
    }

    public Artista readArtista(Long idArtista) {
        return artistaRepository.findById(idArtista).orElseThrow(
                () -> new RuntimeException("Elemento con ID "+idArtista+ " non trovato.")
        );
    }

    public String sumDuration(Set<Brano> elencoBrani) {
        Duration duration = Duration.ofMinutes(0);

        if(elencoBrani != null) {
            duration = elencoBrani.stream()
                    .map(b -> b.getDurata())
                    .reduce(duration, Duration::plus);
        }
        return duration.toMinutes() + ":" + duration.getSeconds() % 60;
    }
    @Override
    public Album buildEntityFromRequest(AbstractAlbumRequest request) {
        Album album = new Album();

        album.setTitolo(request.getTitolo());
        album.setGenereMusicale(request.getGenereMusicale());
        album.setArtista(readArtista(request.getIdArtista()));
        album.setDataUscita(request.getDataUscita());

        if(request.getCover().isEmpty()) {
            album.setCover(null);
        } else {
            album.setCover(imageManager.base64ToImg(request.getCover()));
        }

        return album;
    }

    public AlbumResponse buildResponse(Album album) {
        return AlbumResponse.builder()
                .idAlbum(album.getIdAlbum())
                .cover(album.getCover())
                .titolo(album.getTitolo())
                .genereMusicale(album.getGenereMusicale())
                .dataUscita(album.getDataUscita())
                .artistaResponse(artistaHelper.buildResponse(album.getArtista()))
                .numTracks(album.getElencoBrani() == null ? 0 : album.getElencoBrani().size())
                .totalDuration(sumDuration(album.getElencoBrani()))
                .build();

    }

}
