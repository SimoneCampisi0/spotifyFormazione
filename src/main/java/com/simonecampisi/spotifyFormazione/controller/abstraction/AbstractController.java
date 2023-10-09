package com.simonecampisi.spotifyFormazione.controller.abstraction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.simonecampisi.spotifyFormazione.service.abstraction.GenericService;
@RestController
public abstract class AbstractController<T, ID> {
    @Autowired
    public GenericService<T, ID> service;
}
