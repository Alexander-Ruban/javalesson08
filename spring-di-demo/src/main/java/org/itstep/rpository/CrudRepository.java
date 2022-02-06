package org.itstep.rpository;

import java.util.List;

public interface CrudRepository <E, ID> {
    void save(E entity);
    E update(E entity);
    List<E> findAll();
    E findById(ID id);
}
