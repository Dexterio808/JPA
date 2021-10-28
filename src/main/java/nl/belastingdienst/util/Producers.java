package nl.belastingdienst.util;

import javax.enterprise.inject.*;
import javax.persistence.*;

public class Producers {

    @Produces // instantie aanmaken en aanmelden bij de DI container (Weld)
    public static EntityManager em() {
        // Application managed EntityManager
        return Persistence.createEntityManagerFactory("MySQL").createEntityManager();
    }
}
