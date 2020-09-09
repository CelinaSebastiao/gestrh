/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
/**
 *
 * @author Celina Sebastião
 */
public class AppMYSQL {
    
    public static void main(String[] args) throws Exception {
         String LISTA_DEPARTAMENTOS="SELECT * FROM departamento";
        
        try(Connection conn = ConexaoDB.ligarBD()) {
        
            PreparedStatement ps = conn.prepareStatement(LISTA_DEPARTAMENTOS);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+" "+rs.getString(2));
            }
        }catch(SQLException ex){
                System.err.print("Erro na leitura de dados " +ex);
        }
    }
}
