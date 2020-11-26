package entity;


import java.util.Date;

public class Tarea {
    private int id;
    private long fecha;
    private String tarea;
    private int toDo;
    private int doing;
    private int done;
    public Tarea(){
    }

    public Tarea(int id, long fecha, String tarea, int toDo, int doing, int done) {
        this.id = id;
        this.fecha = fecha;
        this.tarea = tarea;
        this.toDo = toDo;
        this.doing = doing;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getFecha() {
        return fecha;
    }

    public void setFecha(long fecha) {
        this.fecha = fecha;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public int getToDo() {
        return toDo;
    }

    public void setToDo(int toDo) {
        this.toDo = toDo;
    }

    public int getDoing() {
        return doing;
    }

    public void setDoing(int doing) {
        this.doing = doing;
    }

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }
}
