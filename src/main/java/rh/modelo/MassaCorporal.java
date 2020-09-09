/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.modelo;

/**
 *
 * @author Celina Sebastião
 */
public class MassaCorporal {
    
    private float altura;
    private float peso;

    public MassaCorporal() {
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Float.floatToIntBits(this.altura);
        hash = 19 * hash + Float.floatToIntBits(this.peso);
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
        final MassaCorporal other = (MassaCorporal) obj;
        if (Float.floatToIntBits(this.altura) != Float.floatToIntBits(other.altura)) {
            return false;
        }
        return Float.floatToIntBits(this.peso) == Float.floatToIntBits(other.peso);
    }

    @Override
    public String toString() {
        return "MassaCorporal{" + "altura=" + altura + ", peso=" + peso + '}';
    }
   
    
    
}
