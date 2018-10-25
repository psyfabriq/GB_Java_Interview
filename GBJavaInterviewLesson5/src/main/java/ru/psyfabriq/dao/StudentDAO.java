package ru.psyfabriq.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface StudentDAO<T, Id> {

    public void persist(T  entity);

    public void update(T entity);

    public Optional<T> findById(Id id);

    public void delete(T entity);

    public List<T> findAll();

    public void deleteAll();

}
