package db;

import java.sql.*;

public class MySQLConnection {

    private Connection connection;

    public MySQLConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//Importacion
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void connect(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tarea","root","");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean createDatabase(){
        boolean success = false;
        try {
            connect();
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS tareas(id INT PRIMARY KEY AUTO_INCREMENT, fecha , tarea VARCHAR (500), toDo INT (1), doing INT(1), done INT(1))");
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
            success = false;
        }finally {
            disconnect();
        }
        return success;
    }

    //Ordenes
    public boolean executeSQL(String sql){
        boolean success = false;
        try {
            connect();
            Statement statement = connection.createStatement();
            statement.execute(sql);
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
            success = false;
        }finally {
            disconnect();
        }
        return success;
    }
    /*public void executeSQL(String sql){
        try {
            connect();
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            disconnect();
        }
    }*/

    //Query
    public ResultSet query(String sql) {
        ResultSet output = null;
        try {
            connect();
            Statement statement = connection.createStatement();
            output = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }
}
