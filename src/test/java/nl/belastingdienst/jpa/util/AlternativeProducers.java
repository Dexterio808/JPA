package nl.belastingdienst.jpa.util;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@Singleton
@Alternative
public class AlternativeProducers {

    @Produces // instantie aanmaken en aanmelden bij de DI container (Weld)
    public static EntityManager em() {
        // Application managed EntityManager
        return Persistence.createEntityManagerFactory("H2").createEntityManager();
    }

}
