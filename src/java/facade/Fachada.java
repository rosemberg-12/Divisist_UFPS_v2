/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import controller.ControlInclusion;
import controller.ControlSesion;
import dto.Estudiante;

/**
 *
 * @author Rosemberg
 */
public class Fachada {
    
    public boolean validarInicioSesion(Estudiante e){
        System.out.println(e.getCodigo());
        return new ControlSesion().validarSesion(e);
        
    }
    
    public String getNombreEstudiante(Estudiante e){
        
        return new ControlSesion().getNombreEstudiante(e);
        
    }
    
    public String getTablaPickGrupos(Estudiante e){
        return new ControlInclusion().getTablaPickGrupos(e);
    }
    
    public String getTablaMatriculadas(Estudiante e){
        return new ControlInclusion().getTablaMatriculadas(e);
    }
    
    public String getHorasGrupo( String id){
        System.out.println("Entra aca");
        return new ControlInclusion().getHorasGrupo(id);
    }
    public String incluir(String codigoGrupo, String codigoE){
        boolean bol=new ControlInclusion().incluir(codigoGrupo, codigoE);
        if(bol)
            return "La materia se ha incluido exitosamente";
        return "No se puede incluir porque ya hay materias incluidas en este mismo horario" ;
    }
}
