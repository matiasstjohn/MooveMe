package repository;

import util.Entity;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<T extends Entity> implements Repository<T> {
    private List<T> list;

    public AbstractRepository() {
        this.list = new ArrayList<>();
    }

    @Override
    public T findOne(Long key) {
        for (T element: list) {
            if (element.getKey().equals(key)) return element;
        }

        return null;
    }

    @Override
    public List<T> findAll() {
        return list;
    }

    @Override
    public T create(T element) {
        list.add(element);
        return element;
    }

    @Override
    public T update(Long key, T element) {
        list.remove(findOne(key));
        list.add(element);
        return element;
    }

    @Override
    public void delete(Long key) {
        list.remove(findOne(key));
    }
}
