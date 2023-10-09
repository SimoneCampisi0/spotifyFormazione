package com.simonecampisi.spotifyFormazione.dto.response.album;

import com.simonecampisi.spotifyFormazione.model.Brano;
import com.simonecampisi.spotifyFormazione.model.enums.GenereMusicale;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@SuperBuilder
public class AlbumResponse {
    private Long idAlbum;

    private String titolo;

    private GenereMusicale genereMusicale;

    @Lob
    private byte [] cover;
}
