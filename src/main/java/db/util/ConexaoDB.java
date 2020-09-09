package db.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;


/**
 *
 * @author Celina Sebastião
 */
public class ConexaoDB {

    public static Connection conexao;
    public static Statement statement;
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; 
    private static final String URL = "jdbc:mysql://localhost:3306/gestaorh?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";   
    
   public static Connection ligarBD() throws Exception {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException notFoundException) {
            throw new Exception(notFoundException.getMessage());
        }
    }

   private static void close(Connection conn,
            Statement stmt, ResultSet rs)
            throws Exception {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }
   
    public static Connection ligarBD1() {
        String connectionUrl = "jdbc:mysql://localhost:3306/gestaorh?useSSL=false&serverTimezone=UTC";
        String DiverMYSQL8 = "com.mysql.cj.jdbc.Driver";
        String DiverMYSQL5 = "com.mysql.jdbc.Driver";
        String user = "root";
        String password = "root";
        Connection conn = null;
        
        try {
            Class.forName(DiverMYSQL8);
            return conn = DriverManager.getConnection(connectionUrl, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro de conexao com a base de dados " + e);
            return null;
        }
    }
}
