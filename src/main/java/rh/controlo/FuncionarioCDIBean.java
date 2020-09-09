/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.controlo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import rh.modelo.Funcionario;

/**
 *
 * @author Celina Sebastião
 */
@Named(value = "funcionarioCDIBean")
@SessionScoped

public class FuncionarioCDIBean implements Serializable{

    /**
     * Creates a new instance of FuncionarioCDIBean
     */
    Funcionario funcionario = new Funcionario();
//    Funcionario funcionario1 = new Funcionario("Celina","Sebastião","Informatica",150000);
//    Funcionario funcionario2 = new Funcionario("Plérido","Paulino","Planeamento",150000);
//    Funcionario funcionario3 = new Funcionario("Vânia","Sebastião","Manutenção",100000);
//    
    List <Funcionario> funcionarios = new ArrayList<>();
    
    @PostConstruct
    public void inicializar() {
        
        
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    
    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
   public String guardar(){
    return "resultado";
   } 
 
  public String salvar()
  {
     funcionarios.add(funcionario);
     FacesContext facesContext = FacesContext.getCurrentInstance();
             String meu="Celina Sebastiao";
     FacesMessage facesMessage = new FacesMessage(null,"Funcionario Guardado com Sucesso!");
     facesContext.addMessage(null, facesMessage);
     return "lista_funcionarios";
  }   
   

}
