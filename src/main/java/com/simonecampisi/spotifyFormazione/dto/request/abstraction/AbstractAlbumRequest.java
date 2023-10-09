package com.simonecampisi.spotifyFormazione.dto.request.abstraction;

import com.simonecampisi.spotifyFormazione.model.Brano;
import com.simonecampisi.spotifyFormazione.model.enums.GenereMusicale;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
public abstract class AbstractAlbumRequest implements IRequest {

    private String titolo;

    private GenereMusicale genereMusicale;

    private String cover;

    private Long idArtista;
}
