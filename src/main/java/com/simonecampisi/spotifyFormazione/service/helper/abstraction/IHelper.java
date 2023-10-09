package com.simonecampisi.spotifyFormazione.service.helper.abstraction;


import com.simonecampisi.spotifyFormazione.dto.request.abstraction.IRequest;
import com.simonecampisi.spotifyFormazione.dto.response.abstraction.AbstractResponse;
import org.springframework.stereotype.Component;

@Component
public interface IHelper<T, A> {
    public T buildEntityFromRequest(A request);

}
