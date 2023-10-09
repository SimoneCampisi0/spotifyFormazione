package com.simonecampisi.spotifyFormazione.service.helper.abstraction;


import com.simonecampisi.spotifyFormazione.dto.request.abstraction.AbstractRequest;
import com.simonecampisi.spotifyFormazione.dto.response.abstraction.AbstractResponse;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Component
public interface IHelper<T> {
    public T buildEntityFromRequest(AbstractRequest request);

    public AbstractResponse buildResponse(T entity);
}
