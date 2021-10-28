package nl.belastingdienst.jpa.dao;


import nl.belastingdienst.*;
import nl.belastingdienst.dao.*;
import nl.belastingdienst.domain.*;
import nl.belastingdienst.jpa.util.AlternativeProducers;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.AddPackages;
import org.jboss.weld.junit5.auto.EnableAlternatives;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@EnableAutoWeld // CDI enablen in deze test
@AddPackages(App.class) // weld, pak alle classes in en onder het package van App op, dus alle in src/main/java
@AddBeanClasses(AlternativeProducers.class) // neem als extra ook deze class mee
@EnableAlternatives(AlternativeProducers.class) // hiermee overschrijf ik de gewone Producers class, zodat ik een andere entitymanager krijg, nl. H2.
class PersonDaoIT {

    @Inject
    private PersonDao target;

    @Test
    void save() {
        Person ryan = Person.builder().name("Ryan").build();
        target.save(ryan);

        List<Person> persons = target.getAll();
        assertThat(persons).allMatch(p -> p.getId() != 0);
    }


}
