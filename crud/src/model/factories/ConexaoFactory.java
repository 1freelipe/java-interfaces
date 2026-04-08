package model.factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/fatec";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

public static Connection getConnection() {

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(URL, USER, PASSWORD);
    } catch(ClassNotFoundException e) {
        System.out.println("Driver do banco de dados não localizado");
        e.printStackTrace();
        return null;
    } catch(SQLException e) {
        System.out.println("Erro ao se conectar com o banco de dados");
        e.printStackTrace();
        return null;
    }
} 

    // public static Connection getConnection() throws SQLException{
    //     return DriverManager.getConnection(URL, USER, PASSWORD);
    // }
}
