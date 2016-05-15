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
public class Grupo {
    private String id;
    private String codigo;
    private Integer cupo;
    private Materia myMateria;
    private Profesor titular;
    private ArrayList<HoraClase>horas;

    public Grupo() {
    }

    public Grupo(String id,String codigo, Integer cupo, Materia myMateria, Profesor titular, ArrayList<HoraClase> horas) {
        this.id=id;
        this.codigo = codigo;
        this.cupo = cupo;
        this.myMateria = myMateria;
        this.titular = titular;
        this.horas = horas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCupo() {
        return cupo;
    }

    public void setCupo(Integer cupo) {
        this.cupo = cupo;
    }

    public Materia getMyMateria() {
        return myMateria;
    }

    public void setMyMateria(Materia myMateria) {
        this.myMateria = myMateria;
    }

    public Profesor getTitular() {
        return titular;
    }

    public void setTitular(Profesor titular) {
        this.titular = titular;
    }

    public ArrayList<HoraClase> getHoras() {
        return horas;
    }

    public void setHoras(ArrayList<HoraClase> horas) {
        this.horas = horas;
    }
    
    
    
}
