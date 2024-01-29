package fr.kevin.cap_enterprise.service.interfaces;

public interface DAOFindBySlugInterface<T> {

    T findBySlug(String slug);

}
