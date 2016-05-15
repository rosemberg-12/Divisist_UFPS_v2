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
public class Materia {
    private String nombre;
    private String codigo;
    private Integer creditos;
    private Materia requisito;
    private ArrayList<Programa> myPrograma;

    public Materia() {
    }

    public Materia(String nombre, String codigo, Integer creditos,Materia requisito) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.requisito = requisito;
    }

    public Materia getRequisito() {
        return requisito;
    }

    public void setRequisito(Materia requisito) {
        this.requisito = requisito;
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

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public ArrayList<Programa> getMyPrograma() {
        return myPrograma;
    }

    public void setMyPrograma(ArrayList<Programa> myPrograma) {
        this.myPrograma = myPrograma;
    }
    
    
}

