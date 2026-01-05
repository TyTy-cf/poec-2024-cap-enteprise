package fr.kevin.cap_enterprise.service.interfaces;

public interface DAOFindByIdInterface<T> {

    T findById(Long id);

}
