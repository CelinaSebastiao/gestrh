/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.controlo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import rh.dao.DepartamentoDAO;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import rh.modelo.Departamento;

/**
 *
 * @author Celina Sebastião
 */
@Named(value = "departamentoCDIBean")
@RequestScoped

public class DepartamentoCDIBean{

    /**
     * Creates a new instance of DepartamentoCDIBean
     */
    
   Departamento departamento; 
   DepartamentoDAO dao;
   List<Departamento> listadepartamentos;
   
   
  @PostConstruct  
   public void inicializar()
   {
       departamento = new Departamento(); 
       dao = new DepartamentoDAO();
       listadepartamentos = new ArrayList<>(); 
       try {
           
       } catch (Exception ex) {
           Logger.getLogger(DepartamentoCDIBean.class.getName()).log(Level.SEVERE, null, ex);
       }
       try {
           listadepartamentos = dao.listaDepartamentos();
       } catch (Exception ex) {
           Logger.getLogger(DepartamentoCDIBean.class.getName()).log(Level.SEVERE, null, ex);
       }
   }

   
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public DepartamentoDAO getDao() {
        return dao;
    }

    public void setDao(DepartamentoDAO dao) {
        this.dao = dao;
    }

    public List<Departamento> getListadepartamentos() {
        return listadepartamentos;
    }

    public void setListadepartamentos(List<Departamento> listadepartamentos) {
        this.listadepartamentos = listadepartamentos;
    }
    

   public String save() throws Exception{
       
       dao.save(departamento);
       departamento = new Departamento();
       return "departamento";
   }
    
   
}
