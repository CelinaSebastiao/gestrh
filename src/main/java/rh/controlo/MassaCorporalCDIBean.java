/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.controlo;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import rh.modelo.MassaCorporal;

/**
 *
 * @author Celina Sebastião
 */
@Named(value = "massaCorporalCDIBean")
@RequestScoped


public class MassaCorporalCDIBean {

    /**
     * Creates a new instance of MassaCorporalCDIBean
     */
    
     MassaCorporal massaCorporal;
    @PostConstruct
    
public void inicializar()
{
    massaCorporal = new MassaCorporal();
}

    public MassaCorporal getMassaCorporal() {
        return massaCorporal;
    }

    public void setMassaCorporal(MassaCorporal massaCorporal) {
        this.massaCorporal = massaCorporal;
    }

    public String mostrarPeso(){
    return "Peso "+getMassaCorporal().getPeso();
    }
    
    public float calculoMassa(float altura, float peso)
    {
        float imc;
        imc = (float) (peso/(Math.pow(altura,2)));
        
        return imc;
    }
}
