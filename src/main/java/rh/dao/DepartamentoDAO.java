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

/**
 *
 * @author Celina Sebastião
 */
public class DepartamentoDAO {

    String INSERT = "INSERT INTO departamento values(?,?)";
    String UPDATE = "UPDATE departamento SET sigla = ?, nome_departamento = ?";
    String DELETE = "DELETE departamento where sigla = ?";
    String SELECT_ALL = "SELECT * FROM departamento";
    String SELECT_BY_NOME = "SELECT * FROM departamento where d.nome_departamento =?";
    String SELECT_BY_SIGLA = "SELECT sigla FROM departamento";

    static PreparedStatement ps = null;
    static Connection conn = null;

    private PreparedStatement stmt;
    private ResultSet resutSet;


    private ConexaoDB conexao;

    public void save(Departamento d) throws Exception {

        String INSERT1 = "insert into departamento values(?,?)";
        try {
            ConexaoDB.ligarBD();
            stmt = ConexaoDB.ligarBD().prepareStatement(INSERT1);
            stmt.setInt(1, d.getSigla());
            stmt.setString(2, d.getNome());
            stmt.executeUpdate();
            System.err.println(" Dados Guardados com Sucesso");

        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados: DepartamentoDAO:save " + ex.getLocalizedMessage());
        }
    }

    public List<Departamento> listaDepartamentos() throws Exception {
        List<Departamento> lista = new ArrayList<>();
        String SELECT_ALL1 = "select * from departamento";

        try {
            stmt = ConexaoDB.conexao.prepareStatement(SELECT_ALL1);
            resutSet = stmt.executeQuery();
            while (resutSet.next()) {

                Departamento d = new Departamento();
                d.setSigla(resutSet.getInt(1));
                d.setNome(resutSet.getString(2));
                lista.add(d);
                System.out.printf("valores");
                System.out.println(resutSet.getInt(1) + " " + resutSet.getString(2));
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao Ler dados: DepartamentoDAO:listaDepartamentos " + ex.getLocalizedMessage());
        }
        return lista;
    }

    public List<Departamento> listaDepartamentoByNome(String nomeDep) throws Exception {
        List<Departamento> lista = new ArrayList<>();
        String sql = "select * from departamento";

        try {

            conn = ConexaoDB.ligarBD();
            stmt = ConexaoDB.conexao.prepareStatement(sql);
            stmt.setString(1, nomeDep);
            resutSet = stmt.executeQuery();
            while (resutSet.next()) {

                Departamento d = new Departamento();
                d.setSigla(resutSet.getInt(1));
                d.setNome(resutSet.getString(2));
                lista.add(d);

            }

        } catch (SQLException ex) {
            System.err.println("Erro ao Ler dados: DepartamentoDAO:listaDepartamentos " + ex.getLocalizedMessage());
        }

        return lista;
    }

}
