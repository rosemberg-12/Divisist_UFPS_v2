/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

import java.util.Objects;

/**
 *
 * @author Rosemberg
 */
public class HoraClase {
    private String dia;
    private byte hora;

    public HoraClase() {
    }

    public HoraClase(String dia, byte hora) {
        this.dia = dia;
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public byte getHora() {
        return hora;
    }

    public void setHora(byte hora) {
        this.hora = hora;
    }
    
    @Override
    public boolean equals(Object obj){
        
        HoraClase h=(HoraClase)obj;
        
        return dia.equals(h.getDia()) && hora==h.getHora();
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.dia);
        hash = 47 * hash + this.hora;
        return hash;
    }
    
}
