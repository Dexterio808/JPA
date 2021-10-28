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
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
    }

    @Override
    public void update(Person person) {
        em.getTransaction().begin();
        em.merge(find(person.getId()));
        em.getTransaction().commit();
    }

    @Override
    public void delete(Person person) {
        em.getTransaction().begin();
        em.remove(find(person.getId()));
        em.getTransaction().commit();
    }
}
