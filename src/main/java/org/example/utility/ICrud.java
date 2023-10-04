package org.example.utility;

import java.util.List;
import java.util.Optional;

public interface ICrud<T,ID> {
//    void save(T entity);
//    void update(T entity);
//    void delete(Long id);
//    List<T> findAll();
//    T findById(Long id);
    T save(T entity);
    void update(T entity);
    Iterable<T> saveAll(Iterable<T> entities);
    void delete(T entity);
    void deleteById(ID id);
    Optional<T> findById(ID id);
    boolean existById(ID id);
    List<T> findAll();
    List<T> findByEntity(T entity);
    List<T> findByColumnNameAndValue(String columnName,String value);

}
