package nl.belastingdienst;

import nl.belastingdienst.dao.*;
import org.jboss.weld.environment.se.*;

import javax.inject.*;

public class App {

    @Inject
    private PersonDao personDao;

    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer weldContainer = weld.initialize(); // de engine/container

        App app = weldContainer.select(App.class).get(); // vanaf nu kan ik in App en zijn dependencies (dao) @Inject gebruiken.
        app.start();

        weld.shutdown();
    }

    private void start(){

    }
}
