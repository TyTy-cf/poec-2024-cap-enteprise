package fr.kevin.cap_enterprise.service.interfaces;

import java.util.List;

public interface DAOEntityInterface<T> extends
            DAOFindByIdInterface<T>
{

    List<T> findAll();

}
