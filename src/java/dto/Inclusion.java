/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

import sun.util.calendar.BaseCalendar.Date;

/**
 *
 * @author Rosemberg
 */
public class Inclusion {
    
    private Date fecha;
    private Grupo myGrupo;
    private Estudiante myEstudiante;

    public Inclusion() {
    }

    public Inclusion(Date fecha, Grupo myGrupo, Estudiante myEstudiante) {
        this.fecha = fecha;
        this.myGrupo = myGrupo;
        this.myEstudiante = myEstudiante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Grupo getMyGrupo() {
        return myGrupo;
    }

    public void setMyGrupo(Grupo myGrupo) {
        this.myGrupo = myGrupo;
    }

    public Estudiante getMyEstudiante() {
        return myEstudiante;
    }

    public void setMyEstudiante(Estudiante myEstudiante) {
        this.myEstudiante = myEstudiante;
    }
    
    
}
