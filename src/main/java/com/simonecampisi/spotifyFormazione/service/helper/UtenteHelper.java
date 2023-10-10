package com.simonecampisi.spotifyFormazione.service.helper;

import com.simonecampisi.spotifyFormazione.dto.request.abstraction.AbstractUtenteRequest;
import com.simonecampisi.spotifyFormazione.dto.request.utente.ModificaUtenteRequest;
import com.simonecampisi.spotifyFormazione.dto.response.utente.UtenteResponse;
import com.simonecampisi.spotifyFormazione.dto.response.utente.ViewUtenteResponse;
import com.simonecampisi.spotifyFormazione.model.Brano;
import com.simonecampisi.spotifyFormazione.model.Utente;
import com.simonecampisi.spotifyFormazione.service.helper.abstraction.IHelper;
import com.simonecampisi.spotifyFormazione.utils.ImageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Set;

@Component
public class UtenteHelper implements IHelper<Utente, AbstractUtenteRequest> {
    @Autowired
    private ImageManager imageManager;

    public String durationToString (Duration duration) {
        return duration.toMinutes() + ":" + duration.getSeconds() % 60;
    }

    public Duration getDurationFromBrani(Set<Brano> elencoBrani) {
        Duration duration = Duration.ofMinutes(0);

        if(elencoBrani != null) {
            duration = elencoBrani.stream()
                    .map(Brano::getDurata)
                    .reduce(duration, Duration::plus);
        }
        return duration;
    }

    @Override
    public Utente buildEntityFromRequest(AbstractUtenteRequest request) {
        return Utente.builder()
                .nomeUtente(request.getNomeUtente())
                .email(request.getEmail())
                .imgProfilo(imageManager.base64ToImg(request.getImgProfilo()))
                .build();
    }

    public UtenteResponse buildResponse(Utente utente) {
        return UtenteResponse.builder()
                .idUtente(utente.getIdUtente())
                .nomeUtente(utente.getNomeUtente())
                .email(utente.getEmail())
                .imgProfilo(utente.getImgProfilo())
                .build();
    }

    public ViewUtenteResponse buildUtenteForList(Utente utente) {
        return ViewUtenteResponse.builder()
                .idUtente(utente.getIdUtente())
                .nomeUtente(utente.getNomeUtente())
                .email(utente.getEmail())
                .imgProfilo(utente.getImgProfilo())
                .numPlaylist(utente.getElencoPlaylist().size())
                .numBraniPlaylist(utente.getElencoPlaylist()
                        .stream()
                        .map(p -> p.getElencoBrani().size())
                        .count()
                )
                .totaleDurataPlayList(durationToString(utente.getElencoPlaylist()
                        .stream()
                        .map(p -> getDurationFromBrani(p.getElencoBrani()))
                        .reduce(Duration.ZERO, Duration::plus))
                )
                .build();
    }

    public Utente buildEntityForUpdate(ModificaUtenteRequest request, Utente utente) {
        utente.setNomeUtente(request.getNomeUtente());
        utente.setEmail(request.getEmail());
        utente.setImgProfilo(imageManager.base64ToImg(request.getImgProfilo()));
        return utente;
    }
}
