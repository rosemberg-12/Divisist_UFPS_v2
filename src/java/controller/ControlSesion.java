/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.Estudiante_DAO;

import dto.Estudiante;

/**
 *
 * @author Rosemberg
 */
public class ControlSesion {

    public boolean validarSesion(Estudiante e) {
        Estudiante_DAO es=new Estudiante_DAO();
        
        return es.validarSesion(e);
    }

    public String getNombreEstudiante(Estudiante e) {
        Estudiante_DAO es=new Estudiante_DAO();
        
        return es.getNombreEstudiante(e);
        
        
    }
    
}
