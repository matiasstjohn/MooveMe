package repository;

import java.util.List;

public interface Repository<T> {

    T findOne(Long key);

    List<T> findAll();

    T create(T element);

    T update(Long key, T element);

    void delete(Long key);
}
