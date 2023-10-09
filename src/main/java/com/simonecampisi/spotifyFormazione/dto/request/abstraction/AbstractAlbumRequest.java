package com.simonecampisi.spotifyFormazione.dto.request.abstraction;

import com.simonecampisi.spotifyFormazione.model.Brano;
import com.simonecampisi.spotifyFormazione.model.enums.GenereMusicale;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public abstract class AbstractAlbumRequest implements IRequest {
    @NotBlank(message = "Titolo obbligatorio.")
    private String titolo;

    @NotNull(message = "Genere musicale obbligatorio.")
    private GenereMusicale genereMusicale;

    @NotBlank(message = "Immagine obbligatoria.")
    private String cover;

    @NotNull(message = "Artista obbligatorio.")
    private Long idArtista;
}
