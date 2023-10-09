package com.simonecampisi.spotifyFormazione.dto.response.album;

import com.simonecampisi.spotifyFormazione.dto.response.abstraction.AbstractAlbumResponse;
import com.simonecampisi.spotifyFormazione.dto.response.artista.ArtistaResponse;
import com.simonecampisi.spotifyFormazione.model.Brano;
import com.simonecampisi.spotifyFormazione.model.enums.GenereMusicale;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.Set;
@Data
@SuperBuilder
public class AlbumResponse extends AbstractAlbumResponse {
}
