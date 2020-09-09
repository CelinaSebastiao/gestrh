/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.dao;

import db.util.ConexaoDB;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import rh.modelo.Departamento;
import rh.modelo.Funcionario;

/**
 *
 * @author Celina Sebastião
 */
public class FuncionarioDAO {

    String INSERT = "INSERT INTO departamento values(?,?)";
    String UPDATE = "UPDATE departamento SET sigla = ?, nome_departamento = ?";
    String DELETE = "DELETE departamento where sigla = ?";
    String SELECT_ALL = "SELECT * FROM departamento";
    String SELECT_BY_NOME = "SELECT * FROM departamento where d.nome_departamento =?";
    String SELECT_BY_SIGLA = "SELECT sigla FROM departamento";

    static PreparedStatement ps = null;
    static Connection conn = null;

    private ConexaoDB conexao;
    
    

    public void save1(Departamento d) throws Exception {

        try {
            conn = ConexaoDB.ligarBD();
            System.out.println("CONEXAO OK");
            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, d.getSigla());
            ps.setString(2, d.getNome());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados: DepartamentoDAO:save " + ex.getLocalizedMessage());
        }

    }

    public void save(Funcionario f) throws Exception {
     PreparedStatement stmt;
     ResultSet resutSet;
     
        stmt = null;
        resutSet = null;
        String INSERT1 = "insert into funcionario values(?,?)";
        try {
            ConexaoDB.ligarBD();
            stmt = ConexaoDB.ligarBD1().prepareStatement(INSERT1);
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getSobrenome());
            stmt.executeUpdate();
            System.err.println(" Dados Guardados com Sucesso");

        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados: DepartamentoDAO:save " + ex.getLocalizedMessage());
        }
    }

    public List<Departamento> listaDepartamentos() throws Exception
    {
        List<Departamento> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet resutSet = null;
        ConexaoDB conn = null;
        
        try{
            
            conn = (ConexaoDB) ConexaoDB.ligarBD();
            stmt = ConexaoDB.conexao.prepareStatement(SELECT_ALL);
            resutSet = stmt.executeQuery();
            while(resutSet.next()){
            
                Departamento d = new Departamento();
                d.setSigla(resutSet.getInt(1));
                d.setNome(resutSet.getString(2));
                lista.add(d);
            }
            
        }catch(SQLException ex){
         System.err.println("Erro ao Ler dados: DepartamentoDAO:listaDepartamentos " + ex.getLocalizedMessage());  
        } 
     return lista;
    }
    
    
     public List<Departamento> listaDepartamentoByNome(String nomeDep) throws Exception
    {
        List<Departamento> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet resutSet = null;
        ConexaoDB conn = null;
        String sql = "select * from departamento";
        
        try{
            
            conn = (ConexaoDB) ConexaoDB.ligarBD();
            stmt = ConexaoDB.conexao.prepareStatement(sql);
            stmt.setString(1, nomeDep);
            resutSet = stmt.executeQuery();
            while(resutSet.next()){
            
                Departamento d = new Departamento();
                d.setSigla(resutSet.getInt(1));
                d.setNome(resutSet.getString(2));
                lista.add(d);
            }
            
        }catch(SQLException ex){
         System.err.println("Erro ao Ler dados: DepartamentoDAO:listaDepartamentos " + ex.getLocalizedMessage());  
        }    
     return lista;
    }
    
//    public List<Departamento> listarDepartamentos() throws SQLException, Exception {
//        stmt = null;
//        resutSet = null;
//        String sql = "select * from departamento";
//        ArrayList<Departamento> listaDep = new ArrayList<>();
//
//        try {
//            ConexaoDB.ligarBD();
//            stmt = ConexaoDB.conexao.prepareStatement(sql);
//            resutSet = stmt.executeQuery();
//
//            while (resutSet.next()) {
//                d.setSigla(resutSet.getInt(1));
//                d.setNome(resutSet.getString(2));
//                listaDep.add(d);
//            }
////            return listaDep;
//        } catch (SQLException ex) {
//                System.err.println("Erro ao listar dados: DepartamentoDAO:listarDepDAO " + ex.getLocalizedMessage());
//        }
//        return listaDep;
//    }

}
