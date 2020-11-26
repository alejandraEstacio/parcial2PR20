package services;

import db.MySQLConnection;
import model.dto.Response;
import model.dto.TareaDTO;
import model.provider.TareaProvider;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("tareas")
@Stateless
public class TareaServices {

    @GET
    @Path("allDoTo")
    @Consumes("application/json")
    @Produces("application/json")
    public ArrayList<TareaDTO> getAlltareastoDo(){
        TareaProvider provider = new TareaProvider();
        ArrayList<TareaDTO> tareaDTOS = provider.getAllTareasByDoTo();
        return tareaDTOS;
    }

    @GET
    @Path("allDoing")
    @Consumes("application/json")
    @Produces("application/json")
    public ArrayList<TareaDTO> getAlltareasDoing(){
        TareaProvider provider = new TareaProvider();
        ArrayList<TareaDTO> tareaDTOS = provider.getAllTareasByDoing();
        return tareaDTOS;
    }

    @GET
    @Path("allDone")
    @Consumes("application/json")
    @Produces("application/json")
    public ArrayList<TareaDTO> getAlltareasDone(){
        TareaProvider provider = new TareaProvider();
        ArrayList<TareaDTO> tareaDTOS = provider.getAllTareasByDone();
        return tareaDTOS;
    }


    @POST
    @Path("create")
    @Consumes("application/json")
    public model.dto.Response createTarea(TareaDTO tareaDTO){
        TareaProvider tareaProvider = new TareaProvider();
        tareaProvider.insertTarea( tareaProvider.mapFromDTO(tareaDTO));
        return new Response("Operacion exitosa");
    }

    @PUT
    @Path("modificarToDo/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public model.dto.Response updateTareaToDo(@PathParam("id") String id){
        TareaProvider tareaProvider = new TareaProvider();
        boolean success = tareaProvider.updateTareaToDo(id);
        if(success)
            return new Response("Operacion exitosa");
        else
            return new Response("operacion fallida");
    }
    @PUT
    @Path("modificarDoing/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public model.dto.Response updateTareaDoing(@PathParam("id") String id){
        TareaProvider tareaProvider = new TareaProvider();
        boolean success = tareaProvider.updateTareaDoing(id);
        if(success)
            return new Response("Operacion exitosa");
        else
            return new Response("operacion fallida");
    }

    @PUT
    @Path("retrocderDone/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public model.dto.Response updateRetrocederDone(@PathParam("id") String id){
        TareaProvider tareaProvider = new TareaProvider();
        boolean success = tareaProvider.updateRetrocederDone(id);
        if(success)
            return new Response("Operacion exitosa");
        else
            return new Response("operacion fallida");
    }
    @PUT
    @Path("retrocderDoing/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public model.dto.Response updateRetrocederDoing(@PathParam("id") String id){
        TareaProvider tareaProvider = new TareaProvider();
        boolean success = tareaProvider.updateRetrocederDoing(id);
        if(success)
            return new Response("Operacion exitosa");
        else
            return new Response("operacion fallida");
    }

    @DELETE
    @Produces("application/json")
    @Path("delete/{id}")
    public model.dto.Response deleteTareaById(@PathParam("id") String id){
        TareaProvider provider = new TareaProvider();
        boolean success =provider.deleteTarea(id);
        if(success)
            return new Response("Operacion exitosa");
        else
            return new Response("operacion fallida");
    }
}
