package nl.belastingdienst.dao;

import lombok.extern.slf4j.*;
import nl.belastingdienst.domain.*;

import javax.inject.*;
import javax.persistence.*;
import java.util.*;

@Singleton @Slf4j
public class PersonDao implements Dao<Person> {

    @Inject
    private EntityManager em;

    @Override
    public Person find(Long id) {
        return em.find(Person.class, id);
    }

    @Override
    public List<Person> getAll() {
        TypedQuery<Person> query = em.createQuery("select p from Person p", Person.class);
        return query.getResultList();
    }

    @Override
    public void save(Person person) {
        performTransaction(() -> em.persist(person));
    }

    @Override
    public void update(Person person) {
        performTransaction(() -> em.merge(person));
    }

    @Override
    public void delete(Person person) {
        performTransaction(() -> em.remove(person));
    }

    public void performTransaction(Runnable runnable){
        em.getTransaction().begin();
        runnable.run();
        em.getTransaction().commit();
    }
}
