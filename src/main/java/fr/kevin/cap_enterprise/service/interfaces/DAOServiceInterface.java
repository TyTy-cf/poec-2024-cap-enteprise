package fr.kevin.cap_enterprise.service.interfaces;

import java.util.List;

public interface DAOServiceInterface<T> {

    List<T> findAll();

    T findById(Long id);

}
