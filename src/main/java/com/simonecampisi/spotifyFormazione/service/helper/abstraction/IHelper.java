package com.simonecampisi.spotifyFormazione.service.helper.abstraction;


import org.springframework.stereotype.Component;

@Component
public interface IHelper<T, A> {
    public T buildEntityFromRequest(A request);

}
