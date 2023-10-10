package com.simonecampisi.spotifyFormazione.dto.request.abstraction;


import com.simonecampisi.spotifyFormazione.model.enums.GenereMusicale;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
public abstract class AbstractAlbumRequest implements IRequest {
    @NotBlank(message = "Titolo obbligatorio.")
    private String titolo;

    @NotNull(message = "Genere musicale obbligatorio.")
    private GenereMusicale genereMusicale;

    @NotNull(message = "Data di uscita obbligatoria.")
    private LocalDate dataUscita;


    @NotBlank(message = "Immagine obbligatoria.")
    private String cover;

    @NotNull(message = "Artista obbligatorio.")
    private Long idArtista;
}
