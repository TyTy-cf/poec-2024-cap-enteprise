package fr.kevin.cap_enterprise.service;

import java.util.List;

public interface DAOServiceInterface<T> {

    List<T> findAll();

    T findById(Long id);

}
