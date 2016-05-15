/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

import java.util.ArrayList;

/**
 *
 * @author Rosemberg
 */
public class Programa {
    private String nombre;
    private String codigo;
    private ArrayList<Materia>Pemsun;

    public Programa() {
    }

    public Programa(String nombre, String codigo, ArrayList<Materia> Pemsun) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.Pemsun = Pemsun;
    }

        
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Materia> getPemsun() {
        return Pemsun;
    }

    public void setPemsun(ArrayList<Materia> Pemsun) {
        this.Pemsun = Pemsun;
    }
    
    
}
