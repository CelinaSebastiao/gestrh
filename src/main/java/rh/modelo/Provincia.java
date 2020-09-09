/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.modelo;

import java.util.Objects;

/**
 *
 * @author Celina Sebastião
 */
public class Provincia {
    
    private Integer idProvincia;
    private String nomeProvincia;

    public Provincia() {
    }

    public Provincia(Integer idProvincia, String nomeProvincia) {
        this.idProvincia = idProvincia;
        this.nomeProvincia = nomeProvincia;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNomeProvincia() {
        return nomeProvincia;
    }

    public void setNomeProvincia(String nomeProvincia) {
        this.nomeProvincia = nomeProvincia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nomeProvincia);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Provincia other = (Provincia) obj;
        return Objects.equals(this.nomeProvincia, other.nomeProvincia);
    }

    @Override
    public String toString() {
        return "Provincia{" + "idProvincia=" + idProvincia + ", nomeProvincia=" + nomeProvincia + '}';
    }
    
    
    
}
