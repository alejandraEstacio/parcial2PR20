package config;

import services.DatabaseServices;
import services.EchoService;
import services.TareaServices;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("api")
public class ApplicationConfig extends Application {

    //Control + O


    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(EchoService.class);
        resources.add(DatabaseServices.class);
        resources.add(TareaServices.class);
        return resources;
    }
}
