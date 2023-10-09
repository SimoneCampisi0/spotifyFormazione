package com.simonecampisi.spotifyFormazione.service.abstraction;

import com.simonecampisi.spotifyFormazione.repository.abstraction.GenericRepository;
import com.simonecampisi.spotifyFormazione.service.helper.abstraction.IHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public abstract class GenericService<T, ID> {

    @Autowired
    private GenericRepository<T, ID> repository;

    public T create(T entity) {
        return repository.save(entity);
    }

    public T read(ID id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Elemento con ID "+id+ " non trovato.")
        );
    }

    public T update(T entity) {
        return repository.save(entity);
    }
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    public void deleteByEntity(T entity) {
        repository.delete(entity);
    }

    public List<T> findAll() {
        return repository.findAll();
    }
}
