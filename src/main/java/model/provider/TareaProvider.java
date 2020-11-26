package model.provider;

import db.MySQLConnection;
import entity.Tarea;
import model.dto.TareaDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TareaProvider {

    //proveer informacion

    public void insertTarea(Tarea tarea) {
        MySQLConnection connection = new MySQLConnection();
        String sql = "INSERT INTO tareas(id, fecha, tarea, toDo, doing, done) VALUES ($id, $fecha, '$tarea', $toDo, $doing, $done)";
        sql = sql.replace("$id", ""+tarea.getId());
        sql = sql.replace("$fecha", ""+tarea.getFecha());
        sql = sql.replace("$tarea", tarea.getTarea());
        sql = sql.replace("$toDo", ""+1);
        sql = sql.replace("$doing", ""+tarea.getDoing());
        sql = sql.replace("$done", ""+tarea.getDone());
        connection.executeSQL(sql);
    }

    public boolean updateTareaToDo(String id) {
        MySQLConnection connection = new MySQLConnection();
        String sql = "UPDATE tareas SET toDo=0, doing = 1 WHERE tareas.id="+id;
        return connection.executeSQL(sql);
    }
    public boolean updateTareaDoing(String id) {
        MySQLConnection connection = new MySQLConnection();
        String sql = "UPDATE tareas SET doing = 0, done = 1 WHERE tareas.id="+id;
        return connection.executeSQL(sql);
    }

    public boolean updateRetrocederDone(String id) {
        MySQLConnection connection = new MySQLConnection();
        String sql = "UPDATE tareas SET toDo=0, doing = 1, done =0 WHERE tareas.id="+id;
        return connection.executeSQL(sql);
    }
    public boolean updateRetrocederDoing(String id) {
        MySQLConnection connection = new MySQLConnection();
        String sql = "UPDATE tareas SET toDo=1, doing = 0, done =0 WHERE tareas.id="+id;
        return connection.executeSQL(sql);
    }


    public boolean deleteTarea(String id) {
        MySQLConnection connection = new MySQLConnection();
        String sql= "DELETE FROM tareas WHERE id="+id;
        return connection.executeSQL(sql);
    }

    public ArrayList<TareaDTO> getAllTareasByDoTo() {
        ArrayList<TareaDTO> output = new ArrayList<>();
        MySQLConnection connection = new MySQLConnection();
        try {
            String sql = "SELECT id, fecha, tarea, toDo, doing, done FROM tareas WHERE toDo="+1;
            ResultSet resultSet = connection.query(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Long fecha = resultSet.getLong("fecha");
                String tarea = resultSet.getString("tarea");
                int doTo = resultSet.getInt("toDo");
                int doing = resultSet.getInt("doing");
                int done = resultSet.getInt("done");
                output.add(new TareaDTO(id, fecha, tarea, doTo, doing, done));
               /* output.add(new TareaDTO(
                        resultSet.getInt(1),
                        resultSet.getLong(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6)
                ));*/

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Control alt L
        //Command option L
        connection.disconnect();
        return output;
    }

    public ArrayList<TareaDTO> getAllTareasByDoing() {
        ArrayList<TareaDTO> output = new ArrayList<>();
        MySQLConnection connection = new MySQLConnection();
        try {
            String sql = "SELECT id, fecha, tarea, toDo, doing, done FROM tareas WHERE doing="+1;
            ResultSet resultSet = connection.query(sql);
            while (resultSet.next()) {
                output.add(new TareaDTO(
                        resultSet.getInt(1),
                        resultSet.getLong(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Control alt L
        //Command option L
        connection.disconnect();
        return output;
    }

    public ArrayList<TareaDTO> getAllTareasByDone() {
        ArrayList<TareaDTO> output = new ArrayList<>();
        MySQLConnection connection = new MySQLConnection();
        try {
            String sql = "SELECT id, fecha, tarea, toDo, doing, done FROM tareas WHERE done=" +1;
            ResultSet resultSet = connection.query(sql);
            while (resultSet.next()) {
                output.add(new TareaDTO(
                        resultSet.getInt(1),
                        resultSet.getLong(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Control alt L
        //Command option L
        connection.disconnect();
        return output;
    }
    public Tarea mapFromDTO(TareaDTO dto){
        Tarea tarea = new Tarea();
        tarea.setId(dto.getId());
        tarea.setFecha(dto.getFecha());
        tarea.setTarea(dto.getTarea());
        tarea.setToDo(dto.getToDo());
        tarea.setDoing(dto.getDoing());
        tarea.setDone(dto.getDone());

        return tarea;
    }

}
