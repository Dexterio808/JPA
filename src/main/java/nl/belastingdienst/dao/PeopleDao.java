package nl.belastingdienst.dao;

import lombok.*;
import nl.belastingdienst.domain.*;

import javax.inject.*;
import javax.persistence.*;
import java.util.*;


public class PeopleDao implements Dao<People>{

    @Inject
    private EntityManager em;

    @Override
    public People find(Long id) {
        return em.find(People.class, id);
    }

    @Override
    public List<People> getAll() {
        TypedQuery<People> query = em.createQuery("select p from People p", People.class);
        return query.getResultList();
    }

    @Override
    public void save(People people) {
        em.getTransaction().begin();
        em.persist(people);
        em.getTransaction().commit();
    }

    @Override
    public void update(People people) {
        em.getTransaction().begin();
        em.merge(find(people.getId()));
        em.getTransaction().commit();
    }

    @Override
    public void delete(People people) {
        em.getTransaction().begin();
        em.remove(find(people.getId()));
        em.getTransaction().commit();
    }
}
