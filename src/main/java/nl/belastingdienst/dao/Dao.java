package nl.belastingdienst.dao;

import java.util.*;

public interface Dao <T>{
    T find(Long id);
    List<T> getAll();
    void save(T t);
    void update(T t);
    void delete(T t);
}
